package com.tencent.kingkong;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

public class Common
{
  public static final String DRIVER_ASSET_FOLDER = "asset";
  public static final int FAIL_REASON_CALCULATE_PARAM_ERROR = 4;
  public static final int FAIL_REASON_INVALID_FINGERPRINT = 1;
  public static final int FAIL_REASON_INVALID_HOOK_POINT = 6;
  public static final int FAIL_REASON_INVALID_JUMPER_POINT = 7;
  public static final int FAIL_REASON_NATIVE_DO_PATCH_ERROR = 5;
  public static final int FAIL_REASON_NO_FINGERPRINT_MATCH = 2;
  public static final int FAIL_REASON_VERIFY_PARAM_ERROR = 3;
  public static final int FINGERPRINT_TYPE_FUNCTION = 0;
  public static final int FINGERPRINT_TYPE_OFFSET_TO_FILE = 1;
  public static final int FINGERPRINT_TYPE_OFFSET_TO_FUNCTION = 2;
  public static final int HOOKPOINT_TYPE_FUNCTION = 0;
  public static final int HOOKPOINT_TYPE_OFFSET_TO_FILE = 1;
  public static final int HOOKPOINT_TYPE_OFFSET_TO_FUNCTION = 2;
  public static final String LOG_TAG = "KingKongCommon";
  public static final String MAIN_INTERPROCESS_LOCK_FILE = "KingkongPatchInterprocess.Lock";
  public static final int PARAM_TYPE_ARBITRARY_VALUE = 3;
  public static final int PARAM_TYPE_MAX = 5;
  public static final int PARAM_TYPE_MIN = 0;
  public static final int PARAM_TYPE_OFFSET_TO_FILE = 2;
  public static final int PARAM_TYPE_OFFSET_TO_FUNCTION = 1;
  public static final int PARAM_TYPE_SYMBOL_ADDRESS = 4;
  public static final String PATCH_DOWNLOAD_FOLDER = "download";
  public static final String PATCH_FOLDER = "patches";
  public static final String PATCH_ROOT_FOLDER = "kingkong";
  public static final String SHARED_PREFERENCE_DO_PATCH_REPORT_PREFIX = "DO_PATCH";
  public static final String SHARED_PREFERENCE_DPC_STATUS = "DPC_STATUS";
  public static final String SHARED_PREFERENCE_FINGERPRINT_LIB = "FINGERPRINT_LIB";
  public static final String SHARED_PREFERENCE_FINGERPRINT_LIB_COUNT = "FINGERPRINT_LIB_COUNT";
  public static final String SHARED_PREFERENCE_FINGERPRINT_LIB_SHA1 = "FINGERPRINT_LIB_SHA1";
  public static final String SHARED_PREFERENCE_GOTHOOK_POINT = "GOTHOOK";
  public static final String SHARED_PREFERENCE_HOOKPOINT_COUNT = "HOOKPOINT_COUNT";
  public static final String SHARED_PREFERENCE_INITIAL_FAIL_REPORT = "INITIAL_FAILED";
  public static final String SHARED_PREFERENCE_JUMPER_POINT = "JUMPER";
  public static final String SHARED_PREFERENCE_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";
  public static final String SHARED_PREFERENCE_NAME = "SHARED_PREFERENCE_KINGKONG_PATCH";
  public static final String SHARED_PREFERENCE_PATCH_STATUS = "PATCH_STATUS";
  public static final String SHARED_PREFERENCE_QQUni = "QQUni";
  public static final String SHARED_PREFERENCE_SUBPATCH_INDEX = "SUBPATCH_INDEX";
  public static final String SHARED_PREFERENCE_UPDATE_STATUS = "UPDATE_STATUS";
  public static final String SP_DRIVER_FOLDER = "SP_DRIVER_FOLDER";
  public static final String SP_DRIVER_USING = "SP_DRIVER_USING";
  public static final String SP_DRIVER_VERSION = "SP_DRIVER_VERSION";
  public static final String SP_KEY_LIST = "SP_KEY_LIST";
  public static final String SP_MAX_UPDATE_INTERVAL = "SP_MAX_UPDATE_INTERVAL";
  public static final String UPDATE_INTERPROCESS_LOCK_FILE = "KingkongUpdateInterprocess.Lock";
  private static DexClassLoader dexClassLoader;
  public static boolean isCheckedDeviceSupport;
  public static boolean isDeviceSupportable;
  public static Context mContext = null;
  private static String mDriverAssetFolder = "";
  private static String mDriverFolder = "";
  public static String mFilesDir;
  public static boolean mInitFileFolderStatus;
  public static Utils.InterProcessLock mInterProcessLock;
  public static String mMainInterProcessFileName;
  public static String mPatchDownloadFolder;
  public static String mPatchFolder;
  public static String mPathSeparator;
  public static ReportThread mReportThread = null;
  public static SharedPreferences mSharedPref;
  public static SharedPreferences.Editor mSharedPrefEditor;
  public static boolean mStatus;
  public static boolean mThreadStatus;
  public static String mUpdateInterProcessFileName;
  public static UpdateThread mUpdateThread = null;
  
  static
  {
    mStatus = false;
    mThreadStatus = false;
    mInitFileFolderStatus = false;
    mSharedPref = null;
    mSharedPrefEditor = null;
    mInterProcessLock = null;
    isCheckedDeviceSupport = false;
    isDeviceSupportable = false;
    dexClassLoader = null;
    mFilesDir = "";
    mPatchDownloadFolder = "";
    mPatchFolder = "";
    mPathSeparator = File.separator;
    mMainInterProcessFileName = "";
    mUpdateInterProcessFileName = "";
  }
  
  public static void EvilReportFromNative(int paramInt, String paramString1, String paramString2)
  {
    Log.d("KingKongCommon", "Evil Report " + paramString1 + ", " + paramString2);
    if (mReportThread != null)
    {
      paramString1 = "&str1=" + paramString1 + "&str2=" + paramString2;
      mReportThread.report(paramInt, 0, 0, paramString1);
    }
  }
  
  public static String GetDownloadFolder()
  {
    return mPatchDownloadFolder;
  }
  
  public static String GetLastUpdateTime()
  {
    return mSharedPref.getString("LAST_UPDATE_TIME", "");
  }
  
  public static String GetMainInterProcessLockFile()
  {
    return mMainInterProcessFileName;
  }
  
  public static String GetPatchFolder()
  {
    return mPatchFolder;
  }
  
  public static String GetUpdateInterProcessLockFile()
  {
    return mUpdateInterProcessFileName;
  }
  
  public static String GetUpdateStatus()
  {
    return mSharedPref.getString("UPDATE_STATUS", "");
  }
  
  /* Error */
  public static void Init(Context paramContext, DexClassLoader paramDexClassLoader)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 40
    //   5: ldc 246
    //   7: invokestatic 220	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: invokestatic 250	com/tencent/kingkong/Common:shouldLoadSecureLibrary	()Z
    //   13: ifne +30 -> 43
    //   16: ldc 40
    //   18: new 201	java/lang/StringBuilder
    //   21: dup
    //   22: ldc 252
    //   24: invokespecial 206	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: getstatic 257	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   30: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 220	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: ldc 2
    //   41: monitorexit
    //   42: return
    //   43: aload_0
    //   44: invokestatic 261	com/tencent/kingkong/Common:SetContext	(Landroid/content/Context;)V
    //   47: getstatic 148	com/tencent/kingkong/Common:mContext	Landroid/content/Context;
    //   50: ifnull -11 -> 39
    //   53: getstatic 154	com/tencent/kingkong/Common:mStatus	Z
    //   56: ifne -17 -> 39
    //   59: getstatic 156	com/tencent/kingkong/Common:mThreadStatus	Z
    //   62: ifne -23 -> 39
    //   65: iconst_1
    //   66: putstatic 156	com/tencent/kingkong/Common:mThreadStatus	Z
    //   69: aload_1
    //   70: ifnull -31 -> 39
    //   73: aload_1
    //   74: invokestatic 265	com/tencent/kingkong/Common:setDexClassLoader	(Ldalvik/system/DexClassLoader;)V
    //   77: invokestatic 268	com/tencent/kingkong/Common:initFileFolder	()V
    //   80: getstatic 148	com/tencent/kingkong/Common:mContext	Landroid/content/Context;
    //   83: invokestatic 274	com/tencent/kingkong/Utils:getCurrentProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   86: getstatic 148	com/tencent/kingkong/Common:mContext	Landroid/content/Context;
    //   89: invokestatic 277	com/tencent/kingkong/Utils:getPackageName	(Landroid/content/Context;)Ljava/lang/String;
    //   92: invokevirtual 283	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifeq +6 -> 101
    //   98: invokestatic 286	com/tencent/kingkong/Common:checkDriverVersion	()V
    //   101: new 8	com/tencent/kingkong/Common$2
    //   104: dup
    //   105: invokespecial 287	com/tencent/kingkong/Common$2:<init>	()V
    //   108: invokevirtual 290	com/tencent/kingkong/Common$2:start	()V
    //   111: ldc 40
    //   113: ldc_w 292
    //   116: invokestatic 220	com/tencent/kingkong/Common$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: goto -80 -> 39
    //   122: astore_0
    //   123: ldc 2
    //   125: monitorexit
    //   126: aload_0
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramContext	Context
    //   0	128	1	paramDexClassLoader	DexClassLoader
    // Exception table:
    //   from	to	target	type
    //   3	39	122	finally
    //   43	69	122	finally
    //   73	101	122	finally
    //   101	119	122	finally
  }
  
  public static void NotificationFromNative(int paramInt1, int paramInt2, int paramInt3)
  {
    Log.d("KingKongCommon", "Notification From Native " + paramInt1 + ", " + paramInt2 + ", " + paramInt3);
    if (mReportThread != null) {
      mReportThread.report(paramInt1, paramInt2, paramInt3, "");
    }
  }
  
  /* Error */
  public static void OnLogin(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 261	com/tencent/kingkong/Common:SetContext	(Landroid/content/Context;)V
    //   7: getstatic 148	com/tencent/kingkong/Common:mContext	Landroid/content/Context;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnonnull +7 -> 19
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_1
    //   20: invokestatic 304	com/tencent/kingkong/Common:SetQQUni	(Ljava/lang/String;)V
    //   23: getstatic 150	com/tencent/kingkong/Common:mReportThread	Lcom/tencent/kingkong/ReportThread;
    //   26: ifnonnull +19 -> 45
    //   29: new 226	com/tencent/kingkong/ReportThread
    //   32: dup
    //   33: invokespecial 305	com/tencent/kingkong/ReportThread:<init>	()V
    //   36: putstatic 150	com/tencent/kingkong/Common:mReportThread	Lcom/tencent/kingkong/ReportThread;
    //   39: getstatic 150	com/tencent/kingkong/Common:mReportThread	Lcom/tencent/kingkong/ReportThread;
    //   42: invokevirtual 306	com/tencent/kingkong/ReportThread:start	()V
    //   45: new 6	com/tencent/kingkong/Common$1
    //   48: dup
    //   49: invokespecial 307	com/tencent/kingkong/Common$1:<init>	()V
    //   52: invokevirtual 308	com/tencent/kingkong/Common$1:start	()V
    //   55: goto -40 -> 15
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramContext	Context
    //   0	64	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	11	58	finally
    //   19	45	58	finally
    //   45	55	58	finally
  }
  
  public static void SetContext(Context paramContext)
  {
    if ((paramContext != null) && (mContext == null))
    {
      mContext = paramContext.getApplicationContext();
      DataReport.setContext(mContext);
    }
  }
  
  public static void SetDPCStatus(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).edit();
    paramContext.putBoolean("DPC_STATUS", paramBoolean);
    paramContext.commit();
  }
  
  public static void SetLastUpdateTime(String paramString)
  {
    mSharedPrefEditor.putString("LAST_UPDATE_TIME", paramString);
    mSharedPrefEditor.commit();
  }
  
  public static void SetQQUni(String paramString)
  {
    DataReport.setQQUni(paramString);
  }
  
  public static void SetUpdateStatus(String paramString)
  {
    mSharedPrefEditor.putString("UPDATE_STATUS", paramString);
    mSharedPrefEditor.commit();
  }
  
  public static boolean SystemReady()
  {
    return mStatus;
  }
  
  private static void checkDriverVersion()
  {
    Log.d("KingKongCommon", "checkDriverVersion begin");
    if ((mSharedPref != null) && (mSharedPrefEditor != null))
    {
      localObject = mSharedPref.getString("SP_DRIVER_VERSION", "");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label80;
      }
      Log.d("KingKongCommon", "driverVersionInSP is empty.");
      mSharedPrefEditor.putString("SP_DRIVER_VERSION", "3.0");
      mSharedPrefEditor.commit();
    }
    label80:
    while (((String)localObject).equals("3.0"))
    {
      Log.d("KingKongCommon", "checkDriverVersion end");
      return;
    }
    Log.d("KingKongCommon", "driver version change, need clear patches except driver patch.");
    Object localObject = MainConfig.getMainConfig(mContext).getPatchList().iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        mSharedPrefEditor.putString("SP_DRIVER_VERSION", "3.0");
        mSharedPrefEditor.commit();
        break;
      }
      PatchInfo localPatchInfo = (PatchInfo)((Iterator)localObject).next();
      if (!localPatchInfo.mType.equals("Driver"))
      {
        localPatchInfo.mStatus = "DISABLED";
        Log.d("KingKongCommon", "clear patch : " + localPatchInfo.mFlag);
      }
    }
  }
  
  private static String concat(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  private static String concat(String paramString1, String paramString2, int paramInt)
  {
    return paramString1 + "_" + paramString2 + "_" + paramInt;
  }
  
  private static boolean getDPCStatus()
  {
    return true;
  }
  
  public static DexClassLoader getDexClassLoader()
  {
    return dexClassLoader;
  }
  
  public static String getDriverFolder()
  {
    if (mSharedPref != null)
    {
      if (TextUtils.isEmpty(mDriverFolder)) {
        mDriverFolder = mSharedPref.getString("SP_DRIVER_FOLDER", mDriverAssetFolder);
      }
      return mDriverFolder;
    }
    return mDriverAssetFolder;
  }
  
  public static boolean getDriverUsing()
  {
    boolean bool = true;
    if (mSharedPref != null) {
      bool = mSharedPref.getBoolean("SP_DRIVER_USING", true);
    }
    return bool;
  }
  
  public static long getMaxUpdateInterval()
  {
    long l = 21600000L;
    if (mSharedPref != null) {
      l = mSharedPref.getLong("SP_MAX_UPDATE_INTERVAL", 21600000L);
    }
    return l;
  }
  
  public static int[] getPatchGotHookPoints(String paramString)
  {
    int j = mSharedPref.getInt(concat("HOOKPOINT_COUNT", paramString), -1);
    Object localObject;
    if (j == -1)
    {
      localObject = null;
      return localObject;
    }
    int[] arrayOfInt = new int[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfInt;
      if (i >= j) {
        break;
      }
      arrayOfInt[i] = mSharedPref.getInt(concat("GOTHOOK", paramString, i), -1);
      if (arrayOfInt[i] == -1) {
        return null;
      }
      i += 1;
    }
  }
  
  public static int[] getPatchJumperPoints(String paramString)
  {
    int j = mSharedPref.getInt(concat("HOOKPOINT_COUNT", paramString), -1);
    Object localObject;
    if (j == -1)
    {
      localObject = null;
      return localObject;
    }
    int[] arrayOfInt = new int[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfInt;
      if (i >= j) {
        break;
      }
      arrayOfInt[i] = mSharedPref.getInt(concat("JUMPER", paramString, i), -1);
      if (arrayOfInt[i] == -1) {
        return null;
      }
      i += 1;
    }
  }
  
  private static boolean getPatchStatus()
  {
    return mSharedPref.getBoolean("PATCH_STATUS", true);
  }
  
  public static int getSubPatchIndex(String paramString, ArrayList<String> paramArrayList)
  {
    int j = mSharedPref.getInt(concat("FINGERPRINT_LIB_COUNT", paramString), -1);
    if ((j == -1) || (j != paramArrayList.size()))
    {
      Log.d("KingKongCommon", "Library count mismatch " + j + ", " + paramArrayList.size());
      return -1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return mSharedPref.getInt(concat("SUBPATCH_INDEX", paramString), -1);
      }
      String str1 = mSharedPref.getString(concat("FINGERPRINT_LIB", paramString, i), "");
      if (!((String)paramArrayList.get(i)).equals(str1))
      {
        Log.d("KingKongCommon", "Library name mismatch " + str1 + ", " + (String)paramArrayList.get(i));
        return -1;
      }
      String str2 = Utils.getFileSHA1String(str1);
      if (TextUtils.isEmpty(str2))
      {
        Log.d("KingKongCommon", "Unable to get file SHA1 " + str1);
        return -1;
      }
      String str3 = mSharedPref.getString(concat("FINGERPRINT_LIB_SHA1", paramString, i), "");
      if (!str3.equals(str2))
      {
        Log.d("KingKongCommon", "Library SHA1 mismatch " + str1 + ", " + str3 + ", " + str2);
        return -1;
      }
      i += 1;
    }
  }
  
  /* Error */
  public static void initFileFolder()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 158	com/tencent/kingkong/Common:mInitFileFolderStatus	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 158	com/tencent/kingkong/Common:mInitFileFolderStatus	Z
    //   19: getstatic 148	com/tencent/kingkong/Common:mContext	Landroid/content/Context;
    //   22: ldc 91
    //   24: iconst_0
    //   25: invokevirtual 325	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   28: putstatic 160	com/tencent/kingkong/Common:mSharedPref	Landroid/content/SharedPreferences;
    //   31: getstatic 160	com/tencent/kingkong/Common:mSharedPref	Landroid/content/SharedPreferences;
    //   34: invokeinterface 329 1 0
    //   39: putstatic 162	com/tencent/kingkong/Common:mSharedPrefEditor	Landroid/content/SharedPreferences$Editor;
    //   42: getstatic 148	com/tencent/kingkong/Common:mContext	Landroid/content/Context;
    //   45: invokevirtual 476	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 479	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: putstatic 174	com/tencent/kingkong/Common:mFilesDir	Ljava/lang/String;
    //   54: new 201	java/lang/StringBuilder
    //   57: dup
    //   58: getstatic 174	com/tencent/kingkong/Common:mFilesDir	Ljava/lang/String;
    //   61: invokestatic 418	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokespecial 206	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: getstatic 185	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   70: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 58
    //   75: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: getstatic 185	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   81: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 52
    //   86: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: putstatic 176	com/tencent/kingkong/Common:mPatchDownloadFolder	Ljava/lang/String;
    //   95: new 201	java/lang/StringBuilder
    //   98: dup
    //   99: getstatic 174	com/tencent/kingkong/Common:mFilesDir	Ljava/lang/String;
    //   102: invokestatic 418	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   105: invokespecial 206	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: getstatic 185	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   111: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 58
    //   116: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 185	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   122: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 55
    //   127: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: putstatic 178	com/tencent/kingkong/Common:mPatchFolder	Ljava/lang/String;
    //   136: new 201	java/lang/StringBuilder
    //   139: dup
    //   140: getstatic 178	com/tencent/kingkong/Common:mPatchFolder	Ljava/lang/String;
    //   143: invokestatic 418	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   146: invokespecial 206	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: getstatic 185	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   152: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 15
    //   157: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: putstatic 191	com/tencent/kingkong/Common:mDriverAssetFolder	Ljava/lang/String;
    //   166: new 201	java/lang/StringBuilder
    //   169: dup
    //   170: getstatic 174	com/tencent/kingkong/Common:mFilesDir	Ljava/lang/String;
    //   173: invokestatic 418	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   176: invokespecial 206	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   179: getstatic 185	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   182: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 43
    //   187: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: putstatic 187	com/tencent/kingkong/Common:mMainInterProcessFileName	Ljava/lang/String;
    //   196: new 201	java/lang/StringBuilder
    //   199: dup
    //   200: getstatic 174	com/tencent/kingkong/Common:mFilesDir	Ljava/lang/String;
    //   203: invokestatic 418	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   206: invokespecial 206	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: getstatic 185	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   212: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc 116
    //   217: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: putstatic 189	com/tencent/kingkong/Common:mUpdateInterProcessFileName	Ljava/lang/String;
    //   226: new 481	com/tencent/kingkong/Utils$InterProcessLock
    //   229: dup
    //   230: getstatic 187	com/tencent/kingkong/Common:mMainInterProcessFileName	Ljava/lang/String;
    //   233: invokespecial 482	com/tencent/kingkong/Utils$InterProcessLock:<init>	(Ljava/lang/String;)V
    //   236: putstatic 164	com/tencent/kingkong/Common:mInterProcessLock	Lcom/tencent/kingkong/Utils$InterProcessLock;
    //   239: goto -228 -> 11
    //   242: astore_1
    //   243: ldc 2
    //   245: monitorexit
    //   246: aload_1
    //   247: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   242	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	242	finally
    //   15	239	242	finally
  }
  
  public static String makeDownloadName(String paramString)
  {
    return mPatchDownloadFolder + mPathSeparator + paramString;
  }
  
  public static String makeInstallName(String paramString)
  {
    return mPatchFolder + mPathSeparator + paramString;
  }
  
  public static boolean removePatchSPs(String paramString)
  {
    int i = 0;
    label10:
    Object localObject;
    int j;
    if (i >= 13)
    {
      i = 0;
      if (i < 15) {
        break label145;
      }
      mSharedPrefEditor.remove(concat("FINGERPRINT_LIB_COUNT", paramString));
      mSharedPrefEditor.remove(concat("SUBPATCH_INDEX", paramString));
      mSharedPrefEditor.remove(concat("HOOKPOINT_COUNT", paramString));
      localObject = mSharedPref.getString(concat("SP_KEY_LIST", paramString), "").split(";");
      j = localObject.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        mSharedPrefEditor.remove(concat("SP_KEY_LIST", paramString));
        mSharedPrefEditor.commit();
        return true;
        localObject = concat("DO_PATCH", paramString, i);
        mSharedPrefEditor.remove((String)localObject);
        i += 1;
        break;
        label145:
        mSharedPrefEditor.remove(concat("FINGERPRINT_LIB", paramString, i));
        mSharedPrefEditor.remove(concat("FINGERPRINT_LIB_SHA1", paramString, i));
        mSharedPrefEditor.remove(concat("GOTHOOK", paramString, i));
        mSharedPrefEditor.remove(concat("JUMPER", paramString, i));
        i += 1;
        break label10;
      }
      CharSequence localCharSequence = localObject[i];
      if (!TextUtils.isEmpty(localCharSequence))
      {
        Log.d("KingKongCommon", "remove config : " + localCharSequence);
        mSharedPrefEditor.remove(localCharSequence);
      }
      i += 1;
    }
  }
  
  public static void reportByType(int paramInt, String paramString1, String paramString2)
  {
    if (mReportThread != null) {}
    try
    {
      mReportThread.report(paramInt, 0, 0, "&str1=" + URLEncoder.encode(paramString1, "UTF-8") + "&str3=" + URLEncoder.encode(paramString2, "UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void reportDoPatch(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Log.d("KingKongCommon", "Do patch " + paramInt + ", " + paramString1 + ", " + paramString2 + ", " + paramString3 + ", " + paramString4);
    String str = concat("DO_PATCH", paramString1, paramInt);
    if ((!mSharedPref.getBoolean(str, false)) && (mReportThread != null)) {}
    try
    {
      mReportThread.report(2081, paramInt, 0, "&str1=" + URLEncoder.encode(paramString1, "UTF-8") + "&str2=" + URLEncoder.encode(paramString2, "UTF-8") + "&str3=" + URLEncoder.encode(paramString3, "UTF-8") + "&v1=" + URLEncoder.encode(paramString4, "UTF-8"));
      mSharedPrefEditor.putBoolean(str, true);
      mSharedPrefEditor.commit();
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void reportEvilCatched(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Log.d("KingKongCommon", "evil catched " + paramInt + ", " + paramString1 + ", " + paramString2 + ", " + paramString3 + ", " + paramString4);
    if (mReportThread != null) {}
    try
    {
      mReportThread.report(2082, paramInt, 0, "&str1=" + URLEncoder.encode(paramString1, "UTF-8") + "&str2=" + URLEncoder.encode(paramString2, "UTF-8") + "&str3=" + URLEncoder.encode(paramString3, "UTF-8") + "&v1=" + URLEncoder.encode(paramString4, "UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void reportFingerprint(String paramString, int[] paramArrayOfInt)
  {
    String str;
    int i;
    if (mReportThread != null)
    {
      Log.d("KingKongCommon", "Report fingerprint : " + paramString);
      str = "";
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfInt.length) {}
      try
      {
        paramString = new StringBuilder(String.valueOf("")).append("&str1=").append(URLEncoder.encode(paramString, "UTF-8")).toString() + str;
        mReportThread.report(2086, 0, 0, paramString);
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
      }
      str = str + "&v" + (i + 1) + "=" + paramArrayOfInt[i];
      i += 1;
    }
  }
  
  public static void setDexClassLoader(DexClassLoader paramDexClassLoader)
  {
    dexClassLoader = paramDexClassLoader;
  }
  
  public static void setDriverFolder(String paramString)
  {
    if (mSharedPrefEditor != null) {
      mSharedPrefEditor.putString("SP_DRIVER_FOLDER", paramString);
    }
  }
  
  public static void setDriverUsing(boolean paramBoolean)
  {
    if (mSharedPrefEditor != null) {
      mSharedPrefEditor.putBoolean("SP_DRIVER_USING", paramBoolean);
    }
  }
  
  public static void setDriverValue(String paramString1, String paramString2)
  {
    if (mSharedPrefEditor != null)
    {
      mSharedPrefEditor.putString(paramString1, paramString2);
      mSharedPrefEditor.commit();
    }
  }
  
  public static void setMaxUpdateInterval(long paramLong)
  {
    if (mSharedPrefEditor != null) {
      mSharedPrefEditor.putLong("SP_MAX_UPDATE_INTERVAL", paramLong);
    }
  }
  
  public static void setPatchStatus(boolean paramBoolean)
  {
    mSharedPrefEditor.putBoolean("PATCH_STATUS", paramBoolean);
    mSharedPrefEditor.commit();
  }
  
  public static boolean shouldLoadSecureLibrary()
  {
    if (Build.VERSION.SDK_INT < 14) {
      return false;
    }
    return Build.CPU_ABI.contains("armeabi");
  }
  
  public static void storePatchHookParams(String paramString, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1.length != paramArrayOfInt2.length) || (paramArrayOfInt1.length > 15) || (paramArrayOfInt1.length != paramInt))
    {
      Log.d("KingKongCommon", "Params count mismatch : " + paramArrayOfInt1.length + ", " + paramArrayOfInt2.length + ", " + paramInt);
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramInt)
      {
        mSharedPrefEditor.putInt(concat("HOOKPOINT_COUNT", paramString), paramInt);
        mSharedPrefEditor.commit();
        return;
      }
      mSharedPrefEditor.putInt(concat("JUMPER", paramString, i), paramArrayOfInt1[i]);
      mSharedPrefEditor.putInt(concat("GOTHOOK", paramString, i), paramArrayOfInt2[i]);
      i += 1;
    }
  }
  
  public static void storeSubPatchIndex(String paramString, int paramInt, ArrayList<String> paramArrayList)
  {
    int j = paramArrayList.size();
    if (j > 15) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        mSharedPrefEditor.putInt(concat("FINGERPRINT_LIB_COUNT", paramString), j);
        mSharedPrefEditor.putInt(concat("SUBPATCH_INDEX", paramString), paramInt);
        mSharedPrefEditor.commit();
        return;
      }
      String str1 = (String)paramArrayList.get(i);
      String str2 = Utils.getFileSHA1String(str1);
      if (TextUtils.isEmpty(str2)) {
        break;
      }
      mSharedPrefEditor.putString(concat("FINGERPRINT_LIB_SHA1", paramString, i), str2);
      mSharedPrefEditor.putString(concat("FINGERPRINT_LIB", paramString, i), str1);
      i += 1;
    }
  }
  
  public static class Log
  {
    public static void d(String paramString1, String paramString2)
    {
      Log.d("KingKong", paramString1 + " || " + paramString2);
    }
    
    public static void v(String paramString1, String paramString2)
    {
      Log.d("KingKong", paramString1 + " || " + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\assets\KingkongPatch_apk\KingkongPatchDriver.jar\classes.jar
 * Qualified Name:     com.tencent.kingkong.Common
 * JD-Core Version:    0.7.0.1
 */