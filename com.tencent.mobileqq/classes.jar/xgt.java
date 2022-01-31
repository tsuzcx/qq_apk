import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class xgt
{
  private static final String jdField_a_of_type_JavaLangString = xgt.class.getName();
  private static xgr jdField_a_of_type_Xgr;
  private static String b;
  private static String c;
  
  public static xgr a()
  {
    if (b == null) {
      b = BaseApplicationImpl.getApplication().getPackageName();
    }
    if (c == null) {
      c = BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath();
    }
    if (jdField_a_of_type_Xgr == null)
    {
      jdField_a_of_type_Xgr = new xgu(b, c);
      veg.b(jdField_a_of_type_JavaLangString, "init FileCache");
    }
    return jdField_a_of_type_Xgr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xgt
 * JD-Core Version:    0.7.0.1
 */