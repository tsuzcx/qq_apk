import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;

@TargetApi(14)
public class rex
{
  private static float mQ;
  private static int screenHeight;
  private static int screenWidth;
  
  public static float a(Resources paramResources)
  {
    if ((screenHeight == 0) || (screenWidth == 0))
    {
      paramResources = paramResources.getDisplayMetrics();
      screenWidth = paramResources.widthPixels;
      screenHeight = paramResources.heightPixels;
      mQ = screenHeight * 1.0F / screenWidth;
    }
    return mQ;
  }
  
  public static int b(Resources paramResources)
  {
    if (screenWidth == 0)
    {
      paramResources = paramResources.getDisplayMetrics();
      screenWidth = paramResources.widthPixels;
      screenHeight = paramResources.heightPixels;
      mQ = screenHeight * 1.0F / screenWidth;
    }
    return screenWidth;
  }
  
  public static int c(Resources paramResources)
  {
    if (screenHeight == 0)
    {
      paramResources = paramResources.getDisplayMetrics();
      screenWidth = paramResources.widthPixels;
      screenHeight = paramResources.heightPixels;
      mQ = screenHeight * 1.0F / screenWidth;
    }
    return screenHeight;
  }
  
  public static boolean c(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getDrawingRect(localRect);
    paramView.getLocationOnScreen(arrayOfInt);
    localRect.offset(arrayOfInt[0], arrayOfInt[1]);
    return localRect.contains(paramInt1, paramInt2);
  }
  
  public static float e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public static void s(View paramView, boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new rey(paramView));
    paramView.setVisibility(8);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static void t(View paramView, boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    if (paramBoolean) {
      localAlphaAnimation.setStartOffset(500L);
    }
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new rez(paramView));
    paramView.setVisibility(0);
    paramView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rex
 * JD-Core Version:    0.7.0.1
 */