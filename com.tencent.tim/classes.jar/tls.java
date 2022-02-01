import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.views.GdtUIUtils.2;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class tls
{
  private static int screenHeight;
  private static int screenWidth;
  
  public static Drawable a(@ColorInt int paramInt1, int paramInt2, int paramInt3)
  {
    float f4 = 0.0F;
    int i = Math.max(paramInt2, 2);
    PaintDrawable localPaintDrawable = new PaintDrawable();
    localPaintDrawable.setShape(new RectShape());
    int[] arrayOfInt = new int[i];
    int j = Color.alpha(paramInt1);
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      arrayOfInt[paramInt2] = ae(paramInt1, (int)(constrain(0.0F, 1.0F, (float)Math.pow(paramInt2 * 1.0F / (i - 1), 3.0D)) * j));
      paramInt2 += 1;
    }
    float f2;
    float f1;
    float f3;
    switch (paramInt3 & 0x7)
    {
    case 4: 
    default: 
      f2 = 0.0F;
      f1 = 0.0F;
      switch (paramInt3 & 0x70)
      {
      default: 
        f3 = 0.0F;
      }
      break;
    }
    for (;;)
    {
      localPaintDrawable.setShaderFactory(new tlt(f1, f3, f2, f4, arrayOfInt));
      return localPaintDrawable;
      f2 = 0.0F;
      f1 = 1.0F;
      break;
      f2 = 1.0F;
      f1 = 0.0F;
      break;
      f3 = 1.0F;
      continue;
      f3 = 0.0F;
      f4 = 1.0F;
    }
  }
  
  public static String aQ(long paramLong)
  {
    long l2 = paramLong / 1000L;
    paramLong = l2 % 60L;
    long l1 = l2 / 60L % 60L;
    l2 /= 3600L;
    if (l2 > 0L) {
      return String.format("%d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    }
    return String.format("%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
  }
  
  public static int ad(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getResources() == null) || (paramContext.getResources().getConfiguration() == null)) {
      return 0;
    }
    return paramContext.getResources().getConfiguration().orientation;
  }
  
  public static int ae(@ColorInt int paramInt1, @IntRange(from=0L, to=255L) int paramInt2)
  {
    return 0xFFFFFF & paramInt1 | paramInt2 << 24;
  }
  
  public static int ae(Context paramContext)
  {
    if ((paramContext != null) && ((paramContext instanceof Activity))) {
      paramContext = d((Activity)paramContext);
    }
    for (int i = Math.max(paramContext[0], paramContext[1]);; i = 1920)
    {
      if (i <= 0) {
        return 1920;
      }
      return i;
    }
  }
  
  public static int af(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      return Double.valueOf(1.0D * paramInt2 * getPhysicalScreenWidth(BaseApplicationImpl.getContext()) / paramInt1).intValue();
    }
    return 0;
  }
  
  public static int af(Context paramContext)
  {
    if ((paramContext != null) && ((paramContext instanceof Activity))) {
      paramContext = d((Activity)paramContext);
    }
    for (int i = Math.min(paramContext[0], paramContext[1]);; i = 1080)
    {
      if (i <= 0) {
        return 1080;
      }
      return i;
    }
  }
  
  public static int b(Context paramContext, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i;
    if (ad(paramContext) == 1) {
      i = getScreenWidth(paramContext);
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        double d = paramInt2;
        j = Double.valueOf(i * (1.0D * d) / paramInt1).intValue();
      }
      return j;
      if (ad(paramContext) == 2) {
        i = getScreenHeight(paramContext);
      } else {
        i = 0;
      }
    }
  }
  
  public static void bl(Activity paramActivity)
  {
    if (ayxa.enableNotch(paramActivity))
    {
      s(paramActivity);
      tkw.d("GdtMvViewController", "enableNotch && updateLiuhaiTopHeight 0");
    }
  }
  
  public static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat1, Math.min(paramFloat2, paramFloat3));
  }
  
  @TargetApi(17)
  public static int[] d(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GdtVideoCommonView", 2, "getPortraitScreenSize ERROR activity == null");
      }
      return new int[] { 0, 0 };
    }
    Object localObject;
    Point localPoint;
    if ((screenWidth == 0) || (screenHeight == 0))
    {
      localObject = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
      localPoint = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label161;
      }
      ((Display)localObject).getRealSize(localPoint);
      screenWidth = localPoint.x;
      screenHeight = localPoint.y;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GdtVideoCommonView", 2, "getPortraitScreenSize screenWidth=" + screenWidth + ", screenHeight=" + screenHeight);
      }
      if (screenHeight >= screenWidth) {
        break;
      }
      return new int[] { screenHeight, screenWidth };
      label161:
      if (Build.VERSION.SDK_INT >= 15)
      {
        ((Display)localObject).getSize(localPoint);
        screenWidth = localPoint.x;
        screenHeight = localPoint.y;
      }
      else
      {
        localObject = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        screenWidth = ((DisplayMetrics)localObject).widthPixels;
        screenHeight = ((DisplayMetrics)localObject).heightPixels;
      }
    }
    return new int[] { screenWidth, screenHeight };
  }
  
  public static final int dp2px(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static void e(FrameLayout paramFrameLayout)
  {
    if ((paramFrameLayout != null) && (BaseApplicationImpl.getApplication() != null) && (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))) {
      paramFrameLayout.setForeground(new ColorDrawable(1996488704));
    }
  }
  
  public static void eo(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if ((BaseApplicationImpl.getApplication() != null) && (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)))
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public static boolean fp(int paramInt)
  {
    return (paramInt == 185) || (paramInt == 585);
  }
  
  private static int getNotchInScreenHeight(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel()) {
      QLog.i("GdtUIUtils", 1, "getNotchInScreenHeight apiVersion: " + i);
    }
    if (i > 27) {
      return ayxa.getNotchInScreenHeight_AndroidP(paramActivity);
    }
    return ayxa.getNotchInScreenHeight_AndroidO(paramActivity);
  }
  
  public static double getPercentageOfGlobalVisibleRect(View paramView)
  {
    if (paramView == null) {}
    Rect localRect;
    do
    {
      return 0.0D;
      localRect = new Rect();
    } while ((!paramView.getGlobalVisibleRect(localRect)) || (localRect.left >= getScreenWidth(paramView.getContext())) || (localRect.top >= getScreenHeight(paramView.getContext())) || (localRect.right <= 0) || (localRect.bottom <= 0));
    return 1.0D * localRect.width() * localRect.height() / (paramView.getWidth() * paramView.getHeight());
  }
  
  public static int getPhysicalScreenWidth(Context paramContext)
  {
    int i;
    if (paramContext == null)
    {
      tkw.e("GdtUIUtils", "getScreenWidth error");
      i = -2147483648;
    }
    int k;
    int j;
    do
    {
      return i;
      if ((paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null)) {
        break;
      }
      k = paramContext.getResources().getDisplayMetrics().widthPixels;
      j = paramContext.getResources().getDisplayMetrics().heightPixels;
      i = j;
    } while (k > j);
    return k;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    if (paramContext == null) {}
    while ((paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null))
    {
      tkw.e("GdtUIUtils", "getScreenHeight error");
      return -2147483648;
    }
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if (paramContext == null) {}
    while ((paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null))
    {
      tkw.e("GdtUIUtils", "getScreenWidth error");
      return -2147483648;
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int i(int paramInt1, int paramInt2, int paramInt3)
  {
    return Double.valueOf(1.0D * paramInt1 * paramInt3 / paramInt2).intValue();
  }
  
  public static void i(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new GdtUIUtils.2(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static boolean p(Activity paramActivity)
  {
    ayxa.initLiuHaiProperty(paramActivity);
    tkw.d("GdtMvViewController", "hasTopLiuHai  " + ayxa.sHasNotch);
    return ayxa.sHasNotch;
  }
  
  public static int pxToDp(Context paramContext, int paramInt)
  {
    if (paramContext == null) {}
    float f;
    do
    {
      do
      {
        return -2147483648;
      } while ((paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null));
      f = paramContext.getResources().getDisplayMetrics().density;
    } while (f <= 0.0F);
    return Math.round(paramInt / f);
  }
  
  private static int s(Activity paramActivity)
  {
    return getNotchInScreenHeight(paramActivity);
  }
  
  public static int z(String paramString, int paramInt)
  {
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      tkw.e("GdtUIUtils", "getColor error", paramString);
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tls
 * JD-Core Version:    0.7.0.1
 */