import org.json.JSONException;
import org.json.JSONObject;

public class ycc
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
  
  public static ycc a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new ycc();
    }
    ycc localycc = new ycc();
    try
    {
      localycc.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localycc.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localycc.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localycc.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localycc.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localycc.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localycc.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localycc.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localycc.g = paramJSONObject.getString("classifyName");
      localycc.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localycc.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localycc.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localycc.h = paramJSONObject.getString("trialstartday");
      localycc.i = paramJSONObject.getString("trialendday");
      return localycc;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localycc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ycc
 * JD-Core Version:    0.7.0.1
 */