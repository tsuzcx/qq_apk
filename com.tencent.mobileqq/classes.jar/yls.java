import org.json.JSONException;
import org.json.JSONObject;

public class yls
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public static yls a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new yls();
    }
    yls localyls = new yls();
    try
    {
      localyls.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localyls.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localyls.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localyls.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localyls.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localyls.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localyls.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localyls.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localyls.g = paramJSONObject.getString("classifyName");
      localyls.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localyls.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localyls.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localyls.h = paramJSONObject.getString("trialstartday");
      localyls.i = paramJSONObject.getString("trialendday");
      return localyls;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localyls;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yls
 * JD-Core Version:    0.7.0.1
 */