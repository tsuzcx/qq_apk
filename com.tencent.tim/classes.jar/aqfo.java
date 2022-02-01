import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Method;

public class aqfo
{
  public static String TAG = "SystemUtil";
  static boolean isCheckMiui;
  static boolean isMiui;
  
  public static boolean aCb()
  {
    return isCheckMiui;
  }
  
  public static void checkMIUI()
  {
    boolean bool2 = true;
    isCheckMiui = true;
    boolean bool1 = bool2;
    if (TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.code")))
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"))) {
        if (TextUtils.isEmpty(getSystemProperty("ro.miui.internal.storage"))) {
          break label50;
        }
      }
    }
    label50:
    for (bool1 = bool2;; bool1 = false)
    {
      isMiui = bool1;
      return;
    }
  }
  
  public static long getSDCardAvailableSize()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public static long getSystemAvailableSize()
  {
    try
    {
      StatFs localStatFs = new StatFs("/data/data/com.tencent.tim/files/");
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public static String getSystemProperty(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString, null });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean isExistSDCard()
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = Environment.getExternalStorageState().equals("mounted");
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isFlyme()
  {
    boolean bool = false;
    try
    {
      Method localMethod = Build.class.getMethod("hasSmartBar", new Class[0]);
      if (localMethod != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isMIUI()
  {
    if (isCheckMiui) {
      return isMiui;
    }
    checkMIUI();
    return isMiui;
  }
  
  public static boolean isMeizu()
  {
    return (!TextUtils.isEmpty(getSystemProperty("ro.meizu.product.model"))) || ("meizu".equalsIgnoreCase(Build.BRAND)) || ("22c4185e".equalsIgnoreCase(Build.BRAND));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqfo
 * JD-Core Version:    0.7.0.1
 */