package com.tencent.qqmail.utilities.screenshot;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.tencent.qqmail.utilities.BrandUtil;
import java.io.File;

public class ScreenShotPathHelper
{
  private static final String TAG = ScreenShotPathHelper.class.getSimpleName();
  
  public static String getScreenShotPath()
  {
    Log.i(TAG, "Build.MODEL = " + Build.MODEL);
    if (isMIUI()) {
      return ScreenShotPath.XIAOMI;
    }
    if (isVIVO()) {
      return ScreenShotPath.VIVO;
    }
    return ScreenShotPath.NORMAL;
  }
  
  public static boolean isMIUI()
  {
    return BrandUtil.isMiui();
  }
  
  public static boolean isVIVO()
  {
    return Build.BRAND.toLowerCase().contains("vivo");
  }
  
  public static final class ScreenShotPath
  {
    public static final String NORMAL = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Screenshots" + File.separator;
    public static final String VIVO = Environment.getExternalStorageDirectory() + File.separator + "截屏";
    public static final String XIAOMI = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Screenshots" + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.screenshot.ScreenShotPathHelper
 * JD-Core Version:    0.7.0.1
 */