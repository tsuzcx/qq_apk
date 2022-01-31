import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;

@TargetApi(14)
public class vjo
{
  private static float jdField_a_of_type_Float;
  private static int jdField_a_of_type_Int;
  private static int b;
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public static float a(Resources paramResources)
  {
    if ((b == 0) || (jdField_a_of_type_Int == 0))
    {
      paramResources = paramResources.getDisplayMetrics();
      jdField_a_of_type_Int = paramResources.widthPixels;
      b = paramResources.heightPixels;
      jdField_a_of_type_Float = b * 1.0F / jdField_a_of_type_Int;
    }
    return jdField_a_of_type_Float;
  }
  
  public static int a(Resources paramResources)
  {
    if (jdField_a_of_type_Int == 0)
    {
      paramResources = paramResources.getDisplayMetrics();
      jdField_a_of_type_Int = paramResources.widthPixels;
      b = paramResources.heightPixels;
      jdField_a_of_type_Float = b * 1.0F / jdField_a_of_type_Int;
    }
    return jdField_a_of_type_Int;
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new vjp(paramView));
    paramView.setVisibility(8);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static boolean a(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getDrawingRect(localRect);
    paramView.getLocationOnScreen(arrayOfInt);
    localRect.offset(arrayOfInt[0], arrayOfInt[1]);
    return localRect.contains(paramInt1, paramInt2);
  }
  
  public static int b(Resources paramResources)
  {
    if (b == 0)
    {
      paramResources = paramResources.getDisplayMetrics();
      jdField_a_of_type_Int = paramResources.widthPixels;
      b = paramResources.heightPixels;
      jdField_a_of_type_Float = b * 1.0F / jdField_a_of_type_Int;
    }
    return b;
  }
  
  public static void b(View paramView, boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    if (paramBoolean) {
      localAlphaAnimation.setStartOffset(500L);
    }
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new vjq(paramView));
    paramView.setVisibility(0);
    paramView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vjo
 * JD-Core Version:    0.7.0.1
 */