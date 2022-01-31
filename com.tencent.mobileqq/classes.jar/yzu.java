import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class yzu
{
  public String a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  
  public yzu(yzr paramyzr, String paramString, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      this.b = paramJSONObject.getString("title");
      this.c = paramJSONObject.getString("title_color");
      this.d = paramJSONObject.getString("bg_color");
      this.e = paramJSONObject.getString("bg_border_color");
      return;
    }
    catch (JSONException paramyzr)
    {
      paramyzr.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    paramString = paramString + "/" + this.jdField_a_of_type_JavaLangString;
    Object localObject = new File(paramString);
    if (((File)localObject).exists())
    {
      localObject = Arrays.asList(((File)localObject).list());
      if (((List)localObject).contains("take_video@2x.png"))
      {
        String str = paramString + "/" + "take_video@2x.png";
        if (new File(str).exists()) {
          this.f = str;
        }
      }
      if (((List)localObject).contains("take_video_no_bg@2x.png"))
      {
        paramString = paramString + "/" + "take_video_no_bg@2x.png";
        if (new File(paramString).exists()) {
          this.g = paramString;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yzu
 * JD-Core Version:    0.7.0.1
 */