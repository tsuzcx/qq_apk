import org.json.JSONObject;

public class zwr
{
  private String jdField_a_of_type_JavaLangString = "";
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  private String b = "";
  
  public static zwr a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      zwr localzwr = new zwr();
      paramString = new JSONObject(paramString);
      localzwr.jdField_a_of_type_JavaLangString = paramString.optString("icon_image_url", "");
      localzwr.jdField_a_of_type_OrgJsonJSONObject = paramString.optJSONObject("config");
      localzwr.b = paramString.optString("md5", "");
      return localzwr;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public JSONObject a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "k = icon_image_url, value = " + this.jdField_a_of_type_JavaLangString + "\n k = config, value = " + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "\n k = md5, value = " + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwr
 * JD-Core Version:    0.7.0.1
 */