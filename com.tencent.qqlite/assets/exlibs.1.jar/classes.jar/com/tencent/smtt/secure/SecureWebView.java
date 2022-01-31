package com.tencent.smtt.secure;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.smtt.sdk.QbSdkLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

public class SecureWebView
{
  private static final String DEFAULT_JS_FILE_NAME = "safe_uxss.js";
  private static final String ERROR_REPORTED_SHARED_PREFERENCE = "SHARED_PREFERENCE_ERROR_REPORTED";
  private static final String FILE_MD5_SHARED_PREFERENCE = "SHARED_PREFERENCE_FILE_MD5";
  public static final String LOG_TAG = "NativeSafeWebViewClient";
  public static final int NOTIFICATION_TYPE_FUNCTION_FOUND = 2;
  public static final int NOTIFICATION_TYPE_SEARCH_FUNCTION_FAIL = 5;
  public static final int NOTIFICATION_TYPE_SEARCH_VIRTUAL_FUNCTION_FAIL = 4;
  public static final int NOTIFICATION_TYPE_UNEXPECTED_VT_INDEX = 3;
  public static final int NOTIFICATION_TYPE_UNINSTALL_DONE = 1;
  public static final int NOTIFICATION_TYPE_UPDATE_DONE = 10;
  public static final int NOTIFICATION_TYPE_VIRTUAL_FUNCTION = 0;
  private static final boolean PERFORMANCE_TEST_MODE = false;
  private static final String SHARED_PREFERENCE_NAME = "SHARED_PREFERENCE_SECURE_WEBVIEW";
  public static final int STATUS_DEFAULT = 0;
  public static final int STATUS_DISABLE = 2;
  public static final int STATUS_SKIP_LOAD_SO = 1;
  private static final int UINT32_MAX = -1;
  private static final String VT_SHARED_PREFERENCE_PREFIX = "SHARED_PREFERENCE_VT_INDEX_";
  private static final int VT_SHARED_PREFERNCE_COUNT = 9;
  private static Context mContext;
  private static boolean mExistX5WebViewExtension = false;
  private static boolean mLibraryInitialed;
  private static boolean mLibraryLoaded = false;
  private static boolean mLoadLibraryFail = false;
  private static ReportThread mReportThread = null;
  private static UpdateManager mUpdateManager = null;
  private static String mUserDefineJSFileName;
  
  static
  {
    mLibraryInitialed = false;
    mContext = null;
    mUserDefineJSFileName = "";
  }
  
  private static native boolean GetSafeStatus();
  
  public static void LogFromNative(String paramString1, String paramString2)
  {
    QbSdkLog.e(paramString1, paramString2);
  }
  
  public static void NotificationFromNative(int paramInt1, int paramInt2, int paramInt3)
  {
    if (mContext == null) {}
    label155:
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      }
      for (;;)
      {
        if ((paramInt1 != 3) && (paramInt1 != 4) && (paramInt1 != 5)) {
          break label155;
        }
        Object localObject = mContext.getSharedPreferences("SHARED_PREFERENCE_SECURE_WEBVIEW", 0);
        if (((SharedPreferences)localObject).getBoolean("SHARED_PREFERENCE_ERROR_REPORTED", false)) {
          break;
        }
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("SHARED_PREFERENCE_ERROR_REPORTED", true);
        ((SharedPreferences.Editor)localObject).commit();
        if (mReportThread == null) {
          break;
        }
        mReportThread.report(paramInt1, paramInt2, paramInt3);
        return;
        localObject = mContext.getSharedPreferences("SHARED_PREFERENCE_SECURE_WEBVIEW", 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("SHARED_PREFERENCE_VT_INDEX_" + paramInt2, paramInt3);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  private static native boolean SetJSFilePath(String paramString);
  
  private static native boolean SetSafeStatus(boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void SetVirtualFunction(int paramInt1, int paramInt2, int paramInt3);
  
  private static void copyAssetToFiles(Context paramContext, String paramString)
  {
    if (!paramContext.getFileStreamPath(paramString).exists()) {}
    try
    {
      paramContext = paramContext.openFileOutput(paramString, 0);
      paramContext.write(SafeUxssJS.safeuxss, 0, SafeUxssJS.safeuxss.length);
      paramContext.close();
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static int getJSVersionCode(Context paramContext)
  {
    return UpdateManager.getJSVersion(paramContext);
  }
  
  /* Error */
  private static String getMd5ByFile(String paramString)
  {
    // Byte code:
    //   0: ldc 70
    //   2: astore_3
    //   3: aconst_null
    //   4: astore_1
    //   5: aconst_null
    //   6: astore_2
    //   7: new 156	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 159	java/io/File:exists	()Z
    //   22: ifne +6 -> 28
    //   25: ldc 70
    //   27: areturn
    //   28: aload_1
    //   29: astore_0
    //   30: new 197	java/io/FileInputStream
    //   33: dup
    //   34: aload 4
    //   36: invokespecial 200	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 204	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   44: getstatic 210	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   47: lconst_0
    //   48: aload 4
    //   50: invokevirtual 214	java/io/File:length	()J
    //   53: invokevirtual 220	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   56: astore_0
    //   57: ldc 222
    //   59: invokestatic 228	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   62: astore_2
    //   63: aload_2
    //   64: aload_0
    //   65: invokevirtual 232	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   68: new 234	java/math/BigInteger
    //   71: dup
    //   72: iconst_1
    //   73: aload_2
    //   74: invokevirtual 238	java/security/MessageDigest:digest	()[B
    //   77: invokespecial 241	java/math/BigInteger:<init>	(I[B)V
    //   80: bipush 16
    //   82: invokevirtual 244	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   85: astore_0
    //   86: aload_1
    //   87: ifnull +84 -> 171
    //   90: aload_1
    //   91: invokevirtual 245	java/io/FileInputStream:close	()V
    //   94: aload_0
    //   95: areturn
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   101: goto -7 -> 94
    //   104: astore_0
    //   105: aload_2
    //   106: astore_1
    //   107: aload_0
    //   108: astore_2
    //   109: aload_1
    //   110: astore_0
    //   111: aload_2
    //   112: invokevirtual 246	java/lang/Exception:printStackTrace	()V
    //   115: aload_3
    //   116: astore_0
    //   117: aload_1
    //   118: ifnull -24 -> 94
    //   121: aload_1
    //   122: invokevirtual 245	java/io/FileInputStream:close	()V
    //   125: aload_3
    //   126: astore_0
    //   127: goto -33 -> 94
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   135: aload_3
    //   136: astore_0
    //   137: goto -43 -> 94
    //   140: astore_2
    //   141: aload_0
    //   142: astore_1
    //   143: aload_2
    //   144: astore_0
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 245	java/io/FileInputStream:close	()V
    //   153: aload_0
    //   154: athrow
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   160: goto -7 -> 153
    //   163: astore_0
    //   164: goto -19 -> 145
    //   167: astore_2
    //   168: goto -59 -> 109
    //   171: goto -77 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramString	String
    //   4	87	1	localFileInputStream	java.io.FileInputStream
    //   96	2	1	localIOException1	IOException
    //   106	44	1	localObject1	Object
    //   155	2	1	localIOException2	IOException
    //   6	106	2	localObject2	Object
    //   140	4	2	localObject3	Object
    //   167	1	2	localException	Exception
    //   2	134	3	str	String
    //   15	34	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   90	94	96	java/io/IOException
    //   30	40	104	java/lang/Exception
    //   121	125	130	java/io/IOException
    //   30	40	140	finally
    //   111	115	140	finally
    //   149	153	155	java/io/IOException
    //   40	86	163	finally
    //   40	86	167	java/lang/Exception
  }
  
  public static int getSDKVersionCode(Context paramContext)
  {
    return UpdateManager.getSDKVersionCode();
  }
  
  public static boolean getSafeUxssStatus()
  {
    if (!mLibraryLoaded) {
      return false;
    }
    return GetSafeStatus();
  }
  
  private static boolean initLibrary()
  {
    Object localObject = mContext.getSharedPreferences("SHARED_PREFERENCE_SECURE_WEBVIEW", 0);
    if (((SharedPreferences)localObject).getBoolean("SHARED_PREFERENCE_ERROR_REPORTED", false)) {
      return false;
    }
    copyAssetToFiles(mContext, "safe_uxss.js");
    SetJSFilePath(mContext.getFilesDir() + "/" + "safe_uxss.js");
    String str2 = ((SharedPreferences)localObject).getString("SHARED_PREFERENCE_FILE_MD5", "");
    String str1 = getMd5ByFile("/system/lib/libchromium_net.so");
    int i;
    if ((!str1.equals(str2)) || (str1.equals("")))
    {
      localObject = ((SharedPreferences)localObject).edit();
      i = 0;
      while (i < 9)
      {
        ((SharedPreferences.Editor)localObject).putInt("SHARED_PREFERENCE_VT_INDEX_" + i, -1);
        i += 1;
      }
      ((SharedPreferences.Editor)localObject).putString("SHARED_PREFERENCE_FILE_MD5", str1);
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (;;)
    {
      return true;
      i = 0;
      while (i < 9)
      {
        int j = ((SharedPreferences)localObject).getInt("SHARED_PREFERENCE_VT_INDEX_" + i, -1);
        if (j != -1) {
          SetVirtualFunction(i, j, j);
        }
        i += 1;
      }
    }
  }
  
  private static boolean loadSecureLibrary()
  {
    if (!System.getProperty("os.arch", "").toLowerCase(Locale.US).startsWith("arm")) {
      return false;
    }
    try
    {
      System.loadLibrary("webviewext");
      return true;
    }
    catch (Exception localException)
    {
      return false;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return false;
  }
  
  public static void setContext(Context paramContext)
  {
    if (mContext == null) {
      mContext = paramContext.getApplicationContext();
    }
  }
  
  public static void setSafeUxssStatus(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if ((!mExistX5WebViewExtension) && (mContext != null) && (!mLoadLibraryFail) && (Build.VERSION.SDK_INT >= 14))
        {
          int i = Build.VERSION.SDK_INT;
          if (i <= 18) {}
        }
        else
        {
          return;
        }
        if (!mLibraryLoaded)
        {
          if (!loadSecureLibrary())
          {
            mLoadLibraryFail = true;
            continue;
          }
          mLibraryLoaded = true;
        }
      }
      finally {}
      if (mLibraryInitialed) {
        break label95;
      }
      if (initLibrary()) {
        break;
      }
      mLoadLibraryFail = true;
    }
    mLibraryInitialed = true;
    label95:
    if (paramBoolean)
    {
      if (mReportThread == null)
      {
        mReportThread = new ReportThread();
        mReportThread.start();
      }
      if (mUpdateManager == null) {
        mUpdateManager = new UpdateManager(mContext, "safe_uxss.js");
      }
    }
    for (;;)
    {
      SetSafeStatus(paramBoolean, false);
      break;
      if (mReportThread != null)
      {
        mReportThread.stopThread();
        mReportThread = null;
      }
      if (mUpdateManager != null)
      {
        mUpdateManager.stopUpdate();
        mUpdateManager = null;
      }
    }
  }
  
  public static void setSecureLibraryStatus(int paramInt)
  {
    if (paramInt == 1) {
      mLibraryLoaded = true;
    }
    while (paramInt != 2) {
      return;
    }
    mLoadLibraryFail = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.secure.SecureWebView
 * JD-Core Version:    0.7.0.1
 */