package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.LibLoadUtil;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsLog;

public class CKeyGuard
{
  private static final String SONAME = "ckguard";
  private static String TAG = "ckeyguard";
  public static boolean bLoadSucc;
  private static boolean isInit = false;
  private static Context mContext = null;
  public static CKeyGuard mInstance;
  private static String mSoVersion = "";
  
  public static String genGuard(Context paramContext)
  {
    if (!bLoadSucc) {
      bLoadSucc = LibLoadUtil.loadso(mContext, "ckguard");
    }
    try
    {
      paramContext = new String(sGuard(System.currentTimeMillis() / 1000L, ""));
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public static String getJarVersion()
  {
    return CKeyFacade.mJarVersion;
  }
  
  public static String getSoVersion()
  {
    return mSoVersion;
  }
  
  public static String getVersion()
  {
    try
    {
      String str = sVersion();
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static void guardInit(Context paramContext)
  {
    mContext = paramContext;
    if (!bLoadSucc) {
      bLoadSucc = LibLoadUtil.loadso(mContext, "ckguard");
    }
    mSoVersion = getVersion();
    try
    {
      paramContext = new Thread(new CKeyGuard.1(paramContext));
      paramContext.setName("TVK_guardthread");
      paramContext.start();
      return;
    }
    catch (Throwable paramContext)
    {
      VsLog.error(TAG, new Object[] { "guard init catch" });
    }
  }
  
  private static native byte[] sGuard(long paramLong, String paramString);
  
  private static native void sGuardInit(Context paramContext);
  
  private static native String sVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyGuard
 * JD-Core Version:    0.7.0.1
 */