import org.json.JSONObject;

public class xck
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public xck(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("title")) {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
    }
    if (paramJSONObject.has("tabID")) {
      this.jdField_a_of_type_Int = paramJSONObject.optInt("tabID");
    }
    if (paramJSONObject.has("icon")) {
      this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon");
    }
    if (paramJSONObject.has("jumpUrl")) {
      this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("jumpUrl");
    }
    if (paramJSONObject.has("width")) {
      this.jdField_b_of_type_Int = paramJSONObject.optInt("width");
    }
    if (paramJSONObject.has("height")) {
      this.jdField_c_of_type_Int = paramJSONObject.optInt("height");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xck
 * JD-Core Version:    0.7.0.1
 */