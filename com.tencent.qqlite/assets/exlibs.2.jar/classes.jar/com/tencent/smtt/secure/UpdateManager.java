package com.tencent.smtt.secure;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.tencent.smtt.sdk.QbSdkLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class UpdateManager
{
  private static final int DEFAULT_SDK_VERION = 1;
  private static final String DEFAULT_UPDATE_FILE_SHA1 = "ml4VnBfuz4JqqEKwf71fCA3uO3U=";
  private static final String DEFUALT_JS_VERSION = "1";
  private static final int DOWN_OVER = 2;
  private static final int DOWN_UPDATE = 1;
  private static final int NEED_UPDATE = 0;
  private static final String SHARED_PREFERENCE_CURRENT_UPDATE_FILE_SHA1 = "SHARED_PREFERENCE_CURRENT_UPDATE_FILE_SHA1";
  private static final String SHARED_PREFERENCE_CURRENT_VERSION = "SHARED_PREFERENCE_CURRENT_VERSION";
  private static final String SHARED_PREFERENCE_LAST_UPDATE_TIME = "SHARED_PREFERENCE_LAST_UPDATE_TIME";
  private static final String SHARED_PREFERENCE_NAME = "SHARED_PREFERENCE_SECURE_WEBVIEW";
  private static final String SIGNATURE = "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4";
  private static final String UPDATE_FILE_NAME = "secure_update.apk";
  private static final String UPDATE_FILE_URL = "http://ter.sec.qq.com/secure_update.apk";
  private static final String UPDATE_INFO_URL = "http://ter.sec.qq.com/secure_update.info";
  private static final String UPDATE_JS_IN_APK = "assets/safe_uxss.js";
  private static final String UPDATE_SHA1_PREFIX = "SHA1:";
  private static final String UPDATE_VERSION_PREFIX = "VERSION:";
  private Thread downLoadThread = null;
  private Context mContext = null;
  private String mCurrentUpdateFileSHA1 = "";
  private Runnable mDownloadRunnable = new Runnable()
  {
    public void run()
    {
      try
      {
        Object localObject1 = (HttpURLConnection)new URL(UpdateManager.this.mUpdateFileUrl).openConnection();
        ((HttpURLConnection)localObject1).connect();
        localObject1 = ((HttpURLConnection)localObject1).getInputStream();
        Object localObject2 = new FileOutputStream(UpdateManager.this.mLocalUpdateFileName, false);
        byte[] arrayOfByte = new byte[1024];
        int i = ((InputStream)localObject1).read(arrayOfByte);
        if (i <= 0) {
          UpdateManager.this.mHandler.sendEmptyMessage(2);
        }
        for (;;)
        {
          ((FileOutputStream)localObject2).close();
          ((InputStream)localObject1).close();
          return;
          ((FileOutputStream)localObject2).write(arrayOfByte, 0, i);
          boolean bool = UpdateManager.this.mInterceptFlag;
          if (!bool) {
            break;
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringWriter();
        localThrowable.printStackTrace(new PrintWriter((Writer)localObject2));
        QbSdkLog.e("UpdateManager", "mDownloadRunnable - exceptions:" + ((StringWriter)localObject2).toString());
      }
    }
  };
  private Handler mHandler = null;
  private boolean mInterceptFlag = false;
  private String mLocalJSFileName = "";
  private String mLocalUpdateFileName = "";
  private String mUpdateFileSHA1 = "";
  private String mUpdateFileUrl = "";
  private String mUpdateFileVersion = "";
  private String mUpdateInfoUrl = "";
  
  public UpdateManager(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mLocalJSFileName = (this.mContext.getFilesDir() + "/" + paramString);
    paramContext = getUpdateParams();
    this.mUpdateInfoUrl = ("http://ter.sec.qq.com/secure_update.info" + paramContext);
    this.mUpdateFileUrl = ("http://ter.sec.qq.com/secure_update.apk" + paramContext);
    this.mLocalUpdateFileName = (this.mContext.getFilesDir() + "/" + "secure_update.apk");
    this.mCurrentUpdateFileSHA1 = getCurrentUpdateFileSHA1();
    this.mHandler = new UpdateHandler(this);
    checkUpdateInfo();
  }
  
  private boolean checkLastUpdateTime()
  {
    Object localObject1 = this.mContext.getSharedPreferences("SHARED_PREFERENCE_SECURE_WEBVIEW", 0).getString("SHARED_PREFERENCE_LAST_UPDATE_TIME", "");
    if (localObject1 != "")
    {
      Object localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      try
      {
        localObject1 = ((SimpleDateFormat)localObject2).parse((String)localObject1);
        localObject2 = new Date();
        if (((Date)localObject2).getTime() > ((Date)localObject1).getTime()) {}
        long l2;
        for (long l1 = ((Date)localObject2).getTime() - ((Date)localObject1).getTime(); l1 / 86400000L > 1L; l1 -= l2)
        {
          return true;
          l1 = ((Date)localObject1).getTime();
          l2 = ((Date)localObject2).getTime();
        }
        return false;
      }
      catch (ParseException localParseException)
      {
        return true;
      }
    }
    return true;
  }
  
  private void downloadFile()
  {
    this.downLoadThread = new Thread(this.mDownloadRunnable);
    this.downLoadThread.start();
  }
  
  private String getCurrentUpdateFileSHA1()
  {
    return this.mContext.getSharedPreferences("SHARED_PREFERENCE_SECURE_WEBVIEW", 0).getString("SHARED_PREFERENCE_CURRENT_UPDATE_FILE_SHA1", "ml4VnBfuz4JqqEKwf71fCA3uO3U=");
  }
  
  public static int getJSVersion(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("SHARED_PREFERENCE_SECURE_WEBVIEW", 0).getString("SHARED_PREFERENCE_CURRENT_VERSION", "1");
    try
    {
      i = Integer.parseInt(paramContext);
      int j;
      if (i > 0)
      {
        j = i;
        if (i <= 19860429) {}
      }
      else
      {
        j = 1;
      }
      return j;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        int i = 1;
      }
    }
  }
  
  public static int getSDKVersionCode()
  {
    return 1;
  }
  
  private String getUpdateParams()
  {
    localObject4 = this.mContext;
    String str1 = ((Context)localObject4).getPackageName();
    int i = Build.VERSION.SDK_INT;
    String str2 = Build.MODEL + "_" + Build.BRAND;
    Object localObject1 = "unknown";
    Object localObject2 = "unknown";
    int j = getSDKVersionCode();
    int k = getJSVersion((Context)localObject4);
    try
    {
      localObject3 = ((TelephonyManager)((Context)localObject4).getSystemService("phone")).getDeviceId();
      localObject1 = localObject3;
    }
    catch (Exception localException3)
    {
      Object localObject3;
      label84:
      break label84;
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "unknown";
    }
    try
    {
      localObject1 = ((Context)localObject4).getPackageManager().getPackageInfo(((Context)localObject4).getPackageName(), 0).versionName;
      localObject4 = localObject2;
      if (localObject1 != null)
      {
        int m = ((String)localObject1).length();
        localObject4 = localObject2;
        if (m > 0) {
          localObject4 = localObject1;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localObject4 = localUnsupportedEncodingException;
      }
    }
    localObject2 = "";
    localObject1 = localObject2;
    try
    {
      str1 = "" + "?pkg=" + URLEncoder.encode(str1, "UTF-8");
      localObject1 = str1;
      localObject2 = str1;
      str1 = str1 + "&sysv=" + URLEncoder.encode(String.valueOf(i), "UTF-8");
      localObject1 = str1;
      localObject2 = str1;
      str1 = str1 + "&brand=" + URLEncoder.encode(str2, "UTF-8");
      localObject1 = str1;
      localObject2 = str1;
      localObject3 = str1 + "&did=" + URLEncoder.encode((String)localObject3, "UTF-8");
      localObject1 = localObject3;
      localObject2 = localObject3;
      localObject3 = (String)localObject3 + "&pkgv=" + URLEncoder.encode((String)localObject4, "UTF-8");
      localObject1 = localObject3;
      localObject2 = localObject3;
      localObject3 = (String)localObject3 + "&sdkv=" + URLEncoder.encode(String.valueOf(j), "UTF-8");
      localObject1 = localObject3;
      localObject2 = localObject3;
      localObject3 = (String)localObject3 + "&jsv=" + URLEncoder.encode(String.valueOf(k), "UTF-8");
      return localObject3;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      return localObject1;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      return localUnsupportedEncodingException;
    }
  }
  
  private void installFile()
  {
    if (!new File(this.mLocalUpdateFileName).exists()) {}
    for (;;)
    {
      return;
      if (!this.mUpdateFileSHA1.equals(getSHA1String(this.mLocalUpdateFileName))) {
        continue;
      }
      try
      {
        bool = extractFile(this.mLocalUpdateFileName, "assets/safe_uxss.js", this.mLocalJSFileName);
        if (!bool) {
          continue;
        }
        updateLastUpdateTime(this.mUpdateFileVersion);
        updateCurrentUpdateFileSHA1(this.mUpdateFileSHA1);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          boolean bool = false;
        }
      }
    }
  }
  
  private Certificate[] loadCertificates(JarFile paramJarFile, JarEntry paramJarEntry)
  {
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = new byte[8192];
      paramJarFile = new BufferedInputStream(paramJarFile.getInputStream(paramJarEntry));
      while (paramJarFile.read(arrayOfByte, 0, arrayOfByte.length) != -1) {}
      paramJarFile.close();
      paramJarFile = localObject;
      if (paramJarEntry != null) {
        paramJarFile = paramJarEntry.getCertificates();
      }
      return paramJarFile;
    }
    catch (RuntimeException paramJarFile)
    {
      return null;
    }
    catch (IOException paramJarFile) {}
    return null;
  }
  
  private boolean readJarFile(JarFile paramJarFile, JarEntry paramJarEntry, String paramString)
  {
    try
    {
      byte[] arrayOfByte = new byte[8192];
      paramJarFile = new BufferedInputStream(paramJarFile.getInputStream(paramJarEntry));
      paramJarEntry = new FileOutputStream(paramString, false);
      for (;;)
      {
        int i = paramJarFile.read(arrayOfByte, 0, arrayOfByte.length);
        if (i == -1) {
          break;
        }
        paramJarEntry.write(arrayOfByte, 0, i);
      }
      paramJarFile.close();
      paramJarEntry.close();
      return true;
    }
    catch (RuntimeException paramJarFile)
    {
      return false;
    }
    catch (IOException paramJarFile) {}
    return false;
  }
  
  private void updateCurrentUpdateFileSHA1(String paramString)
  {
    SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences("SHARED_PREFERENCE_SECURE_WEBVIEW", 0).edit();
    localEditor.putString("SHARED_PREFERENCE_CURRENT_UPDATE_FILE_SHA1", paramString);
    localEditor.commit();
  }
  
  private void updateLastUpdateTime(String paramString)
  {
    SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences("SHARED_PREFERENCE_SECURE_WEBVIEW", 0).edit();
    localEditor.putString("SHARED_PREFERENCE_LAST_UPDATE_TIME", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    if (paramString != null) {
      localEditor.putString("SHARED_PREFERENCE_CURRENT_VERSION", paramString);
    }
    localEditor.commit();
  }
  
  public void checkUpdateInfo()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          int i;
          try
          {
            if (!UpdateManager.this.checkLastUpdateTime()) {
              return;
            }
            ArrayList localArrayList = new UrlDownload(UpdateManager.this.mUpdateInfoUrl).getListString();
            if (localArrayList == null) {
              break label236;
            }
            i = 0;
            if (i < localArrayList.size())
            {
              localObject = (String)localArrayList.get(i);
              if (((String)localObject).startsWith("SHA1:")) {
                UpdateManager.access$402(UpdateManager.this, ((String)localObject).substring("SHA1:".length()).trim());
              } else if (((String)localObject).startsWith("VERSION:")) {
                UpdateManager.access$502(UpdateManager.this, ((String)localObject).substring("VERSION:".length()).trim());
              }
            }
          }
          catch (Throwable localThrowable)
          {
            Object localObject = new StringWriter();
            localThrowable.printStackTrace(new PrintWriter((Writer)localObject));
            QbSdkLog.e("UpdateManager", "checkUpdateInfo - exceptions:" + ((StringWriter)localObject).toString());
            return;
          }
          if ((!UpdateManager.this.mUpdateFileSHA1.equals("")) && (!UpdateManager.this.mUpdateFileVersion.equals("")))
          {
            if (!UpdateManager.this.mUpdateFileSHA1.equals(UpdateManager.this.mCurrentUpdateFileSHA1))
            {
              UpdateManager.this.mHandler.sendEmptyMessage(0);
              return;
            }
            UpdateManager.this.updateLastUpdateTime(null);
          }
          label236:
          return;
          i += 1;
        }
      }
    }).start();
  }
  
  public boolean copyFile(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new FileOutputStream(paramString1, false);
      paramString2 = new FileInputStream(paramString2);
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramString2.read(arrayOfByte);
        if (i <= 0)
        {
          paramString1.close();
          paramString2.close();
          return true;
        }
        paramString1.write(arrayOfByte, 0, i);
      }
      return false;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public boolean extractFile(String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    paramString1 = new JarFile(paramString1);
    Enumeration localEnumeration = paramString1.entries();
    while (localEnumeration.hasMoreElements())
    {
      JarEntry localJarEntry = (JarEntry)localEnumeration.nextElement();
      if ((!localJarEntry.isDirectory()) && (localJarEntry.getName().equals(paramString2)))
      {
        Certificate[] arrayOfCertificate = loadCertificates(paramString1, localJarEntry);
        if ((arrayOfCertificate != null) && (arrayOfCertificate.length == 1))
        {
          if (new Signature(arrayOfCertificate[0].getEncoded()).equals(new Signature("30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4")))
          {
            if (readJarFile(paramString1, localJarEntry, paramString3)) {
              return true;
            }
            paramString1 = new File(paramString3);
            if (paramString1.exists()) {
              paramString1.delete();
            }
            return false;
          }
          return false;
        }
      }
    }
    return false;
  }
  
  public String getSHA1String(String paramString)
  {
    BufferedInputStream localBufferedInputStream;
    MessageDigest localMessageDigest;
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        if (paramString.length() > 0)
        {
          paramString = new FileInputStream(paramString);
          localBufferedInputStream = new BufferedInputStream(paramString);
          localMessageDigest = MessageDigest.getInstance("SHA1");
          localMessageDigest.reset();
          byte[] arrayOfByte = new byte[1024];
          for (;;)
          {
            int i = localBufferedInputStream.read(arrayOfByte);
            if (i <= 0) {
              break;
            }
            localMessageDigest.update(arrayOfByte, 0, i);
          }
        }
        return "";
      }
      catch (Throwable paramString) {}
    }
    localBufferedInputStream.close();
    paramString.close();
    paramString = Base64.encodeToString(localMessageDigest.digest(), 0).trim();
    return paramString;
  }
  
  public void stopUpdate()
  {
    this.mInterceptFlag = true;
  }
  
  static class UpdateHandler
    extends Handler
  {
    private WeakReference<UpdateManager> mUpdateManager;
    
    public UpdateHandler(UpdateManager paramUpdateManager)
    {
      this.mUpdateManager = new WeakReference(paramUpdateManager);
    }
    
    public void handleMessage(Message paramMessage)
    {
      UpdateManager localUpdateManager = (UpdateManager)this.mUpdateManager.get();
      if (localUpdateManager != null) {}
      switch (paramMessage.what)
      {
      case 1: 
      default: 
        return;
      case 0: 
        localUpdateManager.downloadFile();
        return;
      }
      localUpdateManager.installFile();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.secure.UpdateManager
 * JD-Core Version:    0.7.0.1
 */