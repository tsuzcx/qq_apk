import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class zww
{
  private static final String jdField_a_of_type_JavaLangString = zww.class.getName();
  private static volatile zwu jdField_a_of_type_Zwu;
  private static String b;
  private static String c;
  
  public static zwu a()
  {
    if (jdField_a_of_type_Zwu == null) {}
    try
    {
      if (jdField_a_of_type_Zwu == null)
      {
        if (b == null) {
          b = BaseApplicationImpl.getApplication().getPackageName();
        }
        if (c == null) {
          c = BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath();
        }
        jdField_a_of_type_Zwu = new zwx(b, c);
      }
      yqp.b(jdField_a_of_type_JavaLangString, "init FileCache");
      return jdField_a_of_type_Zwu;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zww
 * JD-Core Version:    0.7.0.1
 */