import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.BaseApplication;

public class vvv
{
  public static float a;
  public static int a;
  public static String a;
  private static boolean a;
  public static int b;
  public static int c;
  private static int d = 1000;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    Object localObject = BaseApplication.getContext().getResources().getDisplayMetrics();
    jdField_a_of_type_Float = ((DisplayMetrics)localObject).density;
    jdField_a_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
    b = ((DisplayMetrics)localObject).heightPixels;
    c = ((DisplayMetrics)localObject).densityDpi;
    localObject = "screen_width=" + jdField_a_of_type_Int;
    String str = "screen_height=" + b;
    jdField_a_of_type_JavaLangString = (String)localObject + "&" + str;
  }
  
  public static float a()
  {
    return jdField_a_of_type_Float;
  }
  
  public static int a()
  {
    return bhtq.a();
  }
  
  public static int b()
  {
    return BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvv
 * JD-Core Version:    0.7.0.1
 */