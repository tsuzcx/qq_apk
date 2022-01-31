import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import java.io.File;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class wyk
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public wyk(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }
  
  public String a()
  {
    return this.c + File.separator + this.jdField_a_of_type_Int + ".zip";
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("thumbPath", ArtFilterManager.jdField_b_of_type_JavaLangString + b() + c());
      localJSONObject.put("priority", this.jdField_b_of_type_Int);
      localJSONObject.put("name", this.c);
      localJSONObject.put("pron", this.e);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public String b()
  {
    return this.c + File.separator + this.jdField_a_of_type_Int + File.separator;
  }
  
  public String c()
  {
    return this.c + "_thumb" + ".png";
  }
  
  public String toString()
  {
    return String.format(Locale.CHINA, "ArtFilter: id=%s, version=%d, priority=%d, url=%s, name=%s, md5=%s, pron=%s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), this.jdField_b_of_type_JavaLangString, this.c, this.d, this.e });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wyk
 * JD-Core Version:    0.7.0.1
 */