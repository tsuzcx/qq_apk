import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class yvj
{
  private static final String jdField_a_of_type_JavaLangString = yvj.class.getName();
  private static yvh jdField_a_of_type_Yvh;
  private static String b;
  private static String c;
  
  public static yvh a()
  {
    if (b == null) {
      b = BaseApplicationImpl.getApplication().getPackageName();
    }
    if (c == null) {
      c = BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath();
    }
    if (jdField_a_of_type_Yvh == null)
    {
      jdField_a_of_type_Yvh = new yvk(b, c);
      wsv.b(jdField_a_of_type_JavaLangString, "init FileCache");
    }
    return jdField_a_of_type_Yvh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yvj
 * JD-Core Version:    0.7.0.1
 */