import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Method;

public class awdo
{
  public static final String TAG = "[PhotoAlbum]" + awdo.class.getSimpleName();
  public static final int eAh = kH(27);
  public static int eAi = -1;
  
  public static int a(Context paramContext, Activity paramActivity)
  {
    if (eAi != -1)
    {
      QZLog.d(TAG, 1, new Object[] { "has notchHeight:", Integer.valueOf(eAi) });
      return eAi;
    }
    QZLog.d(TAG, 1, new Object[] { "Build.MODEL:", Build.MODEL });
    if (cY(paramContext)) {
      eAi = eAh;
    }
    for (;;)
    {
      return eAi;
      if (cX(paramContext)) {
        eAi = 80;
      } else if (cZ(paramContext)) {
        eAi = d(paramContext)[1];
      } else if ((da(paramContext)) || (db(paramContext)) || (aMp())) {
        eAi = bH(paramContext);
      } else if (aMq()) {
        eAi = 121;
      } else if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null)) {
        eAi = d(paramActivity.getWindow().getDecorView()).top;
      }
    }
  }
  
  private static boolean aMo()
  {
    return "GM1910".equals(Build.MODEL);
  }
  
  private static boolean aMp()
  {
    return (isLenovo()) || (aMo()) || (aMr()) || ("Pixel 3 XL".equals(Build.MODEL));
  }
  
  private static boolean aMq()
  {
    return "FS8010".equals(Build.MODEL);
  }
  
  private static boolean aMr()
  {
    return "SM-F9000".equals(Build.MODEL);
  }
  
  private static int bH(Context paramContext)
  {
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static boolean cX(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
  }
  
  public static boolean cY(Context paramContext)
  {
    try
    {
      paramContext = awcj.callSpecifiedStaticMethod("android.util.FtFeature", "isFeatureSupport", false, awdr.a().getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(32) });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      QZLog.e(TAG, 2, paramContext, new Object[0]);
    }
    return false;
  }
  
  public static boolean cZ(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      boolean bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(TAG, "hasNotchInScreen ClassNotFoundException");
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(TAG, "hasNotchInScreen NoSuchMethodException");
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      QZLog.e(TAG, "hasNotchInScreen Exception");
      return false;
    }
    finally {}
    return false;
  }
  
  @NonNull
  public static Rect d(View paramView)
  {
    Rect localRect = new Rect();
    QZLog.d(TAG, 1, new Object[] { "Build.VERSION.SDK_INT:", Integer.valueOf(Build.VERSION.SDK_INT) });
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        paramView = awcj.callSpecifiedMethod(paramView, "getRootWindowInsets", false, null, null);
        QZLog.d(TAG, 1, new Object[] { "insets:", paramView });
        Object localObject3 = awcj.callSpecifiedMethod(paramView, "getDisplayCutout", false, null, null);
        if (localObject3 == null)
        {
          QZLog.d(TAG, 1, "displayCutout == null");
          return localRect;
        }
        paramView = awcj.callSpecifiedMethod(localObject3, "getSafeInsetTop", false, null, null);
        Object localObject1 = awcj.callSpecifiedMethod(localObject3, "getSafeInsetBottom", false, null, null);
        Object localObject2 = awcj.callSpecifiedMethod(localObject3, "getSafeInsetLeft", false, null, null);
        localObject3 = awcj.callSpecifiedMethod(localObject3, "getSafeInsetRight", false, null, null);
        QZLog.d(TAG, 1, new Object[] { "safeInsetTop:", paramView, " safeInsetBottom:", localObject1, " safeInsetLeft:", localObject2, " safeInsetRight:", localObject3 });
        if ((localObject2 instanceof Integer)) {
          localRect.left = ((Integer)localObject2).intValue();
        }
        if ((localObject1 instanceof Integer)) {
          localRect.bottom = ((Integer)localObject1).intValue();
        }
        if ((localObject3 instanceof Integer)) {
          localRect.right = ((Integer)localObject3).intValue();
        }
        if ((paramView instanceof Integer))
        {
          localRect.top = ((Integer)paramView).intValue();
          return localRect;
        }
      }
      catch (Exception paramView)
      {
        QZLog.e(TAG, 1, paramView, new Object[0]);
      }
    }
    return localRect;
  }
  
  public static int[] d(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      paramContext = (int[])paramContext.getMethod("getNotchSize", new Class[0]).invoke(paramContext, new Object[0]);
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(TAG, "getNotchSize ClassNotFoundException");
      return arrayOfInt;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(TAG, "getNotchSize NoSuchMethodException");
      return arrayOfInt;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      QZLog.e(TAG, "getNotchSize Exception");
      return arrayOfInt;
    }
    finally {}
    return arrayOfInt;
  }
  
  public static boolean da(Context paramContext)
  {
    paramContext = t(paramContext, "ro.miui.notch", "0");
    if (paramContext != null) {
      return paramContext.equals("1");
    }
    return false;
  }
  
  public static boolean db(Context paramContext)
  {
    try
    {
      paramContext = awcj.callSpecifiedStaticMethod("smartisanos.api.DisplayUtilsSmt", "isFeatureSupport", false, awdr.a().getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(1) });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      QZLog.e(TAG, 2, paramContext, new Object[0]);
    }
    return false;
  }
  
  private static boolean isLenovo()
  {
    return Build.MODEL.endsWith("L78011");
  }
  
  public static int kH(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    float f = paramInt;
    return (int)(localDisplayMetrics.density * f + 0.5F);
  }
  
  public static String t(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class, String.class }).invoke(paramContext, new Object[] { new String(paramString1), new String(paramString2) });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      return paramString2;
    }
    catch (IllegalArgumentException paramContext) {}
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awdo
 * JD-Core Version:    0.7.0.1
 */