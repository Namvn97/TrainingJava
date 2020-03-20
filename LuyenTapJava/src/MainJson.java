import org.json.simple.JSONObject;

public class MainJson {

    public static void main(String[] args) {
        JSONObject o = new JSONObject();
        o.put("caseID", "C950C42C-0652-4950-A413-4BCA34E0DE74");
        o.put("CIFNo", "CIF0001");
        o.put("Class", "TTTTT");
        o.put("toDate","");
        o.put("fromDate","");
        o.put("exchangeNo","TM10001");
        o.put("exchangeType","");
        o.put("pos","110201");

        String input = "";

        String dataInputSoap = "";
//        JSONParser parser = new JSONParser();
//        JSONObject jsonInput = parser.parse(o);
        dataInputSoap = inputSoap(o);
        System.out.println(dataInputSoap);


    }

    public static String inputSoap(JSONObject obj) {
        StringBuilder data = new StringBuilder();
        String keyStr = "";
        String keyvalue = "";
        for (Object entry : obj.keySet()) {
            keyStr = entry.toString();
            keyvalue = obj.get(entry).toString();
            data.append(checkValueString(keyStr, keyvalue));
        }
        return data.toString();

    }

    public static String checkValueString(String key, String value) {
        String data = "";
        if (value != null && !value.isEmpty()) {
            data += " \"" + key + "\": \"" + value + "\",\r\n";
        }
        return data;
    }
}
