import org.json.JSONException;
import org.json.JSONObject;

public class uam
{
  int a;
  public String a;
  int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString = "image_url";
  private final String c = "image_width";
  private final String d = "image_height";
  
  public uam() {}
  
  public uam(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("image_url", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("image_width", this.jdField_a_of_type_Int);
      localJSONObject.put("image_height", this.jdField_b_of_type_Int);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = paramString.getString("image_url");
      this.jdField_a_of_type_Int = paramString.getInt("image_width");
      this.jdField_b_of_type_Int = paramString.getInt("image_height");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uam
 * JD-Core Version:    0.7.0.1
 */