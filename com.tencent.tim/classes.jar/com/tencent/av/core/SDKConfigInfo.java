package com.tencent.av.core;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igd;
import igg;
import imm;
import ioc;
import ioc.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SDKConfigInfo
{
  private static final String TAG = "SDKConfigInfo";
  private boolean isDebugVersion = false;
  private boolean isGrayVersion = false;
  private boolean isPublicVersion = true;
  private String logDir = igg.gE();
  private String logFilePrefix = "com.tencent.tim";
  private String processName = "";
  private int terminalType = 4;
  
  @TargetApi(9)
  public static String getDeviceInfo(Context paramContext)
  {
    Object localObject1 = "PRODUCT=" + Build.PRODUCT + ";";
    localObject1 = (String)localObject1 + "CPU_ABI=" + Build.CPU_ABI + ";";
    localObject1 = (String)localObject1 + "TAGS=" + Build.TAGS + ";";
    localObject1 = (String)localObject1 + "VERSION_CODES_BASE=1;";
    localObject1 = (String)localObject1 + "MODEL=" + Build.MODEL + ";";
    localObject1 = (String)localObject1 + "SDK=" + Build.VERSION.SDK_INT + ";";
    localObject1 = (String)localObject1 + "VERSION_RELEASE=" + Build.VERSION.RELEASE + ";";
    localObject1 = (String)localObject1 + "DEVICE=" + Build.DEVICE + ";";
    localObject1 = (String)localObject1 + "DISPLAY=" + Build.DISPLAY + ";";
    localObject1 = (String)localObject1 + "BRAND=" + Build.BRAND + ";";
    localObject1 = (String)localObject1 + "BOARD=" + Build.BOARD + ";";
    localObject1 = (String)localObject1 + "FINGERPRINT=" + Build.FINGERPRINT + ";";
    localObject1 = (String)localObject1 + "ID=" + Build.ID + ";";
    localObject1 = (String)localObject1 + "MANUFACTURER=" + Build.MANUFACTURER + ";";
    localObject1 = (String)localObject1 + "USER=" + Build.USER + ";";
    Object localObject2 = ioc.a("SDKConfigInfo", paramContext);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      Iterator localIterator = ((ArrayList)localObject2).iterator();
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break label1009;
      }
      localObject2 = (ioc.b)localIterator.next();
      if ((((ioc.b)localObject2).amp == 1) && (((ioc.b)localObject2).Tx))
      {
        localObject1 = (String)localObject1 + "HWAVCDEC=1;";
        localObject1 = (String)localObject1 + "HWAVCDEC_MAXW=" + ((ioc.b)localObject2).aqP + ";";
        localObject1 = (String)localObject1 + "HWAVCDEC_MAXH=" + ((ioc.b)localObject2).aqQ + ";";
      }
    }
    for (;;)
    {
      break;
      if ((((ioc.b)localObject2).amp == 2) && (((ioc.b)localObject2).Tx))
      {
        localObject1 = (String)localObject1 + "HWAVCENC=1;";
        localObject1 = (String)localObject1 + "HWAVCENC_MAXW=" + ((ioc.b)localObject2).aqP + ";";
        localObject1 = (String)localObject1 + "HWAVCENC_MAXH=" + ((ioc.b)localObject2).aqQ + ";";
      }
      else if ((((ioc.b)localObject2).amp == 4) && (((ioc.b)localObject2).Tx))
      {
        localObject1 = (String)localObject1 + "HWHEVCDEC=1;";
        localObject1 = (String)localObject1 + "HWHEVCDEC_MAXW=" + ((ioc.b)localObject2).aqP + ";";
        localObject1 = (String)localObject1 + "HWHEVCDEC_MAXH=" + ((ioc.b)localObject2).aqQ + ";";
      }
      else if ((((ioc.b)localObject2).amp == 8) && (((ioc.b)localObject2).Tx))
      {
        localObject1 = (String)localObject1 + "HWHEVCENC=1;";
        localObject1 = (String)localObject1 + "HWHEVCENC_MAXW=" + ((ioc.b)localObject2).aqP + ";";
        localObject1 = (String)localObject1 + "HWHEVCENC_MAXH=" + ((ioc.b)localObject2).aqQ + ";";
        continue;
        localObject1 = (String)localObject1 + "HWAVCENC=0;";
        localObject1 = (String)localObject1 + "HWAVCDEC=0;";
        localObject1 = (String)localObject1 + "HWHEVCENC=0;";
        localObject2 = (String)localObject1 + "HWHEVCDEC=0;";
        label1009:
        localObject1 = paramContext.getApplicationInfo();
        localObject2 = (String)localObject2 + "DATADIR=" + ((ApplicationInfo)localObject1).dataDir + ";";
        if (Build.VERSION.SDK_INT >= 9)
        {
          localObject1 = (String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).nativeLibraryDir + ";";
          AVSoUtils.dRI();
          localObject1 = (String)localObject1 + "HEVC_ENC_SO_DIR=" + AVSoUtils.Af() + ";";
          localObject1 = (String)localObject1 + "HEVC_DEC_SO_DIR=" + AVSoUtils.Ag() + ";";
          if (imm.getCpuArchitecture() <= 2) {
            break label1345;
          }
        }
        label1345:
        for (localObject1 = (String)localObject1 + "SHARP_VIDEO=1;";; localObject1 = (String)localObject1 + "SHARP_VIDEO=2;")
        {
          paramContext = paramContext.getResources().getDisplayMetrics();
          int i = Math.max(paramContext.widthPixels, paramContext.heightPixels);
          int j = Math.min(paramContext.widthPixels, paramContext.heightPixels);
          paramContext = (String)localObject1 + "SCREEN_WIDTH=" + i + ";";
          paramContext = paramContext + "SCREEN_HEIGHT=" + j + ";";
          QLog.i("SDKConfigInfo", 1, "getDeviceInfo, info[" + paramContext + "]");
          return paramContext;
          localObject1 = (String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).dataDir + "/lib;";
          break;
        }
      }
    }
  }
  
  public String toString()
  {
    return "SDKConfigInfo{logDir='" + this.logDir + "logFilePrefix='" + this.logFilePrefix + ", processName='" + this.processName + ", isDebugVersion=" + this.isDebugVersion + ", isGrayVersion=" + this.isGrayVersion + ", isPublicVersion=" + this.isPublicVersion + '}';
  }
  
  public static class a
  {
    private final SDKConfigInfo a = new SDKConfigInfo(null);
    
    public a()
    {
      int i = Process.myPid();
      Iterator localIterator = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.pid == i) {
          SDKConfigInfo.access$102(this.a, localRunningAppProcessInfo.processName);
        }
      }
      igd.aH("SDKConfigInfo", this.a.toString());
    }
    
    public SDKConfigInfo a()
    {
      return this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.core.SDKConfigInfo
 * JD-Core Version:    0.7.0.1
 */