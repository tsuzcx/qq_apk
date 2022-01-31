package com.tencent.kingkong;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Common
{
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
  public static final String SHARED_PREFERENCE_INITIALIZE_STATUS = "INITIALIZE_STATUS";
  public static final String SHARED_PREFERENCE_INITIAL_FAIL_REPORT = "INITIAL_FAILED";
  public static final String SHARED_PREFERENCE_JUMPER_POINT = "JUMPER";
  public static final String SHARED_PREFERENCE_LAST_UPDATE_TIME = "LAST_UPDATE_TIME";
  public static final String SHARED_PREFERENCE_NAME = "SHARED_PREFERENCE_KINGKONG_PATCH";
  public static final String SHARED_PREFERENCE_PATCH_STATUS = "PATCH_STATUS";
  public static final String SHARED_PREFERENCE_POINT_LOG = "POINT_LOG";
  public static final String SHARED_PREFERENCE_POINT_LOG_CONTINUOUS_COUNT = "POINT_LOG_CONTINUOUS_COUNT";
  public static final String SHARED_PREFERENCE_POINT_LOG_CRASH_COUNT = "POINT_LOG_CRASH_COUNT";
  public static final String SHARED_PREFERENCE_QQUni = "QQUni";
  public static final String SHARED_PREFERENCE_SUBPATCH_INDEX = "SUBPATCH_INDEX";
  public static final String SHARED_PREFERENCE_UPDATE_STATUS = "UPDATE_STATUS";
  public static final int STATUS_INITIALIZED_PATCH_MANAGER = 1;
  public static final int STATUS_INITIALIZE_PATCH_MANAGER_FAILED = 2;
  public static final int STATUS_INITIALIZE_UPDATE_MANAGER_FAILED = 3;
  public static final int STATUS_UNINITIALIZED = 0;
  public static final String UPDATE_INTERPROCESS_LOCK_FILE = "KingkongUpdateInterprocess.Lock";
  public static boolean isCheckedDeviceSupport;
  public static boolean isDeviceSupportable;
  public static Context mContext = null;
  public static String mFilesDir;
  public static boolean mInitFileFolderStatus;
  public static Utils.InterProcessLock mInterProcessLock;
  public static String mMainInterProcessFileName = "";
  public static String mPatchDownloadFolder;
  public static String mPatchFolder;
  public static String mPathSeparator;
  public static ReportThread mReportThread = null;
  public static SharedPreferences mSharedPref;
  public static SharedPreferences.Editor mSharedPrefEditor;
  public static boolean mStatus = false;
  public static boolean mThreadStatus = false;
  public static String mUpdateInterProcessFileName = "";
  
  static
  {
    mInitFileFolderStatus = false;
    mSharedPref = null;
    mSharedPrefEditor = null;
    mInterProcessLock = null;
    isCheckedDeviceSupport = false;
    isDeviceSupportable = false;
    mFilesDir = "";
    mPatchDownloadFolder = "";
    mPatchFolder = "";
    mPathSeparator = File.separator;
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
  
  public static int GetInitializeStatus()
  {
    return mSharedPref.getInt("INITIALIZE_STATUS", 0);
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
    //   4: invokestatic 250	com/tencent/kingkong/Common:SetContext	(Landroid/content/Context;)V
    //   7: getstatic 145	com/tencent/kingkong/Common:mContext	Landroid/content/Context;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnonnull +7 -> 19
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_1
    //   20: invokestatic 253	com/tencent/kingkong/Common:SetQQUni	(Ljava/lang/String;)V
    //   23: getstatic 147	com/tencent/kingkong/Common:mReportThread	Lcom/tencent/kingkong/ReportThread;
    //   26: ifnonnull +19 -> 45
    //   29: new 215	com/tencent/kingkong/ReportThread
    //   32: dup
    //   33: invokespecial 254	com/tencent/kingkong/ReportThread:<init>	()V
    //   36: putstatic 147	com/tencent/kingkong/Common:mReportThread	Lcom/tencent/kingkong/ReportThread;
    //   39: getstatic 147	com/tencent/kingkong/Common:mReportThread	Lcom/tencent/kingkong/ReportThread;
    //   42: invokevirtual 257	com/tencent/kingkong/ReportThread:start	()V
    //   45: new 6	com/tencent/kingkong/Common$1
    //   48: dup
    //   49: invokespecial 258	com/tencent/kingkong/Common$1:<init>	()V
    //   52: invokevirtual 259	com/tencent/kingkong/Common$1:start	()V
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
  
  public static void SetInitializeStatus(int paramInt)
  {
    mSharedPrefEditor.putInt("INITIALIZE_STATUS", paramInt);
    mSharedPrefEditor.commit();
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
  
  /* Error */
  public static void SetSafeStatus(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 309	com/tencent/kingkong/Common:shouldLoadSecureLibrary	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 145	com/tencent/kingkong/Common:mContext	Landroid/content/Context;
    //   18: ifnull -7 -> 11
    //   21: iload_0
    //   22: ifeq -11 -> 11
    //   25: getstatic 149	com/tencent/kingkong/Common:mStatus	Z
    //   28: ifne -17 -> 11
    //   31: getstatic 151	com/tencent/kingkong/Common:mThreadStatus	Z
    //   34: ifne -23 -> 11
    //   37: iconst_1
    //   38: putstatic 151	com/tencent/kingkong/Common:mThreadStatus	Z
    //   41: invokestatic 312	com/tencent/kingkong/Common:initFileFolder	()V
    //   44: new 8	com/tencent/kingkong/Common$2
    //   47: dup
    //   48: invokespecial 313	com/tencent/kingkong/Common$2:<init>	()V
    //   51: invokevirtual 314	com/tencent/kingkong/Common$2:start	()V
    //   54: goto -43 -> 11
    //   57: astore_2
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramBoolean	boolean
    //   6	2	1	bool	boolean
    //   57	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	57	finally
    //   15	21	57	finally
    //   25	54	57	finally
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
  
  private static boolean checkPatchStatus()
  {
    int i = getPointLogCount();
    if (i >= 0)
    {
      if (getPointLog() == 0) {
        break label46;
      }
      setPointLogCount(i + 1);
      i = getPointLogContinuousCrashCount();
      if (i >= 2)
      {
        setPatchStatus(false);
        reportPointLog();
        return false;
      }
      setPointLogContinuousCrashCount(i + 1);
    }
    for (;;)
    {
      return true;
      label46:
      setPointLogContinuousCrashCount(0);
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
  
  private static int getPointLog()
  {
    return mSharedPref.getInt("POINT_LOG", 0);
  }
  
  private static int getPointLogContinuousCrashCount()
  {
    return mSharedPref.getInt("POINT_LOG_CONTINUOUS_COUNT", 0);
  }
  
  private static int getPointLogCount()
  {
    return mSharedPref.getInt("POINT_LOG_CRASH_COUNT", 0);
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
    //   3: getstatic 153	com/tencent/kingkong/Common:mInitFileFolderStatus	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 153	com/tencent/kingkong/Common:mInitFileFolderStatus	Z
    //   19: getstatic 145	com/tencent/kingkong/Common:mContext	Landroid/content/Context;
    //   22: ldc 91
    //   24: iconst_0
    //   25: invokevirtual 276	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   28: putstatic 155	com/tencent/kingkong/Common:mSharedPref	Landroid/content/SharedPreferences;
    //   31: getstatic 155	com/tencent/kingkong/Common:mSharedPref	Landroid/content/SharedPreferences;
    //   34: invokeinterface 280 1 0
    //   39: putstatic 157	com/tencent/kingkong/Common:mSharedPrefEditor	Landroid/content/SharedPreferences$Editor;
    //   42: getstatic 145	com/tencent/kingkong/Common:mContext	Landroid/content/Context;
    //   45: invokevirtual 411	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 414	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: putstatic 167	com/tencent/kingkong/Common:mFilesDir	Ljava/lang/String;
    //   54: new 190	java/lang/StringBuilder
    //   57: dup
    //   58: getstatic 167	com/tencent/kingkong/Common:mFilesDir	Ljava/lang/String;
    //   61: invokestatic 356	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokespecial 195	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: getstatic 178	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   70: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 55
    //   75: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: getstatic 178	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   81: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 49
    //   86: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: putstatic 169	com/tencent/kingkong/Common:mPatchDownloadFolder	Ljava/lang/String;
    //   95: new 190	java/lang/StringBuilder
    //   98: dup
    //   99: getstatic 167	com/tencent/kingkong/Common:mFilesDir	Ljava/lang/String;
    //   102: invokestatic 356	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   105: invokespecial 195	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: getstatic 178	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   111: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 55
    //   116: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 178	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   122: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 52
    //   127: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: putstatic 171	com/tencent/kingkong/Common:mPatchFolder	Ljava/lang/String;
    //   136: new 190	java/lang/StringBuilder
    //   139: dup
    //   140: getstatic 167	com/tencent/kingkong/Common:mFilesDir	Ljava/lang/String;
    //   143: invokestatic 356	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   146: invokespecial 195	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: getstatic 178	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   152: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 40
    //   157: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: putstatic 180	com/tencent/kingkong/Common:mMainInterProcessFileName	Ljava/lang/String;
    //   166: new 190	java/lang/StringBuilder
    //   169: dup
    //   170: getstatic 167	com/tencent/kingkong/Common:mFilesDir	Ljava/lang/String;
    //   173: invokestatic 356	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   176: invokespecial 195	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   179: getstatic 178	com/tencent/kingkong/Common:mPathSeparator	Ljava/lang/String;
    //   182: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 119
    //   187: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: putstatic 182	com/tencent/kingkong/Common:mUpdateInterProcessFileName	Ljava/lang/String;
    //   196: new 416	com/tencent/kingkong/Utils$InterProcessLock
    //   199: dup
    //   200: getstatic 180	com/tencent/kingkong/Common:mMainInterProcessFileName	Ljava/lang/String;
    //   203: invokespecial 417	com/tencent/kingkong/Utils$InterProcessLock:<init>	(Ljava/lang/String;)V
    //   206: putstatic 159	com/tencent/kingkong/Common:mInterProcessLock	Lcom/tencent/kingkong/Utils$InterProcessLock;
    //   209: goto -198 -> 11
    //   212: astore_1
    //   213: ldc 2
    //   215: monitorexit
    //   216: aload_1
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   212	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	212	finally
    //   15	209	212	finally
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
    if (i >= 13) {
      i = 0;
    }
    for (;;)
    {
      if (i >= 15)
      {
        mSharedPrefEditor.remove(concat("FINGERPRINT_LIB_COUNT", paramString));
        mSharedPrefEditor.remove(concat("SUBPATCH_INDEX", paramString));
        mSharedPrefEditor.remove(concat("HOOKPOINT_COUNT", paramString));
        mSharedPrefEditor.commit();
        return true;
        String str = concat("DO_PATCH", paramString, i);
        mSharedPrefEditor.remove(str);
        i += 1;
        break;
      }
      mSharedPrefEditor.remove(concat("FINGERPRINT_LIB", paramString, i));
      mSharedPrefEditor.remove(concat("FINGERPRINT_LIB_SHA1", paramString, i));
      mSharedPrefEditor.remove(concat("GOTHOOK", paramString, i));
      mSharedPrefEditor.remove(concat("JUMPER", paramString, i));
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
  
  public static void reportPointLog()
  {
    int i = getPointLogCount();
    StringBuffer localStringBuffer = new StringBuffer();
    int j = getPointLog();
    try
    {
      localStringBuffer.append("&str1=").append(URLEncoder.encode(Integer.toString(i), "UTF-8")).append("&str2=").append(URLEncoder.encode(Integer.toString(j), "UTF-8"));
      if (mReportThread != null) {
        mReportThread.report(2087, 0, 0, localStringBuffer.toString());
      }
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public static void savePointLog(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Constant.LogPoint += 1;; Constant.LogPoint = 0)
    {
      setPointLog(Constant.LogPoint);
      return;
    }
  }
  
  public static void setPatchStatus(boolean paramBoolean)
  {
    mSharedPrefEditor.putBoolean("PATCH_STATUS", paramBoolean);
    mSharedPrefEditor.commit();
  }
  
  private static void setPointLog(int paramInt)
  {
    mSharedPrefEditor.putInt("POINT_LOG", paramInt);
    mSharedPrefEditor.commit();
  }
  
  private static void setPointLogContinuousCrashCount(int paramInt)
  {
    mSharedPrefEditor.putInt("POINT_LOG_CONTINUOUS_COUNT", paramInt);
    mSharedPrefEditor.commit();
  }
  
  private static void setPointLogCount(int paramInt)
  {
    mSharedPrefEditor.putInt("POINT_LOG_CRASH_COUNT", paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.Common
 * JD-Core Version:    0.7.0.1
 */