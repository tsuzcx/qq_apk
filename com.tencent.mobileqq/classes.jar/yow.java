import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.lang.ref.WeakReference;

public class yow
{
  private static final String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";
  private static final boolean jdField_a_of_type_Boolean = new File(jdField_a_of_type_JavaLangString + "testserver").exists();
  
  public static void a(yoz<Integer> paramyoz)
  {
    paramyoz = new WeakReference(paramyoz);
    ypr localypr = new ypr(null);
    localypr.a(new yox(paramyoz));
    localypr.a(new yoy(paramyoz));
    localypr.a();
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Boolean) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yow
 * JD-Core Version:    0.7.0.1
 */