import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class MainPOI {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        File file = new File("D:\\test\\testPos.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        boolean start = false;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (start) {
                Cell cellPos = row.getCell(0);
                Cell cellMainPos = row.getCell(1);
                CellType cellType = cellPos.getCellTypeEnum();
                String pos;
                String mainPos;
                switch (cellType) {
                    case NUMERIC:
                        int p = (int) cellPos.getNumericCellValue();
                        int mp = (int) cellMainPos.getNumericCellValue();
                        pos = String.valueOf(p);
                        mainPos = String.valueOf(mp);
                        map.put(pos, mainPos);
                        System.out.print("pos: " + p + " - mainPos:" + mp + "\n");
                        break;
                    case STRING:
                        pos = cellPos.getStringCellValue();
                        mainPos = cellMainPos.getStringCellValue();
                        map.put(pos, mainPos);
                        System.out.print("pos: " + pos + " - mainPos:" + mainPos + "\n");
                        break;
                    default:
                        break;
                }
            }
            start = true;
        }
    }

}
