import org.json.JSONException;
import org.json.JSONObject;

public class yfj
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
  
  public static yfj a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new yfj();
    }
    yfj localyfj = new yfj();
    try
    {
      localyfj.jdField_a_of_type_Int = paramJSONObject.getInt("id");
      localyfj.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localyfj.jdField_b_of_type_Int = paramJSONObject.getInt("type");
      localyfj.jdField_b_of_type_JavaLangString = paramJSONObject.optString("soundVersion", "0");
      localyfj.jdField_c_of_type_JavaLangString = paramJSONObject.getString("soundUrl");
      localyfj.jdField_d_of_type_JavaLangString = paramJSONObject.getString("whiteList");
      localyfj.jdField_c_of_type_Int = paramJSONObject.getInt("isShow");
      localyfj.jdField_e_of_type_Int = paramJSONObject.getInt("classify");
      localyfj.g = paramJSONObject.getString("classifyName");
      localyfj.jdField_e_of_type_JavaLangString = paramJSONObject.getString("backgroundUrl");
      localyfj.f = String.valueOf(paramJSONObject.getInt("vip_type"));
      localyfj.jdField_d_of_type_Int = paramJSONObject.getInt("useNum");
      localyfj.h = paramJSONObject.getString("trialstartday");
      localyfj.i = paramJSONObject.getString("trialendday");
      return localyfj;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localyfj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yfj
 * JD-Core Version:    0.7.0.1
 */