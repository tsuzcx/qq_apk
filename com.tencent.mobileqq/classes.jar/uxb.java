import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import java.io.File;
import org.json.JSONObject;

public class uxb
  implements Cloneable
{
  public static final String a;
  public int a;
  public int b;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = ArtFilterManager.jdField_b_of_type_JavaLangString + "loading" + File.separator;
  }
  
  public static uxb a(JSONObject paramJSONObject)
  {
    uxb localuxb = new uxb();
    localuxb.jdField_b_of_type_Int = paramJSONObject.getInt("version");
    localuxb.jdField_a_of_type_Int = paramJSONObject.getInt("picNum");
    localuxb.c = paramJSONObject.getString("url");
    localuxb.jdField_b_of_type_JavaLangString = paramJSONObject.getString("md5");
    return localuxb;
  }
  
  public String a()
  {
    Object localObject = new File(c());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length == this.jdField_a_of_type_Int)) {
        return c();
      }
    }
    return null;
  }
  
  public String b()
  {
    return jdField_a_of_type_JavaLangString + this.jdField_b_of_type_Int + ".zip";
  }
  
  public String c()
  {
    return jdField_a_of_type_JavaLangString + this.jdField_b_of_type_Int + File.separator;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public String d()
  {
    return "loading" + File.separator + this.jdField_b_of_type_Int + ".zip";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxb
 * JD-Core Version:    0.7.0.1
 */