import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class yzy
{
  private static final String jdField_a_of_type_JavaLangString = yzy.class.getName();
  private static yzw jdField_a_of_type_Yzw;
  private static String b;
  private static String c;
  
  public static yzw a()
  {
    if (b == null) {
      b = BaseApplicationImpl.getApplication().getPackageName();
    }
    if (c == null) {
      c = BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath();
    }
    if (jdField_a_of_type_Yzw == null)
    {
      jdField_a_of_type_Yzw = new yzz(b, c);
      wxe.b(jdField_a_of_type_JavaLangString, "init FileCache");
    }
    return jdField_a_of_type_Yzw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yzy
 * JD-Core Version:    0.7.0.1
 */