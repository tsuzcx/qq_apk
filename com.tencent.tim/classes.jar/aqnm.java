import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.BaseApplication;

public class aqnm
{
  private static float DEVICE_DENSITY;
  private static float density;
  private static int densityDPI;
  public static int densityDpi;
  public static float mDensity;
  private static int pixelPerCM;
  private static float scaleDensity;
  private static int screenHeight = -1;
  private static double screenSizeCM;
  private static int screenWidth;
  
  static
  {
    DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    mDensity = localDisplayMetrics.density;
    densityDpi = localDisplayMetrics.densityDpi;
    density = -1.0F;
    scaleDensity = -1.0F;
    densityDPI = -1;
    screenWidth = -1;
  }
  
  public static int PxToDp(float paramFloat)
  {
    return Math.round(paramFloat / getDensity());
  }
  
  @TargetApi(11)
  public static void changeTransparency(View paramView, int paramInt)
  {
    if (paramView.getBackground() != null) {
      paramView.getBackground().setAlpha(paramInt);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        changeTransparency(paramView.getChildAt(i), paramInt);
        i += 1;
      }
    }
  }
  
  public static int dip2px(float paramFloat)
  {
    return (int)(mDensity * paramFloat + 0.5F);
  }
  
  public static int dpToPx(float paramFloat)
  {
    return Math.round(getDensity() * paramFloat);
  }
  
  public static void getChildPos(View paramView1, View paramView2, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2)) {}
    label156:
    for (;;)
    {
      return;
      int i = 0;
      int j = 0;
      int k;
      int m;
      if (paramView1.getParent() != null)
      {
        j = paramView1.getLeft() + j;
        k = paramView1.getTop() + i;
        if (paramView1.getParent() == paramView2)
        {
          paramArrayOfInt[0] = j;
          paramArrayOfInt[1] = k;
          i = k;
          m = j;
          if (paramArrayOfInt.length >= 4)
          {
            paramArrayOfInt[2] = paramView1.getMeasuredWidth();
            paramArrayOfInt[3] = paramView1.getMeasuredHeight();
            m = j;
            i = k;
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (paramView2 != null) {
            break label156;
          }
          paramArrayOfInt[0] = m;
          paramArrayOfInt[1] = i;
          return;
          try
          {
            paramView1 = (View)paramView1.getParent();
            if (paramArrayOfInt.length >= 4)
            {
              paramArrayOfInt[2] = paramView1.getMeasuredWidth();
              paramArrayOfInt[3] = paramView1.getMeasuredHeight();
            }
            i = k;
          }
          catch (ClassCastException paramView1)
          {
            i = k;
            m = j;
          }
        }
        continue;
        m = j;
      }
    }
  }
  
  public static float getDensity()
  {
    if (density < 0.0F) {
      density = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }
    return density;
  }
  
  public static float getDensityDpi()
  {
    if (densityDPI < 0) {
      densityDPI = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    }
    return densityDPI;
  }
  
  public static int getPixelPerCM()
  {
    if (pixelPerCM <= 0) {
      pixelPerCM = (int)(BaseApplication.getContext().getResources().getDisplayMetrics().xdpi / 2.54D);
    }
    return pixelPerCM;
  }
  
  public static float getScaleDensity()
  {
    if (scaleDensity < 0.0F) {
      scaleDensity = BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity;
    }
    return scaleDensity;
  }
  
  public static int getScreenHeight()
  {
    if (screenHeight < 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation != 2) {
        break label41;
      }
    }
    label41:
    for (screenHeight = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;; screenHeight = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels) {
      return screenHeight;
    }
  }
  
  public static double getScreenSizeCM()
  {
    if (screenSizeCM <= 0.0D)
    {
      DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
      double d = Math.pow(localDisplayMetrics.widthPixels, 2.0D);
      screenSizeCM = Math.sqrt(Math.pow(localDisplayMetrics.heightPixels, 2.0D) + d) / getPixelPerCM();
    }
    return screenSizeCM;
  }
  
  public static int getScreenWidth()
  {
    if (screenWidth < 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation != 2) {
        break label41;
      }
    }
    label41:
    for (screenWidth = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;; screenWidth = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels) {
      return screenWidth;
    }
  }
  
  public static float getSpValue(float paramFloat)
  {
    if (DEVICE_DENSITY == 0.0F) {
      DEVICE_DENSITY = densityDpi;
    }
    return DEVICE_DENSITY * paramFloat / 160.0F;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getResources();
    int j = paramContext.getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static Drawable h(@ColorInt int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(paramInt2);
    localGradientDrawable.setColor(paramInt1);
    return localGradientDrawable;
  }
  
  public static boolean isChildOf(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    if ((paramView2 instanceof ViewGroup))
    {
      int j = ((ViewGroup)paramView2).getChildCount();
      int i = 0;
      while (i < j)
      {
        if (isChildOf(paramView1, ((ViewGroup)paramView2).getChildAt(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static int pxTosp(float paramFloat)
  {
    return (int)(paramFloat / BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static void resetScreenSize()
  {
    screenWidth = -1;
    screenHeight = -1;
  }
  
  @TargetApi(11)
  public static void setAlpha(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    }
    while (paramView.getBackground() == null) {
      return;
    }
    paramView.getBackground().setAlpha((int)(255.0F * paramFloat));
  }
  
  @TargetApi(11)
  public static void setPivotX(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setPivotX(paramFloat);
  }
  
  @TargetApi(11)
  public static void setPivotY(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setPivotY(paramFloat);
  }
  
  @TargetApi(11)
  public static void setRotation(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setRotation(paramFloat);
  }
  
  @TargetApi(11)
  public static void setScaleX(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setScaleX(paramFloat);
  }
  
  @TargetApi(11)
  public static void setScaleY(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setScaleY(paramFloat);
  }
  
  @TargetApi(11)
  public static void setTranslationX(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setTranslationX(paramFloat);
  }
  
  @TargetApi(11)
  public static void setTranslationY(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setTranslationY(paramFloat);
  }
  
  @TargetApi(16)
  public static void setViewBackground(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(paramDrawable);
      return;
    }
    paramView.setBackground(paramDrawable);
  }
  
  public static boolean setViewVisibility(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView.setVisibility(paramInt);
      return true;
    }
    return false;
  }
  
  public static void setVisible(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramView.getVisibility() != paramInt)) {
      paramView.setVisibility(paramInt);
    }
  }
  
  public static int spToPx(float paramFloat)
  {
    return (int)(BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnm
 * JD-Core Version:    0.7.0.1
 */