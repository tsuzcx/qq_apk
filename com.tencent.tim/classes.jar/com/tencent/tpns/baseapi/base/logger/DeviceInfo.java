package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import java.util.Locale;
import java.util.TimeZone;

public class DeviceInfo
{
  private BuildInfo a = new BuildInfo();
  private ScreenInfo b;
  
  public DeviceInfo(Context paramContext)
  {
    this.b = new ScreenInfo(paramContext);
  }
  
  public String toString()
  {
    return "DeviceInfo{buildInfo=" + this.a + ", screenInfo=" + this.b + '}';
  }
  
  class BuildInfo
  {
    private String b = Build.BRAND;
    private String c = TGlobalHelper.getDM(null);
    private String d = Build.VERSION.RELEASE;
    private int e = Build.VERSION.SDK_INT;
    private String f = Locale.getDefault().getLanguage();
    private String g = TimeZone.getDefault().getID();
    
    BuildInfo() {}
    
    public String toString()
    {
      return "BuildInfo{brand='" + this.b + '\'' + ", model='" + this.c + '\'' + ", systemVersion='" + this.d + '\'' + ", sdkVersion=" + this.e + ", language='" + this.f + '\'' + ", timezone='" + this.g + '\'' + '}';
    }
  }
  
  class ScreenInfo
  {
    private int b = a(paramContext);
    private int c = b(paramContext);
    
    ScreenInfo(Context paramContext) {}
    
    private int a(Context paramContext)
    {
      return paramContext.getResources().getDisplayMetrics().widthPixels;
    }
    
    private int b(Context paramContext)
    {
      return paramContext.getResources().getDisplayMetrics().heightPixels;
    }
    
    public String toString()
    {
      return "ScreenInfo{width=" + this.b + ", height=" + this.c + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.logger.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */