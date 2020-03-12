import java.io.*;

public class ReadFile {

    static String input = "C:\\Users\\phannam\\Downloads\\CIF0000009.docx";
    //    static String output = "C:\\Users\\phannam\\Downloads\\output.txt";
    static String output = "C:\\Users\\phannam\\Downloads\\TestWord.docx";

    public static void main(String[] args) throws IOException, NoSuchMethodException {
        String a = "";

        String[] folderPath = a.split("\\\\");
        String nameFile = null;
        for (String str : folderPath) {
            nameFile = str;
            System.out.println(nameFile);
        }
//        String typeFile = nameFile.split("\\.")[1];
//        System.out.println(typeFile);
    }

    private static void readFileWithInputStream() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(input);
            out = new FileOutputStream(output);


            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    private static void readFileWithBufferStream() throws IOException {
        BufferedInputStream bufferIn = null;
        BufferedOutputStream bufferOut = null;

        try {
            InputStream inputStream = new FileInputStream(input);
            OutputStream outputStream = new FileOutputStream(output);

            bufferIn = new BufferedInputStream(inputStream);
            bufferOut = new BufferedOutputStream(outputStream);

            int c;
            while ((c = bufferIn.read()) != -1) {
                bufferOut.write(c);
            }
        } finally {
            if (bufferIn != null) {
                bufferIn.close();
            }
            if (bufferOut != null) {
                bufferOut.close();
            }
        }
    }
}

class Student {
    public int tuoi;
    public int nam;

    public Student(int tuoi, int nam) {
        this.tuoi = tuoi;
        this.nam = nam;
    }

    public void getTuoi() {
        System.out.println("tuoi: " + this.tuoi);
    }
}
