import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ankt
{
  private static float DENSITY;
  public static int SCREEN_WIDTH;
  public static int cIE;
  private static Context context = ;
  
  static
  {
    SCREEN_WIDTH = 320;
    cIE = 480;
    Display localDisplay = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
    if (localDisplay != null)
    {
      SCREEN_WIDTH = localDisplay.getWidth();
      cIE = localDisplay.getHeight();
    }
  }
  
  @TargetApi(13)
  public static int aC(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (cIE = localPoint.y;; cIE = paramContext.getDefaultDisplay().getHeight()) {
      return cIE;
    }
  }
  
  @TargetApi(13)
  public static int aD(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (SCREEN_WIDTH = localPoint.x;; SCREEN_WIDTH = paramContext.getDefaultDisplay().getWidth()) {
      return SCREEN_WIDTH;
    }
  }
  
  public static int aE(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        return ((DisplayMetrics)localObject).widthPixels;
      }
      localObject = Display.class.getMethod("getRawWidth", new Class[0]);
      try
      {
        int i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        return i;
      }
      catch (IllegalArgumentException paramContext)
      {
        ram.e("ScreenUtil", paramContext.getMessage());
        return -1;
      }
      catch (IllegalAccessException paramContext)
      {
        ram.e("ScreenUtil", paramContext.getMessage());
        return -1;
      }
      catch (InvocationTargetException paramContext)
      {
        ram.e("ScreenUtil", paramContext.getMessage());
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        ram.wtf("ScreenUtil", paramContext.getMessage());
      }
    }
    return -1;
  }
  
  public static boolean bA(Context paramContext)
  {
    if ((Build.MANUFACTURER.contains("Xiaomi")) && ((Build.MODEL.contains("MIX 2S")) || (Build.MODEL.contains("MI 8")) || (Build.MODEL.contains("MI 9")) || (Build.MODEL.contains("MIX 2")) || (Build.MODEL.contains("MIX 3"))) && (Build.VERSION.SDK_INT >= 21)) {
      if (Settings.Global.getInt(BaseApplication.getContext().getContentResolver(), "force_fsg_nav_bar", 0) != 0) {}
    }
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return true;
        return false;
        if (Build.VERSION.SDK_INT < 17) {
          break;
        }
      } while (aC(paramContext) != getRealHeight(paramContext));
      return false;
      bool1 = ViewConfiguration.get(paramContext).hasPermanentMenuKey();
      bool2 = KeyCharacterMap.deviceHasKey(4);
    } while ((!bool1) && (!bool2));
    return false;
  }
  
  public static void bmw()
  {
    WindowManager localWindowManager = (WindowManager)context.getSystemService("window");
    SCREEN_WIDTH = localWindowManager.getDefaultDisplay().getWidth();
    cIE = localWindowManager.getDefaultDisplay().getHeight();
    DENSITY = context.getResources().getDisplayMetrics().density;
    if (QLog.isColorLevel()) {
      QLog.d("systemDpiChanged", 2, "mofity width:" + SCREEN_WIDTH);
    }
  }
  
  public static int dip2px(float paramFloat)
  {
    if (DENSITY == 0.0F) {
      DENSITY = context.getResources().getDisplayMetrics().density;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenUtil", 2, "[@] ScreenUtil.dip2px DENSITY = " + DENSITY);
    }
    return (int)(DENSITY * paramFloat + 0.5F);
  }
  
  public static int getNavigationBarHeight(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getIdentifier("navigation_bar_height", "dimen", "android");
    if (i != 0) {
      return paramContext.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static int getRealHeight(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        return ((DisplayMetrics)localObject).heightPixels;
      }
      localObject = Display.class.getMethod("getRawHeight", new Class[0]);
      try
      {
        int i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        return i;
      }
      catch (IllegalArgumentException paramContext)
      {
        ram.e("ScreenUtil", paramContext.getMessage());
        return -1;
      }
      catch (IllegalAccessException paramContext)
      {
        ram.e("ScreenUtil", paramContext.getMessage());
        return -1;
      }
      catch (InvocationTargetException paramContext)
      {
        ram.e("ScreenUtil", paramContext.getMessage());
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        ram.e("ScreenUtil", paramContext.getMessage());
      }
    }
    return -1;
  }
  
  public static boolean isNavigationBarExist(Activity paramActivity)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return false;
      ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
      int i = 0;
      while (i < localViewGroup.getChildCount())
      {
        int j = localViewGroup.getChildAt(i).getId();
        if ((j != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(j)))) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ankt
 * JD-Core Version:    0.7.0.1
 */