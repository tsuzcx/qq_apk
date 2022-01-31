import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class xgq
{
  private static final String jdField_a_of_type_JavaLangString = xgq.class.getName();
  private static xgo jdField_a_of_type_Xgo;
  private static String b;
  private static String c;
  
  public static xgo a()
  {
    if (b == null) {
      b = BaseApplicationImpl.getApplication().getPackageName();
    }
    if (c == null) {
      c = BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath();
    }
    if (jdField_a_of_type_Xgo == null)
    {
      jdField_a_of_type_Xgo = new xgr(b, c);
      ved.b(jdField_a_of_type_JavaLangString, "init FileCache");
    }
    return jdField_a_of_type_Xgo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xgq
 * JD-Core Version:    0.7.0.1
 */