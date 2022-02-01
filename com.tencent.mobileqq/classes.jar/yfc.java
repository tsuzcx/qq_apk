import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.lang.ref.WeakReference;

public class yfc
{
  private static final String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";
  private static final boolean jdField_a_of_type_Boolean = new File(jdField_a_of_type_JavaLangString + "testserver").exists();
  
  public static void a(yff<Integer> paramyff)
  {
    paramyff = new WeakReference(paramyff);
    yfx localyfx = new yfx(null);
    localyfx.a(new yfd(paramyff));
    localyfx.a(new yfe(paramyff));
    localyfx.a();
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Boolean) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfc
 * JD-Core Version:    0.7.0.1
 */