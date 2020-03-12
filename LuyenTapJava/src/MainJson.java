import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MainJson {

    public static void main(String[] args) {
        JSONObject o = new JSONObject();
        o.put("id", "");
        o.put("CIFNo", "CIF0001Nam");
        JSONArray employees = new JSONArray();
        employees.add(o);
        JSONObject a = (JSONObject) employees.get(0);

        String d = (String) a.get("id");
        System.out.println(a.get("id"));
        System.out.println(a.get("CIFNo"));
        System.out.println(employees.get(0));

        if (StringUtils.isBlank(d)) {
            System.out.println("rỗng");
        } else {
            System.out.println("no" + d);
        }

//        String folderPath = "20200918_Nguyen Van A_12345";
//        String[] infoCustomer = folderPath.split("_");
//        String cusName = infoCustomer[1];
//        String cusId = infoCustomer[2];
//        System.out.println("CIF - " + cusName + " name - " + cusId);
    }
}
