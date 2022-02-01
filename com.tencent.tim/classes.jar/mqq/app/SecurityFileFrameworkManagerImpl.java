package mqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.SecureFileFrameworkManager;

public class SecurityFileFrameworkManagerImpl
  implements SecureFileFrameworkManager
{
  private static final long ERROR_CODE_ENCRYPT_FILE_EXIST_WHEN_FIRST_INTO = 6L;
  private static final long ERROR_CODE_FETCH_THIRD_PROCESS_ERROR = 7L;
  private static final long ERROR_CODE_FRAMEWORK_ENABLE_FAIL = 0L;
  private static final long ERROR_CODE_GET_ROOT_FILTER_NULL = 9L;
  private static final long ERROR_CODE_GET_UIN_FILTER_NULL = 10L;
  private static final long ERROR_CODE_RENAME_BUT_UIN_FILE_REMOVED = 4L;
  private static final long ERROR_CODE_RENAME_FAIL = 2L;
  private static final long ERROR_CODE_RENAME_FAIL_TOOL_PROCESS_EXIST = 3L;
  private static final long ERROR_CODE_RENAME_SUCCESS = 1L;
  private static final long ERROR_CODE_RENAME_SUCCESS_BUT_FILE_SUM_NO_MATCH = 11L;
  private static final long ERROR_CODE_RETURN_NULL = 8L;
  private static final long ERROR_CODE_TOKEN_DO_NOT_MATCH = 5L;
  public static final String FILE_KEY_PREFIX = "NoRename#";
  private static final long REQUEST_CODE_SECURITY_FILE_FRAMEWORK = 0L;
  private static String SDCARD_PATH = SDCARD_ROOT + "/Tencent/Tim/";
  private static String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
  private static final String SP_KEY_FILE_KEY = "FILE_KEY";
  private static final String SP_KEY_UIN_IS_FIRST = "UIN_IS_FIRST_";
  public static final String TAG = "SecurityFileFrameworkManagerImpl";
  private static boolean enable;
  private static File sRootFile;
  private ConcurrentHashMap<String, File> businessRootFiles = new ConcurrentHashMap();
  private AppRuntime mApp;
  private File mUINRootFile;
  
  SecurityFileFrameworkManagerImpl(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    getRootFile();
  }
  
  private static String generalFileKey()
  {
    Object localObject = new SecureRandom();
    byte[] arrayOfByte = new byte[6];
    ((SecureRandom)localObject).nextBytes(arrayOfByte);
    localObject = Base64.encodeToString(arrayOfByte, 11);
    return generateVerifyChar((String)localObject) + (String)localObject;
  }
  
  private String generateEncryptUIN(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecurityFileFrameworkManagerImpl", 2, new Object[] { "generateEncryptUIN( deviceToken=", paramString2, "fileKey= ", paramString3, " )" });
    }
    return MD5.toMD5(paramString2 + paramString1 + paramString3);
  }
  
  private File generateOrGetUINFile()
  {
    Object localObject1 = MsfServiceSdk.get().getDeviceToken(this.mApp.getAccount());
    Object localObject4 = this.mApp.getApplication().getSharedPreferences("SecurityFileFrameworkManagerImpl", 4);
    Object localObject3 = ((SharedPreferences)localObject4).getString(this.mApp.getAccount(), null);
    if (QLog.isColorLevel()) {
      QLog.d("SecurityFileFrameworkManagerImpl", 2, new Object[] { "Current UIN=", this.mApp.getAccount(), "msfDeviceToken=", localObject1, " spDeviceToken=", localObject3 });
    }
    boolean bool1 = ((SharedPreferences)localObject4).getBoolean("UIN_IS_FIRST_" + this.mApp.getAccount(), true);
    String str;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = this.mApp.getAccount();
        localObject3 = this.mApp.getAccount();
        localObject3 = sRootFile.listFiles(new SecurityFileFrameworkManagerImpl.2(this, (String)localObject3));
        str = generateEncryptUIN(this.mApp.getAccount(), (String)localObject1, sRootFile.getName().replace("NoRename#", ""));
        if (localObject3 != null) {
          break label1303;
        }
        QLog.d("SecurityFileFrameworkManagerImpl", 1, "sRootFile.listFiles = null");
        reportToRDM(0L, 10L, null);
      }
    }
    label253:
    Object localObject2;
    label1289:
    label1300:
    label1303:
    for (localObject1 = new File[0];; localObject2 = localObject3)
    {
      int j = localObject1.length;
      int i = 0;
      boolean bool3 = false;
      boolean bool2 = false;
      if (i < j)
      {
        localObject3 = localObject1[i];
        if (!((File)localObject3).getName().equals(this.mApp.getAccount())) {
          break label1300;
        }
        bool2 = true;
      }
      for (;;)
      {
        if (((File)localObject3).getName().equals(str)) {
          bool3 = true;
        }
        i += 1;
        break label253;
        bool1 = false;
        localObject1 = localObject3;
        break;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          bool1 = true;
          ((SharedPreferences)localObject4).edit().putString(this.mApp.getAccount(), (String)localObject1).commit();
          break;
        }
        bool1 = false;
        if (!((String)localObject1).equals(localObject3))
        {
          QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "Token Don't Match: msfDeviceToken=", localObject1, " spDeviceToken=", localObject3 });
          ((SharedPreferences)localObject4).edit().putString(this.mApp.getAccount(), (String)localObject1).commit();
          reportToRDM(0L, 5L, null);
        }
        break;
        if (QLog.isColorLevel()) {
          QLog.d("SecurityFileFrameworkManagerImpl", 2, new Object[] { "hasEncryptUinDir=", Boolean.valueOf(bool3), " encryptUIN=", str });
        }
        if (bool3)
        {
          if (bool1)
          {
            ((SharedPreferences)localObject4).edit().putBoolean("UIN_IS_FIRST_" + this.mApp.getAccount(), false).commit();
            reportToRDM(0L, 6L, null);
          }
          return new File(sRootFile + File.separator + str);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SecurityFileFrameworkManagerImpl", 2, new Object[] { "isFirst=", Boolean.valueOf(bool1), " hasUINDir=", Boolean.valueOf(bool2) });
        }
        if (bool1)
        {
          localObject1 = new File(sRootFile.getAbsolutePath() + File.separator + this.mApp.getAccount());
          if (!((File)localObject1).exists()) {
            ((File)localObject1).mkdirs();
          }
          ((SharedPreferences)localObject4).edit().putBoolean("UIN_IS_FIRST_" + this.mApp.getAccount(), false).commit();
          return localObject1;
        }
        for (;;)
        {
          try
          {
            localObject1 = (ActivityManager)this.mApp.getApplication().getSystemService("activity");
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
            i = 0;
            if (i >= ((List)localObject1).size()) {
              continue;
            }
            bool1 = "com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).processName);
            if (!bool1) {
              continue;
            }
            i = 1;
          }
          catch (Exception localException)
          {
            long l1;
            long l2;
            QLog.d("SecurityFileFrameworkManagerImpl", 1, localException.toString());
            reportToRDM(0L, 7L, null);
            i = 0;
            continue;
            reportToRDM(0L, 11L, localException);
            continue;
            localObject3 = new HashMap();
            ((HashMap)localObject3).put("tempFilePath", localException.getAbsolutePath());
            reportToRDM(0L, 2L, (HashMap)localObject3);
            QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "hasUINDir & rename fail return=", localException.getAbsolutePath() });
            return localException;
          }
          if (!bool2) {
            break label1208;
          }
          localObject1 = new File(sRootFile.getAbsolutePath() + File.separator + this.mApp.getAccount());
          localObject3 = new File(sRootFile.getAbsolutePath() + File.separator + str);
          if (!((File)localObject1).exists()) {
            break label1289;
          }
          if (i != 0) {
            break label1148;
          }
          localObject4 = ((File)localObject1).list();
          l1 = -1L;
          if (localObject4 != null) {
            l1 = localObject4.length;
          }
          if (!((File)localObject1).renameTo((File)localObject3)) {
            continue;
          }
          localObject1 = ((File)localObject3).list();
          l2 = -1L;
          if (localObject1 != null) {
            l2 = localObject1.length;
          }
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("fileSumBeforeRename", "" + l1);
          ((HashMap)localObject1).put("fileSumAfterRename", "" + l2);
          if (l1 != l2) {
            continue;
          }
          reportToRDM(0L, 1L, (HashMap)localObject1);
          return localObject3;
          i += 1;
        }
        label1148:
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("tempFilePath", localException.getAbsolutePath());
        reportToRDM(0L, 3L, (HashMap)localObject3);
        QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "containThirdProcess return=", localException.getAbsolutePath() });
        return localException;
        label1208:
        localObject2 = new File(sRootFile.getAbsolutePath() + File.separator + str);
        ((File)localObject2).mkdirs();
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("toFile", ((File)localObject2).getAbsolutePath());
        reportToRDM(0L, 4L, (HashMap)localObject3);
        return localObject2;
        reportToRDM(0L, 8L, null);
        return null;
      }
    }
  }
  
  public static char generateVerifyChar(String paramString)
  {
    int i = 0;
    paramString = paramString.toCharArray();
    int k = paramString.length;
    int j = 0;
    while (i < k)
    {
      int m = paramString[i];
      j += m * m;
      i += 1;
    }
    return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(j % 60);
  }
  
  private File getBusinessRootFile(ISecurityFileHelper paramISecurityFileHelper)
  {
    if (this.businessRootFiles.containsKey(this.mApp.getAccount() + paramISecurityFileHelper.declareBusinessFileName())) {
      return (File)this.businessRootFiles.get(this.mApp.getAccount() + paramISecurityFileHelper.declareBusinessFileName());
    }
    if (paramISecurityFileHelper.oldBusinessDirExist(this.mApp.getAccount()))
    {
      this.businessRootFiles.put(this.mApp.getAccount() + paramISecurityFileHelper.declareBusinessFileName(), paramISecurityFileHelper.oldBusinessDir(this.mApp.getAccount()));
      return paramISecurityFileHelper.oldBusinessDir(this.mApp.getAccount());
    }
    File localFile = new File(this.mUINRootFile.getAbsolutePath() + File.separator + paramISecurityFileHelper.declareBusinessFileName());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    this.businessRootFiles.put(this.mApp.getAccount() + paramISecurityFileHelper.declareBusinessFileName(), localFile);
    return localFile;
  }
  
  public static File getRootFile()
  {
    try
    {
      if (sRootFile == null)
      {
        enable = initSecureFileFramework(MobileQQ.context);
        if ((!enable) || (sRootFile == null)) {
          sRootFile = new File(SDCARD_PATH);
        }
      }
      File localFile = sRootFile;
      return localFile;
    }
    finally {}
  }
  
  private static boolean initSecureFileFramework(Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.d("SecurityFileFrameworkManagerImpl", 1, "context is null");
      return false;
    }
    Object localObject = paramContext.getExternalCacheDir();
    File localFile;
    if (localObject != null)
    {
      SDCARD_ROOT = ((File)localObject).getParentFile().getAbsolutePath();
      SDCARD_PATH = SDCARD_ROOT + "/Tencent/Tim/";
      localFile = new File(SDCARD_PATH);
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "rootFile create fail, target root path=", localFile.getAbsoluteFile() });
        return false;
      }
    }
    else
    {
      QLog.d("SecurityFileFrameworkManagerImpl", 1, "externalCacheDir is null");
      return false;
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("SecurityFileFrameworkManagerImpl", 4);
    paramContext = localSharedPreferences.getString("FILE_KEY", "");
    int i;
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = localFile.listFiles(new SecurityFileFrameworkManagerImpl.1());
      localObject = paramContext;
      if (paramContext == null)
      {
        localObject = new File[0];
        QLog.d("SecurityFileFrameworkManagerImpl", 1, "rootFile.listFiles = null");
      }
      if (localObject.length > 1)
      {
        long l = 9223372036854775807L;
        paramContext = null;
        int j = localObject.length;
        i = 0;
        if (i < j)
        {
          localFile = localObject[i];
          if (localFile.lastModified() >= l) {
            break label721;
          }
          l = localFile.lastModified();
          paramContext = localFile;
        }
      }
    }
    label721:
    for (;;)
    {
      i += 1;
      break;
      QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "initSecureFileFramework: fileKeyFiles.length=", Integer.valueOf(localObject.length) });
      localObject = paramContext.getName().replaceAll("NoRename#", "");
      localSharedPreferences.edit().putString("FILE_KEY", (String)localObject).commit();
      sRootFile = paramContext;
      return true;
      if (localObject.length == 0)
      {
        paramContext = generalFileKey();
        localObject = new File(localFile.getAbsolutePath() + File.separator + "NoRename#" + paramContext);
        if (((File)localObject).mkdirs())
        {
          localSharedPreferences.edit().putString("FILE_KEY", paramContext).commit();
          sRootFile = (File)localObject;
          return true;
        }
        QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "dir create fail, path=", ((File)localObject).getAbsoluteFile() });
        return false;
      }
      paramContext = localObject[0].getName().replaceAll("NoRename#", "");
      localSharedPreferences.edit().putString("FILE_KEY", paramContext).commit();
      sRootFile = localObject[0];
      return true;
      localObject = new File(localFile.getAbsolutePath() + File.separator + "NoRename#" + paramContext);
      if (((File)localObject).exists())
      {
        if (!((File)localObject).isDirectory())
        {
          if (((File)localObject).renameTo(new File(localFile.getAbsolutePath() + File.separator + "NoRename#" + paramContext + "_bak")))
          {
            QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "dir been occupied，rename file：", ((File)localObject).getAbsoluteFile() });
            if (((File)localObject).mkdirs())
            {
              sRootFile = (File)localObject;
              return true;
            }
            QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "dir been occupied，create dir fail, path=", ((File)localObject).getAbsoluteFile() });
            return false;
          }
          QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "dir been occupied，rename file fail, can't create new file, path=", ((File)localObject).getAbsoluteFile() });
          return false;
        }
        sRootFile = (File)localObject;
        return true;
      }
      if (((File)localObject).mkdirs())
      {
        sRootFile = (File)localObject;
        return true;
      }
      QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "FileKey exist, File no exist, dir create fail, path=", ((File)localObject).getAbsoluteFile() });
      return false;
    }
  }
  
  private void reportToRDM(long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    for (;;)
    {
      try
      {
        Object localObject;
        StringBuilder localStringBuilder;
        if (this.mApp.getAccount() == null)
        {
          localObject = "NoLogin";
          localStringBuilder = new StringBuilder();
          if (paramHashMap == null)
          {
            paramHashMap = new HashMap();
            paramHashMap.put("uin", localObject);
            paramHashMap.put("isLogin", String.valueOf(this.mApp.isLogin()));
            paramHashMap.put("isRunning", String.valueOf(this.mApp.isRunning()));
            paramHashMap.put("fromCode", paramLong1 + "");
            paramHashMap.put("errorCode", paramLong2 + "");
            QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "reportToRDM{ fromCode=", Long.valueOf(paramLong1), " errorCode=", Long.valueOf(paramLong2), " additionParams=", localStringBuilder.toString(), "}" });
            localObject = new RdmReq();
            ((RdmReq)localObject).eventName = "SecureFile";
            ((RdmReq)localObject).elapse = 0L;
            ((RdmReq)localObject).size = 0L;
            ((RdmReq)localObject).isSucceed = true;
            ((RdmReq)localObject).isRealTime = false;
            ((RdmReq)localObject).params = paramHashMap;
            paramHashMap = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), (RdmReq)localObject);
            paramHashMap.setNeedCallback(false);
            MsfServiceSdk.get().sendMsg(paramHashMap);
          }
        }
        else
        {
          localObject = this.mApp.getAccount();
          continue;
        }
        HashMap localHashMap = new HashMap(paramHashMap);
        Iterator localIterator = paramHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localStringBuilder.append(str).append("#").append((String)paramHashMap.get(str)).append("|");
        }
        else
        {
          paramHashMap = localHashMap;
        }
      }
      catch (Throwable paramHashMap)
      {
        return;
      }
    }
  }
  
  public String getEncryptUIN()
  {
    return this.mUINRootFile.getName();
  }
  
  @Nullable
  public File getUINRootFile(@Nullable ISecurityFileHelper paramISecurityFileHelper)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecurityFileFrameworkManagerImpl", 2, "call getUINRootFile");
      }
      if (this.mApp.getAccount() != null) {
        break label65;
      }
      QLog.d("SecurityFileFrameworkManagerImpl", 1, "getAccount==null");
      if (MainService.isDebugVersion) {
        throw new RuntimeException("mApp.getAccount() == null, you need call it later");
      }
    }
    finally {}
    return null;
    label65:
    if (!"com.tencent.tim".equals(this.mApp.getApplication().getQQProcessName()))
    {
      QLog.d("SecurityFileFrameworkManagerImpl", 1, "only call in main process");
      if (MainService.isDebugVersion) {
        throw new RuntimeException("method 'getUINRootFile' can only call in main process");
      }
      return null;
    }
    if (this.mUINRootFile != null)
    {
      if (paramISecurityFileHelper == null)
      {
        paramISecurityFileHelper = this.mUINRootFile;
        return paramISecurityFileHelper;
      }
      paramISecurityFileHelper = getBusinessRootFile(paramISecurityFileHelper);
      return paramISecurityFileHelper;
    }
    if (!enable)
    {
      QLog.d("SecurityFileFrameworkManagerImpl", 1, "getUINRootFile Enable = false");
      reportToRDM(0L, 0L, null);
      this.mUINRootFile = new File(sRootFile.getAbsolutePath() + File.separator + this.mApp.getAccount());
      if (!this.mUINRootFile.mkdirs()) {
        QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "getUINRootFile Enable = false, mkdirs = false, mUINRootFile=", this.mUINRootFile.getAbsolutePath() });
      }
    }
    for (this.mUINRootFile = sRootFile; paramISecurityFileHelper == null; this.mUINRootFile = generateOrGetUINFile())
    {
      paramISecurityFileHelper = this.mUINRootFile;
      return paramISecurityFileHelper;
    }
    paramISecurityFileHelper = getBusinessRootFile(paramISecurityFileHelper);
    return paramISecurityFileHelper;
  }
  
  public void onDestroy()
  {
    if (this.mApp != null) {
      this.mApp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.SecurityFileFrameworkManagerImpl
 * JD-Core Version:    0.7.0.1
 */