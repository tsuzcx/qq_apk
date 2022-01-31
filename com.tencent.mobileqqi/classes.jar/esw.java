import org.json.JSONException;
import org.json.JSONObject;

public class esw
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public static esw a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new esw();
    }
    esw localesw = new esw();
    try
    {
      localesw.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localesw.jdField_a_of_type_JavaLangString = paramJSONObject.getString("soundName");
      localesw.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localesw.jdField_b_of_type_JavaLangString = paramJSONObject.getString("soundVersion");
      localesw.c = paramJSONObject.getString("soundUrl");
      localesw.d = paramJSONObject.getString("whiteList");
      return localesw;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localesw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esw
 * JD-Core Version:    0.7.0.1
 */