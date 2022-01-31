import org.json.JSONException;
import org.json.JSONObject;

public class exk
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public static exk a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new exk();
    }
    exk localexk = new exk();
    try
    {
      localexk.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localexk.jdField_a_of_type_JavaLangString = paramJSONObject.getString("soundName");
      localexk.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localexk.jdField_b_of_type_JavaLangString = paramJSONObject.getString("soundVersion");
      localexk.c = paramJSONObject.getString("soundUrl");
      localexk.d = paramJSONObject.getString("whiteList");
      return localexk;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localexk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     exk
 * JD-Core Version:    0.7.0.1
 */