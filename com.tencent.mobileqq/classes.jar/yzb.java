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
import java.text.DecimalFormat;

public class yzb
{
  private static int a;
  private static int b;
  
  public static double a(View paramView)
  {
    if (paramView == null) {}
    Rect localRect;
    do
    {
      return 0.0D;
      localRect = new Rect();
    } while ((!paramView.getGlobalVisibleRect(localRect)) || (localRect.left >= b(paramView.getContext())) || (localRect.top >= d(paramView.getContext())) || (localRect.right <= 0) || (localRect.bottom <= 0));
    return 1.0D * localRect.width() * localRect.height() / (paramView.getWidth() * paramView.getHeight());
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat1, Math.min(paramFloat2, paramFloat3));
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int a(@ColorInt int paramInt1, @IntRange(from=0L, to=255L) int paramInt2)
  {
    return 0xFFFFFF & paramInt1 | paramInt2 << 24;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Double.valueOf(1.0D * paramInt1 * paramInt3 / paramInt2).intValue();
  }
  
  private static int a(Activity paramActivity)
  {
    return b(paramActivity);
  }
  
  public static int a(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getResources() == null) || (paramContext.getResources().getConfiguration() == null)) {
      return 0;
    }
    return paramContext.getResources().getConfiguration().orientation;
  }
  
  public static int a(Context paramContext, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i;
    if (a(paramContext) == 1) {
      i = b(paramContext);
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        double d = paramInt2;
        j = Double.valueOf(i * (1.0D * d) / paramInt1).intValue();
      }
      return j;
      if (a(paramContext) == 2) {
        i = d(paramContext);
      } else {
        i = 0;
      }
    }
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      yxp.d("GdtUIUtils", "getColor error", paramString);
    }
    return paramInt;
  }
  
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
      arrayOfInt[paramInt2] = a(paramInt1, (int)(a(0.0F, 1.0F, (float)Math.pow(paramInt2 * 1.0F / (i - 1), 3.0D)) * j));
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
      localPaintDrawable.setShaderFactory(new yzc(f1, f3, f2, f4, arrayOfInt));
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
  
  public static String a(long paramLong)
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
  
  public static void a(Activity paramActivity)
  {
    if (bkvi.c(paramActivity))
    {
      a(paramActivity);
      yxp.a("GdtMvViewController", "enableNotch && updateLiuhaiTopHeight 0");
    }
  }
  
  public static void a(View paramView)
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
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new GdtUIUtils.2(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static void a(FrameLayout paramFrameLayout)
  {
    if ((paramFrameLayout != null) && (BaseApplicationImpl.getApplication() != null) && (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))) {
      paramFrameLayout.setForeground(new ColorDrawable(1996488704));
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 185) || (paramInt == 585);
  }
  
  public static boolean a(Activity paramActivity)
  {
    bkvi.a(paramActivity);
    yxp.a("GdtMvViewController", "hasTopLiuHai  " + bkvi.a);
    return bkvi.a;
  }
  
  @TargetApi(17)
  public static int[] a(Activity paramActivity)
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
    if ((a == 0) || (b == 0))
    {
      localObject = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
      localPoint = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label167;
      }
      ((Display)localObject).getRealSize(localPoint);
      a = localPoint.x;
      b = localPoint.y;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GdtVideoCommonView", 2, "getPortraitScreenSize screenWidth=" + a + ", screenHeight=" + b);
      }
      if (b >= a) {
        break;
      }
      return new int[] { b, a };
      label167:
      if (Build.VERSION.SDK_INT >= 15)
      {
        ((Display)localObject).getSize(localPoint);
        a = localPoint.x;
        b = localPoint.y;
      }
      else
      {
        localObject = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        a = ((DisplayMetrics)localObject).widthPixels;
        b = ((DisplayMetrics)localObject).heightPixels;
      }
    }
    return new int[] { a, b };
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      return Double.valueOf(1.0D * paramInt2 * c(BaseApplicationImpl.getContext()) / paramInt1).intValue();
    }
    return 0;
  }
  
  private static int b(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel()) {
      QLog.i("GdtUIUtils", 1, "getNotchInScreenHeight apiVersion: " + i);
    }
    if (i > 27) {
      return bkvi.a(paramActivity);
    }
    return bkvi.b(paramActivity);
  }
  
  public static int b(Context paramContext)
  {
    if (paramContext == null) {}
    while ((paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null))
    {
      yxp.d("GdtUIUtils", "getScreenWidth error");
      return -2147483648;
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static String b(long paramLong)
  {
    if (paramLong < 1024L) {}
    try
    {
      return paramLong + "B";
    }
    catch (Exception localException)
    {
      Object localObject;
      double d1;
      double d2;
      localException.printStackTrace();
    }
    localObject = new DecimalFormat("##0.0");
    d1 = 1024.0D * 1024.0D;
    d2 = 1024.0D * d1;
    if (paramLong < d1) {
      return ((DecimalFormat)localObject).format(paramLong / 1024.0D) + "K";
    }
    if (paramLong < d2) {
      return ((DecimalFormat)localObject).format(paramLong / d1) + "M";
    }
    localObject = ((DecimalFormat)localObject).format(paramLong / d2) + "G";
    return localObject;
    return "";
  }
  
  public static int c(Context paramContext)
  {
    int i;
    if (paramContext == null)
    {
      yxp.d("GdtUIUtils", "getScreenWidth error");
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
  
  public static int d(Context paramContext)
  {
    if (paramContext == null) {}
    while ((paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null))
    {
      yxp.d("GdtUIUtils", "getScreenHeight error");
      return -2147483648;
    }
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int e(Context paramContext)
  {
    if ((paramContext != null) && ((paramContext instanceof Activity))) {
      paramContext = a((Activity)paramContext);
    }
    for (int i = Math.max(paramContext[0], paramContext[1]);; i = 1920)
    {
      if (i <= 0) {
        return 1920;
      }
      return i;
    }
  }
  
  public static int f(Context paramContext)
  {
    if ((paramContext != null) && ((paramContext instanceof Activity))) {
      paramContext = a((Activity)paramContext);
    }
    for (int i = Math.min(paramContext[0], paramContext[1]);; i = 1080)
    {
      if (i <= 0) {
        return 1080;
      }
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yzb
 * JD-Core Version:    0.7.0.1
 */