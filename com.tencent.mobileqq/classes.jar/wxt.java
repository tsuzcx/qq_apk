import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class wxt
{
  private static final String jdField_a_of_type_JavaLangString = wxt.class.getName();
  private static wxr jdField_a_of_type_Wxr;
  private static String b;
  private static String c;
  
  public static wxr a()
  {
    if (b == null) {
      b = BaseApplicationImpl.getApplication().getPackageName();
    }
    if (c == null) {
      c = BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath();
    }
    if (jdField_a_of_type_Wxr == null)
    {
      jdField_a_of_type_Wxr = new wxu(b, c);
      urk.b(jdField_a_of_type_JavaLangString, "init FileCache");
    }
    return jdField_a_of_type_Wxr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxt
 * JD-Core Version:    0.7.0.1
 */