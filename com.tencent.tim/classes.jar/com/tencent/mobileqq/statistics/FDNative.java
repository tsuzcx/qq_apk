package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FDNative
{
  private static FDNative a;
  
  private FDNative()
  {
    System.loadLibrary("qq_fd");
  }
  
  public static int Ki()
  {
    int i = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication.getApplicationContext()).getInt("FDHookFailTime", 0);
    if (QLog.isColorLevel()) {
      QLog.d("FDStats", 2, new Object[] { "getFailTime ", Integer.valueOf(i) });
    }
    return i;
  }
  
  public static void Vj(int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication.getApplicationContext());
    localSharedPreferences.edit().putInt("FDHookFailTime", paramInt).apply();
    if (QLog.isColorLevel()) {
      QLog.d("FDStats", 2, new Object[] { "setFailTime ", Integer.valueOf(paramInt) });
    }
    if (paramInt >= 30)
    {
      localSharedPreferences.edit().putLong("FDHookLastInterval", System.currentTimeMillis()).apply();
      cu(false, true);
    }
  }
  
  public static FDNative a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new FDNative();
      }
      return a;
    }
    finally {}
  }
  
  public static boolean ayz()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication.getApplicationContext());
    localSharedPreferences.getBoolean("FDHookChanged", false);
    boolean bool = localSharedPreferences.getBoolean("FDHook", true);
    if (QLog.isColorLevel()) {
      QLog.d("FDStats", 2, new Object[] { "getEnableHook ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static void cu(boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication.getApplicationContext());
    localSharedPreferences.edit().putBoolean("FDHook", paramBoolean1).commit();
    if (!paramBoolean2) {
      localSharedPreferences.edit().putBoolean("FDHookChanged", true).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FDStats", 2, new Object[] { "setEnableHook ", Boolean.valueOf(paramBoolean1) });
    }
  }
  
  public static void dSu()
  {
    if (Ki() >= 30)
    {
      long l = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication.getApplicationContext()).getLong("FDHookLastInterval", 0L);
      if ((System.currentTimeMillis() - l > 86400000L) && (l != 0L))
      {
        Vj(0);
        cu(true, true);
      }
    }
  }
  
  public static native Object nativeCollectFDList();
  
  public static native int nativeIgnore(String paramString);
  
  public static native int nativeInit(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  
  public static native int nativeRegister(String paramString);
  
  public static native int nativeSave(String paramString);
  
  public static native int nativeStart();
  
  public static native int nativeStop();
  
  public void QP(String paramString) {}
  
  public ArrayList<Integer> dJ()
  {
    int i = 0;
    ArrayList localArrayList = (ArrayList)nativeCollectFDList();
    if (QLog.isColorLevel())
    {
      if (localArrayList != null) {
        i = localArrayList.size();
      }
      QLog.d("FDStats", 2, new Object[] { "getCollectFDList size ", Integer.valueOf(i) });
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDNative
 * JD-Core Version:    0.7.0.1
 */