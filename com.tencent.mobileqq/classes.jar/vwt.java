import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.BaseApplication;

public class vwt
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
    return bhtq.a();
  }
  
  public static int a(float paramFloat)
  {
    return (int)(vvv.a() * paramFloat + 0.5F);
  }
  
  public static boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    Rect localRect = new Rect();
    paramView.getLocalVisibleRect(localRect);
    return (paramFloat1 > localRect.left) && (paramFloat1 < localRect.right) && (paramFloat2 > localRect.top) && (paramFloat2 < localRect.bottom);
  }
  
  public static int b(float paramFloat)
  {
    return Math.round(a() * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwt
 * JD-Core Version:    0.7.0.1
 */