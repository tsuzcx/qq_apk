import org.json.JSONException;
import org.json.JSONObject;

public class esv
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public static esv a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new esv();
    }
    esv localesv = new esv();
    try
    {
      localesv.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localesv.jdField_a_of_type_JavaLangString = paramJSONObject.getString("soundName");
      localesv.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localesv.jdField_b_of_type_JavaLangString = paramJSONObject.getString("soundVersion");
      localesv.c = paramJSONObject.getString("soundUrl");
      localesv.d = paramJSONObject.getString("whiteList");
      return localesv;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localesv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esv
 * JD-Core Version:    0.7.0.1
 */