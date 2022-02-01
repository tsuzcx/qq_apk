import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.BaseApplication;

public class vtu
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static int jdField_a_of_type_Int = -1;
  
  public static float a()
  {
    if (jdField_a_of_type_Float < 0.0F) {
      jdField_a_of_type_Float = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }
    return jdField_a_of_type_Float;
  }
  
  public static int a()
  {
    return bgtn.a();
  }
  
  public static int a(float paramFloat)
  {
    return (int)(vtc.a() * paramFloat + 0.5F);
  }
  
  public static int b(float paramFloat)
  {
    return Math.round(a() * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtu
 * JD-Core Version:    0.7.0.1
 */