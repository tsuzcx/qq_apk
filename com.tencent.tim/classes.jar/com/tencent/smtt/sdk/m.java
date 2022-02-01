package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class m
{
  private static int e = 5;
  private static int f = 1;
  private static final String[] g = { "tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone" };
  private boolean A;
  private Handler B;
  private Set<String> C;
  private int D = e;
  private boolean E;
  String a;
  String[] b = null;
  int c = 0;
  private boolean d = false;
  private Context h;
  private String i;
  private String j;
  private String k;
  private File l;
  private File m;
  private long n;
  private int o = 30000;
  private int p = 20000;
  private boolean q;
  private int r;
  private int s;
  private boolean t;
  private boolean u;
  private HttpURLConnection v;
  private String w;
  private TbsLogReport.TbsLogInfo x;
  private String y;
  private int z;
  
  public m(Context paramContext)
    throws NullPointerException
  {
    this.h = paramContext.getApplicationContext();
    this.x = TbsLogReport.getInstance(this.h).tbsLogInfo();
    this.C = new HashSet();
    this.w = ("tbs_downloading_" + this.h.getPackageName());
    q.a();
    this.l = q.t(this.h);
    if (this.l == null) {
      throw new NullPointerException("TbsCorePrivateDir is null!");
    }
    for (;;)
    {
      try
      {
        localContext = TbsShareManager.getPackageContext(paramContext, "com.tencent.mm", false);
        if (localContext != null) {
          continue;
        }
        this.m = new File(FileUtil.a(paramContext, "com.tencent.mm", 4, true));
      }
      catch (Throwable paramContext)
      {
        Context localContext;
        continue;
      }
      g();
      this.y = null;
      this.z = -1;
      return;
      this.m = new File(FileUtil.a(localContext, 4));
    }
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    long l1 = System.currentTimeMillis();
    this.x.setDownConsumeTime(l1 - paramLong1);
    this.x.setDownloadSize(paramLong2);
    return l1;
  }
  
  private static File a(Context paramContext, int paramInt)
  {
    File localFile = new File(FileUtil.a(paramContext, paramInt));
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {
      return null;
    }
    if (TbsDownloader.getOverSea(paramContext)) {}
    for (paramContext = "x5.oversea.tbs.org";; paramContext = TbsDownloader.getBackupFileName(false))
    {
      paramContext = new File(localFile, paramContext);
      if ((paramContext == null) || (!paramContext.exists())) {
        break;
      }
      return localFile;
    }
    return null;
  }
  
  private String a(Throwable paramThrowable)
  {
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    return paramThrowable;
  }
  
  private String a(URL paramURL)
  {
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      return paramURL;
    }
    catch (Exception paramURL)
    {
      paramURL.printStackTrace();
      return "";
    }
    catch (Error paramURL)
    {
      paramURL.printStackTrace();
    }
    return "";
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.r > this.D))
    {
      this.x.setErrorCode(paramInt);
      this.x.setFailDetail(paramString);
    }
  }
  
  private void a(long paramLong)
  {
    this.r += 1;
    long l1 = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l1 = n();
      Thread.sleep(l1);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      TbsLog.i("TbsDownload", "clearDecoupleDirOld #00");
      File localFile = paramContext.getDir("tbs_64", 0);
      localFile = q.a().a(paramContext, localFile);
      FileUtil.b(localFile);
      if (localFile != null) {
        TbsLog.i("TbsDownload", "clearDecoupleDirOld dir is " + localFile.getAbsolutePath());
      }
      localFile = paramContext.getDir("tbs", 0);
      paramContext = q.a().a(paramContext, localFile);
      FileUtil.b(paramContext);
      if (paramContext != null) {
        TbsLog.i("TbsDownload", "clearDecoupleDirOld dir is " + paramContext.getAbsolutePath());
      }
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("TbsDownload", "clearDecoupleDirOld stack is " + Log.getStackTraceString(paramContext));
    }
  }
  
  private void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void a(File paramFile, Context paramContext)
  {
    i1 = 0;
    if (paramFile != null) {}
    try
    {
      if (!paramFile.exists()) {
        return;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        return;
      }
    }
    finally {}
    for (;;)
    {
      try
      {
        localFile = c(paramContext);
        if (localFile == null) {
          continue;
        }
        if (!TbsDownloader.getOverSea(paramContext)) {
          continue;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject1 = new File(localFile, (String)localObject1);
        ((File)localObject1).delete();
        FileUtil.b(paramFile, (File)localObject1);
        boolean bool1 = ((File)localObject1).getName().contains("tbs.org");
        bool2 = ((File)localObject1).getName().contains("x5.tbs.decouple");
        if ((!bool2) && (!bool1)) {
          continue;
        }
        paramFile = localFile.listFiles();
        localObject1 = Pattern.compile(a.a(bool2) + "(.*)");
        i2 = paramFile.length;
      }
      catch (Exception paramFile)
      {
        File localFile;
        Object localObject1;
        boolean bool2;
        int i2;
        Object localObject2;
        continue;
        i1 += 1;
        continue;
      }
      if (i1 >= i2) {
        continue;
      }
      localObject2 = paramFile[i1];
      if ((!((Pattern)localObject1).matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
        continue;
      }
      localObject2.delete();
      continue;
      localObject1 = TbsDownloader.getBackupFileName(false);
    }
    i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
    paramFile = new File(localFile, a.a(bool2) + "." + i1);
    if ((paramFile != null) && (paramFile.exists()))
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
      return;
    }
    paramFile.createNewFile();
  }
  
  private void a(String paramString)
    throws Exception
  {
    paramString = new URL(paramString);
    if (this.v != null) {}
    try
    {
      this.v.disconnect();
      this.v = ((HttpURLConnection)paramString.openConnection());
      this.v.setRequestProperty("User-Agent", TbsDownloader.b(this.h));
      this.v.setRequestProperty("Accept-Encoding", "identity");
      this.v.setRequestMethod("GET");
      this.v.setInstanceFollowRedirects(false);
      this.v.setConnectTimeout(this.p);
      this.v.setReadTimeout(this.o);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.e("TbsDownload", "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
      }
    }
  }
  
  private boolean a(File paramFile)
  {
    int i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("use_backup_version", 0);
    int i1 = i2;
    if (i2 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
    }
    return a.a(this.h, paramFile, 0L, i1);
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, File paramFile)
  {
    long l1 = 0L;
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1);
    if (paramFile != null) {
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk]  verifyFile is " + paramFile.getAbsolutePath());
    }
    Object localObject2 = this.l;
    Object localObject1;
    if (!paramBoolean1)
    {
      localObject1 = "x5.tbs";
      localObject1 = new File((File)localObject2, (String)localObject1);
      if (paramFile == null) {
        break label827;
      }
      localObject1 = paramFile;
    }
    label396:
    label568:
    label827:
    for (;;)
    {
      if (!((File)localObject1).exists()) {}
      String str;
      label206:
      do
      {
        int i2;
        int i1;
        int i3;
        do
        {
          do
          {
            return false;
            localObject1 = "x5.tbs.temp";
            break;
            localObject2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getString("tbs_apk_md5", null);
            str = a.a((File)localObject1);
            if ((localObject2 != null) && (((String)localObject2).equals(str))) {
              break label206;
            }
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " md5 failed");
          } while (!paramBoolean1);
          this.x.setCheckErrorDetail("fileMd5 not match");
          return false;
          TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + str + ") successful!");
          long l2 = l1;
          if (paramBoolean1)
          {
            long l3 = TbsDownloadConfig.getInstance(this.h).mPreferences.getLong("tbs_apkfilesize", 0L);
            l2 = l1;
            if (localObject1 != null)
            {
              l2 = l1;
              if (((File)localObject1).exists())
              {
                l2 = l1;
                if (l3 <= 0L) {
                  break label396;
                }
                l1 = ((File)localObject1).length();
                l2 = l1;
                if (l3 == l1) {
                  break label396;
                }
                l2 = l1;
              }
            }
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " filelength failed");
            this.x.setCheckErrorDetail("fileLength:" + l2 + ",contentLength:" + l3);
            return false;
          }
          TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + l2 + ") successful!");
          i2 = -1;
          i1 = i2;
          if (!paramBoolean2) {
            break label568;
          }
          i1 = i2;
          if (paramBoolean1) {
            break label568;
          }
          i2 = a.a(this.h, (File)localObject1);
          i3 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
          i1 = i2;
          if (i3 == i2) {
            break label568;
          }
          TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " versionCode failed");
        } while (!paramBoolean1);
        this.x.setCheckErrorDetail("fileVersion:" + i2 + ",configVersion:" + i3);
        return false;
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i1 + ") successful!");
        if ((!paramBoolean2) || (paramBoolean1)) {
          break label726;
        }
        str = b.a(this.h, false, (File)localObject1);
        if ("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(str)) {
          break label726;
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " signature failed");
      } while (!paramBoolean1);
      localObject1 = this.x;
      localObject2 = new StringBuilder().append("signature:");
      if (str == null) {}
      for (paramFile = "null";; paramFile = Integer.valueOf(str.length()))
      {
        ((TbsLogReport.TbsLogInfo)localObject1).setCheckErrorDetail(paramFile);
        return false;
      }
      label726:
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
      if ((paramBoolean1) && (paramFile == null))
      {
        try
        {
          paramBoolean1 = ((File)localObject1).renameTo(new File(this.l, "x5.tbs"));
          paramFile = null;
        }
        catch (Exception paramFile)
        {
          for (;;)
          {
            paramBoolean1 = false;
          }
        }
        paramBoolean2 = paramBoolean1;
        if (paramBoolean1) {
          break label793;
        }
        a(109, a(paramFile), true);
        return false;
      }
      paramBoolean2 = false;
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + paramBoolean2 + ") successful!");
      return true;
    }
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      if (TbsShareManager.isThirdPartyApp(paramContext)) {}
      boolean bool;
      do
      {
        TbsLog.i("TbsDownload", "clearOldBackup #00");
        paramContext = new File(FileUtil.a(paramContext, 3));
        FileUtil.b(paramContext);
        if (paramContext == null) {
          break;
        }
        TbsLog.i("TbsDownload", "clearOldBackup dir is " + paramContext.getAbsolutePath());
        return;
        bool = com.tencent.smtt.utils.q.g(paramContext);
      } while (bool);
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("TbsDownload", "clearOldBackup stack is " + Log.getStackTraceString(paramContext));
    }
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    try
    {
      File localFile1 = new File(this.l, "x5.tbs");
      File localFile2 = c(this.h);
      if (localFile2 != null)
      {
        if (TbsDownloader.getOverSea(this.h)) {}
        for (Object localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
        {
          localObject = new File(localFile2, (String)localObject);
          localFile1.delete();
          FileUtil.b((File)localObject, localFile1);
          if (a.a(this.h, localFile1, 0L, paramInt)) {
            break;
          }
          TbsLog.i("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
          return false;
        }
        bool = true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + localException.getMessage());
      return false;
    }
    return bool;
  }
  
  @TargetApi(8)
  static File c(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          paramContext = new File(FileUtil.a(paramContext, 4));
          if ((paramContext != null) && (!paramContext.exists()) && (!paramContext.isDirectory())) {
            paramContext.mkdirs();
          }
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        return null;
      }
      paramContext = null;
    }
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2, null);
  }
  
  @TargetApi(8)
  static File d(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        Object localObject2 = a(paramContext, 4);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramContext, 3);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramContext, 2);
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramContext, 1);
        }
        return localObject1;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
      return null;
    }
    return null;
  }
  
  private void d(boolean paramBoolean)
  {
    com.tencent.smtt.utils.q.a(this.h);
    localObject3 = TbsDownloadConfig.getInstance(this.h);
    ((TbsDownloadConfig)localObject3).mSyncMap.put("request_full_package", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
    ((TbsDownloadConfig)localObject3).commit();
    Object localObject1 = QbSdk.n;
    if (paramBoolean)
    {
      i1 = 100;
      ((TbsListener)localObject1).onDownloadFinish(i1);
      i2 = ((TbsDownloadConfig)localObject3).mPreferences.getInt("tbs_responsecode", 0);
      paramBoolean = TbsDownloader.a(this.h);
      if (!paramBoolean) {
        break label415;
      }
      localObject1 = "downloadVersion=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
      localObject1 = (String)localObject1 + "_" + "apkSize=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getLong("tbs_apkfilesize", 0L);
      com.tencent.smtt.utils.q.b(this.h, "download_ok", (String)localObject1);
    }
    for (;;)
    {
      try
      {
        i3 = ((TbsDownloadConfig)localObject3).mPreferences.getInt("tbs_cpu_type_other_stable_core", 0);
        TbsLog.i("TbsDownload", "downloadSuccess #1  cpuTypeForOtherStableCore is " + i3 + " isDownloadDecoupleCore is " + paramBoolean);
        TbsLog.i("TbsDownload", "downloadSuccess #1  responseCode is " + i2);
        if ((paramBoolean) && (com.tencent.smtt.utils.q.b(this.h)) && (i2 != 3))
        {
          localObject1 = this.m.listFiles();
          Pattern localPattern = Pattern.compile(a.a(false, i3));
          int i4 = localObject1.length;
          i1 = 0;
          if (i1 < i4)
          {
            Object localObject4 = localObject1[i1];
            if ((localPattern.matcher(localObject4.getName()).find()) && (localObject4.isFile()) && (localObject4.exists())) {
              localObject4.delete();
            }
            i1 += 1;
            continue;
            i1 = 120;
            break;
            label415:
            if (!TbsShareManager.isThirdPartyApp(this.h)) {
              continue;
            }
            localObject1 = "downloadVersion=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
            localObject1 = (String)localObject1 + "_" + "apkSize=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getLong("tbs_apkfilesize", 0L);
            com.tencent.smtt.utils.q.a(this.h, "download_ok", (String)localObject1);
            continue;
          }
          localObject1 = new File(this.m, a.a(false, i3) + "." + ((TbsDownloadConfig)localObject3).mPreferences.getInt("tbs_download_version", 0));
          if (localObject1 == null) {
            continue;
          }
          bool = ((File)localObject1).exists();
          if (!bool) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        boolean bool;
        TbsLog.i("TbsDownload", "downloadSuccess stack is " + Log.getStackTraceString(localThrowable1));
        continue;
        String str = "stable_32_tpatch_fail";
        continue;
        if (i3 != 64) {
          continue;
        }
        str = "stable_64_tpatch_fail";
        continue;
      }
      try
      {
        bool = new File(this.m, TbsDownloader.getBackupFileName(false) + "." + "tmp").renameTo(new File(this.m, TbsDownloader.getBackupFileName(false, i3)));
        localObject1 = "none";
        if (i3 != 0) {
          break label1584;
        }
        if (!b.b()) {
          continue;
        }
        localObject1 = "stable_64_tpatch_fail";
      }
      catch (Throwable localThrowable2)
      {
        TbsLog.i("TbsDownload", "downloadSuccess stack is " + Log.getStackTraceString(localThrowable2));
        continue;
        if (!paramBoolean) {
          break label1171;
        }
        localObject3 = "downloadVersion=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
        localObject3 = (String)localObject3 + "_" + "apkSize=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getLong("tbs_apkfilesize", 0L);
        localObject3 = (String)localObject3 + "_" + "responseCode=is=" + i2;
        com.tencent.smtt.utils.q.b(this.h, "tpatch_pre_bundle_ok", (String)localObject3);
        TbsLog.i("TbsDownload", "downloadSuccess RESPONSECODE_TPATCH bundle is " + localThrowable2);
        q.a().b(this.h, localThrowable2);
        for (;;)
        {
          a(this.h);
          b(this.h);
          return;
          if (!TbsShareManager.isThirdPartyApp(this.h)) {
            break;
          }
          localObject3 = "downloadVersion=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
          localObject3 = (String)localObject3 + "_" + "apkSize=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getLong("tbs_apkfilesize", 0L);
          localObject3 = (String)localObject3 + "_" + "responseCode=is=" + i2;
          com.tencent.smtt.utils.q.a(this.h, "tpatch_pre_bundle_ok", (String)localObject3);
          break;
          if ((i2 == 3) || (i2 > 10000))
          {
            localObject2 = c(this.h);
            if (localObject2 != null)
            {
              localObject2 = a(i2, (File)localObject2, paramBoolean);
              q.a().b(this.h, (Bundle)localObject2);
            }
            else
            {
              c();
              ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
              ((TbsDownloadConfig)localObject3).commit();
            }
          }
          else
          {
            i1 = ((TbsDownloadConfig)localObject3).mPreferences.getInt("tbs_download_version", 0);
            q.a().a(this.h, new File(this.l, "x5.tbs").getAbsolutePath(), i1);
            if (!com.tencent.smtt.utils.q.b(this.h))
            {
              a(new File(this.l, "x5.tbs"), this.h);
            }
            else
            {
              i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", 0);
              TbsLog.i("TbsDownload", "downloadSuccess tbsCorVer is " + i1 + " stableCoreVersionServer is " + i2);
              if (i1 == i2)
              {
                TbsLog.i("TbsDownload", "downloadSuccess backup");
                a(new File(this.l, "x5.tbs"), this.h);
              }
              else
              {
                TbsLog.i("TbsDownload", "downloadSuccess not backup");
              }
            }
          }
        }
        if (i3 != 32) {
          continue;
        }
        Object localObject2 = "stable_32_tpatch_fail";
        continue;
      }
      n.a(this.h).a((String)localObject1, 0);
      TbsLog.i("TbsDownload", "downloadSuccess setStatus " + (String)localObject1 + " is 0");
      TbsLog.i("TbsDownload", "downloadSuccess renameResult is " + bool);
      TbsLog.i("TbsDownload", "downloadSuccess getTbsStableCoreVersion is " + TbsShareManager.getTbsStableCoreVersion(this.h, i3));
      localObject1 = "cpu=is=" + i3;
      com.tencent.smtt.utils.q.b(this.h, "rename_whole_file_ok", (String)localObject1);
      if ((i2 != 5) && (i2 != 3)) {
        break label1320;
      }
      localObject1 = a(i2, paramBoolean);
      if (localObject1 != null) {
        break label977;
      }
      TbsLog.i("TbsDownload", "downloadSuccess RESPONSECODE_TPATCH bundle is null ");
      a(this.h);
      b(this.h);
      return;
      ((File)localObject1).createNewFile();
    }
  }
  
  public static void e(Context paramContext)
  {
    int i2 = 0;
    for (;;)
    {
      int i1;
      try
      {
        q.a();
        Object localObject1 = q.t(paramContext);
        new File((File)localObject1, "x5.tbs").delete();
        new File((File)localObject1, "x5.tbs.temp").delete();
        paramContext = c(paramContext);
        if (paramContext != null)
        {
          new File(paramContext, TbsDownloader.getBackupFileName(false)).delete();
          new File(paramContext, "x5.oversea.tbs.org").delete();
          paramContext = paramContext.listFiles();
          localObject1 = Pattern.compile(a.a(true) + "(.*)");
          int i3 = paramContext.length;
          i1 = 0;
          Object localObject2;
          if (i1 < i3)
          {
            localObject2 = paramContext[i1];
            if ((!((Pattern)localObject1).matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
              break label262;
            }
            localObject2.delete();
            break label262;
          }
          localObject1 = Pattern.compile(a.a(false) + "(.*)");
          i3 = paramContext.length;
          i1 = i2;
          if (i1 < i3)
          {
            localObject2 = paramContext[i1];
            if ((((Pattern)localObject1).matcher(localObject2.getName()).find()) && (localObject2.isFile()) && (localObject2.exists())) {
              localObject2.delete();
            }
            i1 += 1;
            continue;
          }
        }
        return;
      }
      catch (Exception paramContext) {}
      label262:
      i1 += 1;
    }
  }
  
  private boolean e(boolean paramBoolean)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=" + paramBoolean);
    if (paramBoolean) {}
    for (File localFile = new File(this.l, "x5.tbs");; localFile = new File(this.l, "x5.tbs.temp"))
    {
      if ((localFile != null) && (localFile.exists())) {
        FileUtil.b(localFile);
      }
      return true;
    }
  }
  
  private void g()
  {
    this.r = 0;
    this.s = 0;
    this.n = -1L;
    this.k = null;
    this.q = false;
    this.t = false;
    this.u = false;
    this.A = false;
  }
  
  private void h()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
    if (this.v != null) {
      if (!this.t) {
        this.x.setResolveIp(a(this.v.getURL()));
      }
    }
    try
    {
      this.v.disconnect();
      this.v = null;
      TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest] mHttpRequest set null");
      int i1 = this.x.a;
      if ((!this.t) && (this.A))
      {
        this.x.setEventTime(System.currentTimeMillis());
        String str2 = Apn.getApnInfo(this.h);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        int i2 = Apn.getApnType(this.h);
        this.x.setApn(str1);
        this.x.setNetworkType(i2);
        if ((i2 != this.z) || (!str1.equals(this.y))) {
          this.x.setNetworkChange(0);
        }
        if (((this.x.a == 0) || (this.x.a == 107)) && (this.x.getDownFinalFlag() == 0))
        {
          if (!Apn.isNetworkAvailable(this.h)) {
            a(101, null, true);
          }
        }
        else
        {
          if (!TbsDownloader.a(this.h)) {
            break label316;
          }
          TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.x);
          this.x.resetArgs();
          if (i1 != 100) {
            QbSdk.n.onDownloadFinish(i1);
          }
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label316:
      do
      {
        for (;;)
        {
          TbsLog.e("TbsDownload", "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
          continue;
          if (!m())
          {
            a(101, null, true);
            continue;
            TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.x);
          }
        }
      } while (this.d);
      TbsDownloader.a = false;
    }
  }
  
  private File i()
  {
    String str = FileUtil.a(this.h, 4);
    if (TbsDownloader.getOverSea(this.h)) {}
    for (Object localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
    {
      localObject = new File(str, (String)localObject);
      if (!TbsDownloader.a(this.h)) {
        break;
      }
      return new File(FileUtil.a(this.h, 4), TbsDownloader.getBackupFileName(true));
    }
    return localObject;
  }
  
  private void j()
  {
    try
    {
      Object localObject = i();
      if ((localObject != null) && (((File)localObject).exists()))
      {
        FileUtil.b((File)localObject);
        localObject = ((File)localObject).getParentFile().listFiles();
        Pattern localPattern = Pattern.compile(a.a(TbsDownloader.a(this.h)) + "(.*)");
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          File localFile = localObject[i1];
          if ((localPattern.matcher(localFile.getName()).find()) && (localFile.isFile()) && (localFile.exists())) {
            FileUtil.b(localFile);
          }
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean k()
  {
    boolean bool2 = false;
    File localFile = new File(this.l, "x5.tbs.temp");
    boolean bool1 = bool2;
    if (localFile != null)
    {
      bool1 = bool2;
      if (localFile.exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private long l()
  {
    long l2 = 0L;
    File localFile = new File(this.l, "x5.tbs.temp");
    long l1 = l2;
    if (localFile != null)
    {
      l1 = l2;
      if (localFile.exists()) {
        l1 = localFile.length();
      }
    }
    return l1;
  }
  
  /* Error */
  private boolean m()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: invokestatic 812	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   12: astore 5
    //   14: aload 5
    //   16: new 115	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 814
    //   26: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 816
    //   32: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokevirtual 820	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   41: invokevirtual 826	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: astore 5
    //   46: new 828	java/io/InputStreamReader
    //   49: dup
    //   50: aload 5
    //   52: invokespecial 831	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   55: astore 7
    //   57: new 833	java/io/BufferedReader
    //   60: dup
    //   61: aload 7
    //   63: invokespecial 836	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore 6
    //   68: iconst_0
    //   69: istore_1
    //   70: aload 6
    //   72: invokevirtual 839	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore 8
    //   77: iload 4
    //   79: istore_3
    //   80: aload 8
    //   82: ifnull +29 -> 111
    //   85: aload 8
    //   87: ldc_w 841
    //   90: invokevirtual 330	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   93: ifne +16 -> 109
    //   96: aload 8
    //   98: ldc_w 843
    //   101: invokevirtual 330	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: istore_3
    //   105: iload_3
    //   106: ifeq +25 -> 131
    //   109: iconst_1
    //   110: istore_3
    //   111: aload_0
    //   112: aload 5
    //   114: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   117: aload_0
    //   118: aload 7
    //   120: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   123: aload_0
    //   124: aload 6
    //   126: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   129: iload_3
    //   130: ireturn
    //   131: iload_1
    //   132: iconst_1
    //   133: iadd
    //   134: istore_2
    //   135: iload_2
    //   136: istore_1
    //   137: iload_2
    //   138: iconst_5
    //   139: if_icmplt -69 -> 70
    //   142: iload 4
    //   144: istore_3
    //   145: goto -34 -> 111
    //   148: astore 7
    //   150: aconst_null
    //   151: astore 5
    //   153: aconst_null
    //   154: astore 6
    //   156: aload 9
    //   158: astore 8
    //   160: aload 7
    //   162: invokevirtual 846	java/lang/Throwable:printStackTrace	()V
    //   165: aload_0
    //   166: aload 6
    //   168: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   171: aload_0
    //   172: aload 8
    //   174: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   177: aload_0
    //   178: aload 5
    //   180: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore 6
    //   187: aconst_null
    //   188: astore 7
    //   190: aconst_null
    //   191: astore 5
    //   193: aload_0
    //   194: aload 5
    //   196: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: aload 7
    //   202: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   205: aload_0
    //   206: aload 8
    //   208: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   211: aload 6
    //   213: athrow
    //   214: astore 6
    //   216: aconst_null
    //   217: astore 7
    //   219: goto -26 -> 193
    //   222: astore 6
    //   224: goto -31 -> 193
    //   227: astore 9
    //   229: aload 6
    //   231: astore 8
    //   233: aload 9
    //   235: astore 6
    //   237: goto -44 -> 193
    //   240: astore 10
    //   242: aload 6
    //   244: astore 9
    //   246: aload 8
    //   248: astore 7
    //   250: aload 10
    //   252: astore 6
    //   254: aload 5
    //   256: astore 8
    //   258: aload 9
    //   260: astore 5
    //   262: goto -69 -> 193
    //   265: astore 7
    //   267: aconst_null
    //   268: astore 8
    //   270: aload 5
    //   272: astore 6
    //   274: aload 8
    //   276: astore 5
    //   278: aload 9
    //   280: astore 8
    //   282: goto -122 -> 160
    //   285: astore 10
    //   287: aconst_null
    //   288: astore 9
    //   290: aload 7
    //   292: astore 8
    //   294: aload 5
    //   296: astore 6
    //   298: aload 10
    //   300: astore 7
    //   302: aload 9
    //   304: astore 5
    //   306: goto -146 -> 160
    //   309: astore 10
    //   311: aload 7
    //   313: astore 8
    //   315: aload 5
    //   317: astore 9
    //   319: aload 10
    //   321: astore 7
    //   323: aload 6
    //   325: astore 5
    //   327: aload 9
    //   329: astore 6
    //   331: goto -171 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	m
    //   69	68	1	i1	int
    //   134	6	2	i2	int
    //   79	66	3	bool1	boolean
    //   1	142	4	bool2	boolean
    //   12	314	5	localObject1	Object
    //   66	101	6	localBufferedReader	java.io.BufferedReader
    //   185	27	6	localObject2	Object
    //   214	1	6	localObject3	Object
    //   222	8	6	localObject4	Object
    //   235	95	6	localObject5	Object
    //   55	64	7	localInputStreamReader	java.io.InputStreamReader
    //   148	13	7	localThrowable1	Throwable
    //   188	61	7	localObject6	Object
    //   265	26	7	localThrowable2	Throwable
    //   300	22	7	localObject7	Object
    //   4	310	8	localObject8	Object
    //   7	150	9	localObject9	Object
    //   227	7	9	localObject10	Object
    //   244	84	9	localObject11	Object
    //   240	11	10	localObject12	Object
    //   285	14	10	localThrowable3	Throwable
    //   309	11	10	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	46	148	java/lang/Throwable
    //   14	46	185	finally
    //   46	57	214	finally
    //   57	68	222	finally
    //   70	77	227	finally
    //   85	105	227	finally
    //   160	165	240	finally
    //   46	57	265	java/lang/Throwable
    //   57	68	285	java/lang/Throwable
    //   70	77	309	java/lang/Throwable
    //   85	105	309	java/lang/Throwable
  }
  
  private long n()
  {
    switch (this.r)
    {
    default: 
      return 20000L * 10L;
    case 1: 
    case 2: 
      return 20000L * this.r;
    }
    return 20000L * 5L;
  }
  
  /* Error */
  private boolean o()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_1
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 5
    //   12: aload_0
    //   13: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   16: invokestatic 761	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   19: iconst_3
    //   20: if_icmpne +279 -> 299
    //   23: iconst_1
    //   24: istore_3
    //   25: ldc_w 271
    //   28: new 115	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 854
    //   38: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_3
    //   42: invokevirtual 444	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: iload 5
    //   53: istore_2
    //   54: iload_3
    //   55: ifeq +143 -> 198
    //   58: aload_0
    //   59: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   62: invokestatic 857	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   65: astore 6
    //   67: ldc_w 271
    //   70: new 115	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 859
    //   80: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 6
    //   85: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: new 234	java/net/URL
    //   97: dup
    //   98: ldc_w 861
    //   101: invokespecial 388	java/net/URL:<init>	(Ljava/lang/String;)V
    //   104: invokevirtual 399	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   107: checkcast 392	java/net/HttpURLConnection
    //   110: astore 7
    //   112: aload 7
    //   114: iconst_0
    //   115: invokevirtual 420	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   118: aload 7
    //   120: sipush 10000
    //   123: invokevirtual 423	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   126: aload 7
    //   128: sipush 10000
    //   131: invokevirtual 426	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   134: aload 7
    //   136: iconst_0
    //   137: invokevirtual 864	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   140: aload 7
    //   142: invokevirtual 865	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   145: pop
    //   146: aload 7
    //   148: invokevirtual 868	java/net/HttpURLConnection:getResponseCode	()I
    //   151: istore_1
    //   152: ldc_w 271
    //   155: new 115	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 870
    //   165: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload_1
    //   169: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: iload_1
    //   179: sipush 204
    //   182: if_icmpne +122 -> 304
    //   185: iload 4
    //   187: istore_2
    //   188: aload 7
    //   190: ifnull +203 -> 393
    //   193: aload 7
    //   195: invokevirtual 395	java/net/HttpURLConnection:disconnect	()V
    //   198: iload_2
    //   199: ifne +68 -> 267
    //   202: aload 6
    //   204: invokestatic 875	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne +60 -> 267
    //   210: aload_0
    //   211: getfield 113	com/tencent/smtt/sdk/m:C	Ljava/util/Set;
    //   214: aload 6
    //   216: invokeinterface 879 2 0
    //   221: ifne +46 -> 267
    //   224: aload_0
    //   225: getfield 113	com/tencent/smtt/sdk/m:C	Ljava/util/Set;
    //   228: aload 6
    //   230: invokeinterface 882 2 0
    //   235: pop
    //   236: aload_0
    //   237: invokespecial 884	com/tencent/smtt/sdk/m:p	()V
    //   240: aload_0
    //   241: getfield 886	com/tencent/smtt/sdk/m:B	Landroid/os/Handler;
    //   244: sipush 150
    //   247: aload 6
    //   249: invokevirtual 892	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   252: astore 7
    //   254: aload_0
    //   255: getfield 886	com/tencent/smtt/sdk/m:B	Landroid/os/Handler;
    //   258: aload 7
    //   260: ldc2_w 893
    //   263: invokevirtual 898	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   266: pop
    //   267: iload_2
    //   268: ifeq +29 -> 297
    //   271: aload_0
    //   272: getfield 113	com/tencent/smtt/sdk/m:C	Ljava/util/Set;
    //   275: aload 6
    //   277: invokeinterface 879 2 0
    //   282: ifeq +15 -> 297
    //   285: aload_0
    //   286: getfield 113	com/tencent/smtt/sdk/m:C	Ljava/util/Set;
    //   289: aload 6
    //   291: invokeinterface 901 2 0
    //   296: pop
    //   297: iload_2
    //   298: ireturn
    //   299: iconst_0
    //   300: istore_3
    //   301: goto -276 -> 25
    //   304: iconst_0
    //   305: istore_2
    //   306: goto -118 -> 188
    //   309: astore 7
    //   311: goto -113 -> 198
    //   314: astore 8
    //   316: aconst_null
    //   317: astore 7
    //   319: aload 8
    //   321: invokevirtual 846	java/lang/Throwable:printStackTrace	()V
    //   324: aload 7
    //   326: ifnull +61 -> 387
    //   329: aload 7
    //   331: invokevirtual 395	java/net/HttpURLConnection:disconnect	()V
    //   334: iload 5
    //   336: istore_2
    //   337: goto -139 -> 198
    //   340: astore 7
    //   342: iload 5
    //   344: istore_2
    //   345: goto -147 -> 198
    //   348: astore 6
    //   350: aload 8
    //   352: astore 7
    //   354: aload 7
    //   356: ifnull +8 -> 364
    //   359: aload 7
    //   361: invokevirtual 395	java/net/HttpURLConnection:disconnect	()V
    //   364: aload 6
    //   366: athrow
    //   367: astore 7
    //   369: goto -5 -> 364
    //   372: astore 6
    //   374: goto -20 -> 354
    //   377: astore 6
    //   379: goto -25 -> 354
    //   382: astore 8
    //   384: goto -65 -> 319
    //   387: iload 5
    //   389: istore_2
    //   390: goto -192 -> 198
    //   393: goto -195 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	m
    //   151	32	1	i1	int
    //   53	337	2	bool1	boolean
    //   24	277	3	bool2	boolean
    //   7	179	4	bool3	boolean
    //   10	378	5	bool4	boolean
    //   4	286	6	str	String
    //   348	17	6	localObject1	Object
    //   372	1	6	localObject2	Object
    //   377	1	6	localObject3	Object
    //   110	149	7	localObject4	Object
    //   309	1	7	localException1	Exception
    //   317	13	7	localObject5	Object
    //   340	1	7	localException2	Exception
    //   352	8	7	localThrowable1	Throwable
    //   367	1	7	localException3	Exception
    //   1	1	8	localObject6	Object
    //   314	37	8	localThrowable2	Throwable
    //   382	1	8	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   193	198	309	java/lang/Exception
    //   94	112	314	java/lang/Throwable
    //   329	334	340	java/lang/Exception
    //   94	112	348	finally
    //   359	364	367	java/lang/Exception
    //   112	178	372	finally
    //   319	324	377	finally
    //   112	178	382	java/lang/Throwable
  }
  
  private void p()
  {
    if (this.B == null) {
      this.B = new m.1(this, o.a().getLooper());
    }
  }
  
  public Bundle a(int paramInt, File paramFile, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      paramFile = new File(paramFile, TbsDownloader.getBackupFileName(true));
      i1 = a.a(this.h, paramFile);
      localObject = new File(this.l, "x5.tbs");
      if (!((File)localObject).exists()) {
        break label189;
      }
    }
    label189:
    for (Object localObject = ((File)localObject).getAbsolutePath();; localObject = null)
    {
      int i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
      Bundle localBundle = new Bundle();
      localBundle.putInt("operation", paramInt);
      localBundle.putInt("old_core_ver", i1);
      localBundle.putInt("new_core_ver", i2);
      localBundle.putString("old_apk_location", paramFile.getAbsolutePath());
      localBundle.putString("new_apk_location", (String)localObject);
      localBundle.putString("diff_file_location", (String)localObject);
      return localBundle;
      if (TbsDownloader.getOverSea(this.h)) {}
      for (localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
      {
        paramFile = new File(paramFile, (String)localObject);
        break;
      }
    }
  }
  
  public Bundle a(int paramInt, boolean paramBoolean)
  {
    Object localObject5 = null;
    String str = "not_stable";
    int i2;
    Object localObject1;
    int i1;
    Object localObject4;
    Object localObject2;
    if (paramBoolean) {
      if (com.tencent.smtt.utils.q.b(this.h))
      {
        i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_cpu_type_other_stable_core", 0);
        localObject1 = new File(this.m, TbsDownloader.getBackupFileName(false, i2));
        i1 = TbsShareManager.getTbsStableCoreVersion(this.h, i2);
        str = "stable_core_" + i2;
        localObject4 = new File(this.l, "x5.tbs");
        if (!((File)localObject4).exists()) {
          break label295;
        }
        localObject2 = ((File)localObject4).getAbsolutePath();
        label126:
        if ((!paramBoolean) || (!com.tencent.smtt.utils.q.b(this.h))) {
          break label632;
        }
        localObject4 = new File(this.m, TbsDownloader.getBackupFileName(false) + "." + "tmp");
        if (!((File)localObject4).exists()) {
          break label301;
        }
        localObject2 = ((File)localObject4).getAbsolutePath();
      }
    }
    label197:
    label632:
    for (Object localObject3 = localObject2;; localObject3 = localObject2)
    {
      if (localObject3 == null)
      {
        TbsLog.i("TbsDownload", "gettpatchBundle tbsApkFile is " + ((File)localObject4).getAbsolutePath());
        localObject1 = localObject5;
        return localObject1;
        localObject1 = q.a().q(this.h);
        i1 = q.a().i(this.h);
        break;
        localObject1 = q.a().r(this.h);
        i1 = q.a().j(this.h);
        break;
        localObject2 = null;
        break label126;
        localObject2 = null;
        break label197;
      }
      i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
      if (paramBoolean) {
        if (com.tencent.smtt.utils.q.b(this.h)) {
          localObject2 = new File(this.m, TbsDownloader.getBackupFileName(false) + "." + "tpatch" + "." + "tmp");
        }
      }
      for (;;)
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("operation", paramInt);
        ((Bundle)localObject4).putInt("old_core_ver", i1);
        ((Bundle)localObject4).putInt("new_core_ver", i2);
        ((Bundle)localObject4).putString("old_apk_location", ((File)localObject1).getAbsolutePath());
        ((Bundle)localObject4).putString("new_apk_location", ((File)localObject2).getAbsolutePath());
        ((Bundle)localObject4).putString("diff_file_location", localObject3);
        ((Bundle)localObject4).putString("core_type_tpatch", str);
        localObject1 = FileUtil.a(this.h, 7);
        localObject2 = new File((String)localObject1);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        ((Bundle)localObject4).putString("backup_apk", new File((String)localObject1, i2 + ".tbs").getAbsolutePath());
        if ((paramBoolean) && (com.tencent.smtt.utils.q.b(this.h))) {
          ((Bundle)localObject4).putInt("for_stable_core", 1);
        }
        localObject1 = localObject4;
        if (paramBoolean) {
          break;
        }
        ((Bundle)localObject4).putInt("for_self_core", 1);
        return localObject4;
        localObject2 = q.a().f(this.h, 6);
        continue;
        localObject2 = q.a().f(this.h, 5);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (q.a().u(this.h)) {
      q.a().b();
    }
    try
    {
      File localFile = new File(this.l, "x5.tbs");
      int i1 = a.a(this.h, localFile);
      if ((-1 == i1) || ((paramInt > 0) && (paramInt == i1))) {
        FileUtil.b(localFile);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean, false);
  }
  
  public boolean a()
  {
    TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
    for (;;)
    {
      int i2;
      try
      {
        File localFile;
        if (com.tencent.smtt.utils.q.b(this.h))
        {
          localFile = new File(FileUtil.a(this.h, "com.tencent.mm", 4, true), TbsDownloader.getBackupFileName(false));
          if (localFile != null) {
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup backupFile is " + localFile.getAbsolutePath());
          }
          if ((localFile != null) && (localFile.exists()))
          {
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            if (!a.a(this.h, localFile, 0L, TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1))) {
              break label603;
            }
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
            if (!com.tencent.smtt.utils.q.b(this.h)) {
              break label644;
            }
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup isStableCoreForHostEnable and return true");
            return true;
          }
        }
        else
        {
          localFile = new File(FileUtil.a(this.h, 4), TbsDownloader.getBackupFileName(true));
          continue;
        }
        Object localObject1 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1));
        if (localObject1 != null) {
          TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup getExistBackupCoreForDecouple is " + ((File)localObject1).getAbsolutePath());
        }
        if ((localObject1 != null) && (((File)localObject1).exists())) {
          FileUtil.b((File)localObject1, localFile);
        }
        try
        {
          localObject1 = ((File)localObject1).getName();
          TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup fileNameSource is " + (String)localObject1);
          if (!((String)localObject1).contains("64")) {
            break label668;
          }
          i1 = 64;
          if (!com.tencent.smtt.utils.q.b(this.h)) {
            continue;
          }
          localObject1 = this.m.listFiles();
          Pattern localPattern = Pattern.compile(a.a(false, i1));
          int i3 = localObject1.length;
          i2 = 0;
          if (i2 < i3)
          {
            Object localObject2 = localObject1[i2];
            if ((!localPattern.matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
              break label674;
            }
            localObject2.delete();
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup delete file " + localObject2.getAbsolutePath());
            break label674;
          }
          localObject1 = new File(this.m, a.a(false, i1) + "." + TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1));
          if ((localObject1 == null) || (!((File)localObject1).exists())) {
            break label605;
          }
          TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup  file already exist " + ((File)localObject1).getAbsolutePath());
        }
        catch (Throwable localThrowable)
        {
          TbsLog.i("TbsApkDownloader", "stack is " + Log.getStackTraceString(localThrowable));
        }
        continue;
        return false;
      }
      catch (Exception localException)
      {
        TbsLog.i("TbsApkDownloader", "stack is " + Log.getStackTraceString(localException));
      }
      label603:
      label605:
      localThrowable.createNewFile();
      TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup create file " + localThrowable.getAbsolutePath());
      continue;
      label644:
      TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup goto installDecoupleCoreFromBackup");
      boolean bool = q.a().f(this.h);
      return bool;
      label668:
      int i1 = 32;
      continue;
      label674:
      i2 += 1;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT == 23) {}
    label73:
    label335:
    label337:
    label353:
    label359:
    label379:
    do
    {
      return false;
      int i1 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("use_backup_version", 0);
      int i2 = q.a().j(this.h);
      File localFile;
      Object localObject;
      if (i1 == 0)
      {
        i1 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
        this.a = "by default key";
        if ((i1 == 0) || (i1 == i2)) {
          break label335;
        }
        if (!paramBoolean2) {
          break label438;
        }
        localFile = TbsDownloader.a(i1);
        if ((localFile == null) || (!localFile.exists())) {
          break label353;
        }
        String str = FileUtil.a(this.h, 4);
        if (!TbsDownloader.getOverSea(this.h)) {
          break label337;
        }
        localObject = "x5.oversea.tbs.org";
        localObject = new File(str, (String)localObject);
      }
      for (;;)
      {
        try
        {
          if (TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version_type", 0) == 1) {
            break label353;
          }
          FileUtil.b(localFile, (File)localObject);
          i2 = 1;
          localObject = i();
          if ((localObject == null) || (!((File)localObject).exists()) || (!a((File)localObject))) {
            break label379;
          }
          if (!b(i1)) {
            break label438;
          }
          TbsDownloadConfig.getInstance(this.h).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
          TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-214);
          d(false);
          if (i2 != 0)
          {
            a(100, "use local backup apk in startDownload" + this.a, true);
            if (!TbsDownloader.a(this.h)) {
              break label359;
            }
            TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.x);
            this.x.resetArgs();
          }
          return true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.a = "by new key";
        break label73;
        break;
        localObject = TbsDownloader.getBackupFileName(false);
        break label130;
        i2 = 0;
        continue;
        TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.x);
      }
      if (!com.tencent.smtt.utils.q.b(this.h)) {
        j();
      }
      if ((localFile != null) && (localFile.exists()) && (!a.a(this.h, localFile, 0L, i1)) && (localFile != null) && (localFile.exists())) {
        FileUtil.b(localFile);
      }
      if (c(false, paramBoolean2))
      {
        TbsDownloadConfig.getInstance(this.h).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
        TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-214);
        d(false);
        return true;
      }
    } while ((e(true)) || (e(true)));
    label130:
    label438:
    TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
    TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-301);
    return false;
  }
  
  public void b()
  {
    this.t = true;
    TbsLogReport.TbsLogInfo localTbsLogInfo;
    if (TbsShareManager.isThirdPartyApp(this.h))
    {
      localTbsLogInfo = TbsLogReport.getInstance(this.h).tbsLogInfo();
      localTbsLogInfo.setErrorCode(-309);
      localTbsLogInfo.setFailDetail(new Exception());
      if (TbsDownloader.a(this.h)) {
        TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, localTbsLogInfo);
      }
    }
    else
    {
      return;
    }
    TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, localTbsLogInfo);
  }
  
  /* Error */
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 136	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   3: aload_0
    //   4: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   7: invokevirtual 1039	com/tencent/smtt/sdk/q:d	(Landroid/content/Context;)Z
    //   10: ifeq +25 -> 35
    //   13: iload_1
    //   14: ifne +21 -> 35
    //   17: iconst_0
    //   18: putstatic 798	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   21: aload_0
    //   22: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   25: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   28: sipush -322
    //   31: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   34: return
    //   35: aload_0
    //   36: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   39: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   42: getfield 367	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   45: ldc_w 612
    //   48: iconst_0
    //   49: invokeinterface 375 3 0
    //   54: istore_3
    //   55: iload_3
    //   56: iconst_1
    //   57: if_icmpeq +13 -> 70
    //   60: iload_3
    //   61: iconst_2
    //   62: if_icmpeq +8 -> 70
    //   65: iload_3
    //   66: iconst_4
    //   67: if_icmpne +25 -> 92
    //   70: iconst_1
    //   71: istore 9
    //   73: iload_2
    //   74: ifne +24 -> 98
    //   77: aload_0
    //   78: iload_1
    //   79: iload 9
    //   81: invokevirtual 1041	com/tencent/smtt/sdk/m:a	(ZZ)Z
    //   84: ifeq +14 -> 98
    //   87: iconst_0
    //   88: putstatic 798	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   91: return
    //   92: iconst_0
    //   93: istore 9
    //   95: goto -22 -> 73
    //   98: aload_0
    //   99: iload_1
    //   100: putfield 1043	com/tencent/smtt/sdk/m:E	Z
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   108: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   111: getfield 367	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   114: ldc_w 1045
    //   117: aconst_null
    //   118: invokeinterface 456 3 0
    //   123: putfield 1047	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   126: aload_0
    //   127: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   130: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   133: getfield 367	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   136: ldc_w 1049
    //   139: aconst_null
    //   140: invokeinterface 456 3 0
    //   145: astore 28
    //   147: ldc_w 271
    //   150: new 115	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 1051
    //   160: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 28
    //   165: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: iconst_1
    //   172: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   175: aload_0
    //   176: aconst_null
    //   177: putfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 88	com/tencent/smtt/sdk/m:c	I
    //   185: iload_1
    //   186: ifne +36 -> 222
    //   189: aload 28
    //   191: ifnull +31 -> 222
    //   194: ldc 251
    //   196: aload 28
    //   198: invokevirtual 1057	java/lang/String:trim	()Ljava/lang/String;
    //   201: invokevirtual 463	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifne +18 -> 222
    //   207: aload_0
    //   208: aload 28
    //   210: invokevirtual 1057	java/lang/String:trim	()Ljava/lang/String;
    //   213: ldc_w 1059
    //   216: invokevirtual 1063	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   219: putfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   222: ldc_w 271
    //   225: new 115	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 1065
    //   235: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_0
    //   239: getfield 1047	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   242: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 1067
    //   248: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 28
    //   253: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc_w 1069
    //   259: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_0
    //   263: getfield 726	com/tencent/smtt/sdk/m:k	Ljava/lang/String;
    //   266: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 1071
    //   272: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_0
    //   276: getfield 730	com/tencent/smtt/sdk/m:t	Z
    //   279: invokevirtual 444	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   282: ldc_w 1073
    //   285: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_0
    //   289: getfield 390	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   292: invokevirtual 520	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload_0
    //   302: getfield 1047	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   305: ifnonnull +34 -> 339
    //   308: aload_0
    //   309: getfield 726	com/tencent/smtt/sdk/m:k	Ljava/lang/String;
    //   312: ifnonnull +27 -> 339
    //   315: getstatic 605	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   318: bipush 110
    //   320: invokeinterface 610 2 0
    //   325: aload_0
    //   326: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   329: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   332: sipush -302
    //   335: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   338: return
    //   339: aload_0
    //   340: getfield 390	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   343: ifnull +34 -> 377
    //   346: aload_0
    //   347: getfield 730	com/tencent/smtt/sdk/m:t	Z
    //   350: ifne +27 -> 377
    //   353: getstatic 605	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   356: bipush 110
    //   358: invokeinterface 610 2 0
    //   363: aload_0
    //   364: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   367: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   370: sipush -303
    //   373: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   376: return
    //   377: iload_1
    //   378: ifne +55 -> 433
    //   381: aload_0
    //   382: getfield 113	com/tencent/smtt/sdk/m:C	Ljava/util/Set;
    //   385: aload_0
    //   386: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   389: invokestatic 857	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   392: invokeinterface 879 2 0
    //   397: ifeq +36 -> 433
    //   400: ldc_w 271
    //   403: ldc_w 1075
    //   406: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: getstatic 605	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   412: bipush 110
    //   414: invokeinterface 610 2 0
    //   419: aload_0
    //   420: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   423: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   426: sipush -304
    //   429: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   432: return
    //   433: aload_0
    //   434: invokespecial 166	com/tencent/smtt/sdk/m:g	()V
    //   437: ldc_w 271
    //   440: ldc_w 1077
    //   443: iconst_1
    //   444: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   447: aload_0
    //   448: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   451: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   454: invokevirtual 1080	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   457: lstore 26
    //   459: iconst_0
    //   460: istore 6
    //   462: aload_0
    //   463: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   466: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   469: getfield 367	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   472: ldc_w 1082
    //   475: lconst_0
    //   476: invokeinterface 480 4 0
    //   481: lstore 10
    //   483: iload_1
    //   484: ifeq +439 -> 923
    //   487: aload_0
    //   488: getstatic 53	com/tencent/smtt/sdk/m:f	I
    //   491: putfield 84	com/tencent/smtt/sdk/m:D	I
    //   494: iload_2
    //   495: ifeq +438 -> 933
    //   498: new 115	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 615
    //   508: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_0
    //   512: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   515: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   518: getfield 367	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   521: ldc_w 369
    //   524: iconst_0
    //   525: invokeinterface 375 3 0
    //   530: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   533: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: astore 28
    //   538: new 115	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   545: aload 28
    //   547: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 617
    //   553: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc_w 619
    //   559: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_0
    //   563: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   566: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   569: getfield 367	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   572: ldc_w 476
    //   575: lconst_0
    //   576: invokeinterface 480 4 0
    //   581: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   584: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: astore 28
    //   589: aload_0
    //   590: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   593: ldc_w 1084
    //   596: aload 28
    //   598: invokestatic 624	com/tencent/smtt/utils/q:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   601: iload 6
    //   603: istore 5
    //   605: lload 10
    //   607: lstore 12
    //   609: aload_0
    //   610: getfield 255	com/tencent/smtt/sdk/m:r	I
    //   613: aload_0
    //   614: getfield 84	com/tencent/smtt/sdk/m:D	I
    //   617: if_icmple +448 -> 1065
    //   620: iload 5
    //   622: istore 6
    //   624: aload_0
    //   625: getfield 730	com/tencent/smtt/sdk/m:t	Z
    //   628: ifne +290 -> 918
    //   631: iload 6
    //   633: istore_1
    //   634: aload_0
    //   635: getfield 732	com/tencent/smtt/sdk/m:u	Z
    //   638: ifeq +209 -> 847
    //   641: iload 6
    //   643: istore_1
    //   644: aload_0
    //   645: getfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   648: ifnonnull +73 -> 721
    //   651: iload 6
    //   653: istore_1
    //   654: iload 6
    //   656: ifne +65 -> 721
    //   659: iload_2
    //   660: ifeq +6341 -> 7001
    //   663: aload_0
    //   664: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   667: invokestatic 634	com/tencent/smtt/utils/q:b	(Landroid/content/Context;)Z
    //   670: ifeq +6331 -> 7001
    //   673: aload_0
    //   674: iconst_1
    //   675: iload 9
    //   677: new 156	java/io/File
    //   680: dup
    //   681: aload_0
    //   682: getfield 164	com/tencent/smtt/sdk/m:m	Ljava/io/File;
    //   685: new 115	java/lang/StringBuilder
    //   688: dup
    //   689: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   692: iconst_0
    //   693: invokestatic 213	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   696: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: ldc_w 377
    //   702: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc_w 641
    //   708: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokespecial 209	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   717: invokespecial 572	com/tencent/smtt/sdk/m:a	(ZZLjava/io/File;)Z
    //   720: istore_1
    //   721: aload_0
    //   722: getfield 108	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   725: astore 28
    //   727: iload_1
    //   728: ifeq +6284 -> 7012
    //   731: iconst_1
    //   732: istore_3
    //   733: aload 28
    //   735: iload_3
    //   736: invokevirtual 1087	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   739: new 115	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   746: ldc_w 1089
    //   749: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: iload_1
    //   753: invokevirtual 444	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   756: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 1091	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   762: iload 9
    //   764: ifne +6258 -> 7022
    //   767: aload_0
    //   768: getfield 108	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   771: astore 28
    //   773: iload_1
    //   774: ifeq +6243 -> 7017
    //   777: iconst_1
    //   778: istore_3
    //   779: aload 28
    //   781: iload_3
    //   782: invokevirtual 1094	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   785: ldc_w 271
    //   788: new 115	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   795: ldc_w 1096
    //   798: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: iload_1
    //   802: invokevirtual 444	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   805: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   811: iload_1
    //   812: ifeq +6221 -> 7033
    //   815: aload_0
    //   816: invokespecial 1098	com/tencent/smtt/sdk/m:h	()V
    //   819: aload_0
    //   820: iconst_1
    //   821: invokespecial 1021	com/tencent/smtt/sdk/m:d	(Z)V
    //   824: aload_0
    //   825: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   828: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   831: sipush -317
    //   834: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   837: aload_0
    //   838: bipush 100
    //   840: ldc_w 1100
    //   843: iconst_1
    //   844: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   847: aload_0
    //   848: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   851: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   854: astore 28
    //   856: iload_1
    //   857: ifeq +6198 -> 7055
    //   860: aload 28
    //   862: getfield 367	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   865: ldc_w 1102
    //   868: iconst_0
    //   869: invokeinterface 375 3 0
    //   874: istore_3
    //   875: aload 28
    //   877: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   880: ldc_w 1102
    //   883: iload_3
    //   884: iconst_1
    //   885: iadd
    //   886: invokestatic 526	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   889: invokeinterface 593 3 0
    //   894: pop
    //   895: aload 28
    //   897: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   900: aload_0
    //   901: getfield 108	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   904: astore 28
    //   906: iload_1
    //   907: ifeq +6209 -> 7116
    //   910: iconst_1
    //   911: istore_3
    //   912: aload 28
    //   914: iload_3
    //   915: invokevirtual 1105	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   918: aload_0
    //   919: invokespecial 1098	com/tencent/smtt/sdk/m:h	()V
    //   922: return
    //   923: aload_0
    //   924: getstatic 51	com/tencent/smtt/sdk/m:e	I
    //   927: putfield 84	com/tencent/smtt/sdk/m:D	I
    //   930: goto -436 -> 494
    //   933: lload 10
    //   935: lstore 12
    //   937: iload 6
    //   939: istore 5
    //   941: aload_0
    //   942: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   945: invokestatic 313	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   948: ifeq -339 -> 609
    //   951: new 115	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   958: ldc_w 615
    //   961: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: aload_0
    //   965: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   968: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   971: getfield 367	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   974: ldc_w 369
    //   977: iconst_0
    //   978: invokeinterface 375 3 0
    //   983: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   986: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: astore 28
    //   991: new 115	java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   998: aload 28
    //   1000: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: ldc_w 617
    //   1006: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: ldc_w 619
    //   1012: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: aload_0
    //   1016: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1019: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1022: getfield 367	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1025: ldc_w 476
    //   1028: lconst_0
    //   1029: invokeinterface 480 4 0
    //   1034: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1037: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: astore 28
    //   1042: aload_0
    //   1043: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1046: ldc_w 1084
    //   1049: aload 28
    //   1051: invokestatic 639	com/tencent/smtt/utils/q:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1054: lload 10
    //   1056: lstore 12
    //   1058: iload 6
    //   1060: istore 5
    //   1062: goto -453 -> 609
    //   1065: aload_0
    //   1066: getfield 720	com/tencent/smtt/sdk/m:s	I
    //   1069: bipush 8
    //   1071: if_icmple +31 -> 1102
    //   1074: aload_0
    //   1075: bipush 123
    //   1077: aconst_null
    //   1078: iconst_1
    //   1079: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   1082: aload_0
    //   1083: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1086: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1089: sipush -306
    //   1092: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1095: iload 5
    //   1097: istore 6
    //   1099: goto -475 -> 624
    //   1102: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   1105: lstore 24
    //   1107: lload 12
    //   1109: lstore 10
    //   1111: iload_1
    //   1112: ifne +462 -> 1574
    //   1115: lload 12
    //   1117: lstore 16
    //   1119: iload 5
    //   1121: istore 6
    //   1123: lload 12
    //   1125: lstore 14
    //   1127: lload 24
    //   1129: aload_0
    //   1130: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1133: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1136: getfield 367	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1139: ldc_w 1107
    //   1142: lconst_0
    //   1143: invokeinterface 480 4 0
    //   1148: lsub
    //   1149: ldc2_w 1108
    //   1152: lcmp
    //   1153: ifle +258 -> 1411
    //   1156: lload 12
    //   1158: lstore 16
    //   1160: iload 5
    //   1162: istore 6
    //   1164: lload 12
    //   1166: lstore 14
    //   1168: ldc_w 271
    //   1171: ldc_w 1111
    //   1174: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1177: lload 12
    //   1179: lstore 16
    //   1181: iload 5
    //   1183: istore 6
    //   1185: lload 12
    //   1187: lstore 14
    //   1189: aload_0
    //   1190: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1193: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1196: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1199: ldc_w 1107
    //   1202: lload 24
    //   1204: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1207: invokeinterface 593 3 0
    //   1212: pop
    //   1213: lload 12
    //   1215: lstore 16
    //   1217: iload 5
    //   1219: istore 6
    //   1221: lload 12
    //   1223: lstore 14
    //   1225: aload_0
    //   1226: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1229: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1232: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1235: ldc_w 1082
    //   1238: lconst_0
    //   1239: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1242: invokeinterface 593 3 0
    //   1247: pop
    //   1248: lload 12
    //   1250: lstore 16
    //   1252: iload 5
    //   1254: istore 6
    //   1256: lload 12
    //   1258: lstore 14
    //   1260: aload_0
    //   1261: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1264: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1267: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1270: lconst_0
    //   1271: lstore 10
    //   1273: iload 5
    //   1275: istore 6
    //   1277: lload 10
    //   1279: lstore 12
    //   1281: lload 10
    //   1283: lstore 14
    //   1285: aload_0
    //   1286: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1289: invokestatic 1117	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   1292: ifne +282 -> 1574
    //   1295: iload 5
    //   1297: istore 6
    //   1299: lload 10
    //   1301: lstore 12
    //   1303: lload 10
    //   1305: lstore 14
    //   1307: ldc_w 271
    //   1310: ldc_w 1119
    //   1313: iconst_1
    //   1314: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1317: iload 5
    //   1319: istore 6
    //   1321: lload 10
    //   1323: lstore 12
    //   1325: lload 10
    //   1327: lstore 14
    //   1329: aload_0
    //   1330: bipush 105
    //   1332: aconst_null
    //   1333: iconst_1
    //   1334: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   1337: iload 5
    //   1339: istore 6
    //   1341: lload 10
    //   1343: lstore 12
    //   1345: lload 10
    //   1347: lstore 14
    //   1349: aload_0
    //   1350: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1353: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1356: sipush -308
    //   1359: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1362: iload 5
    //   1364: istore 6
    //   1366: iload_1
    //   1367: ifne -743 -> 624
    //   1370: aload_0
    //   1371: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1374: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1377: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1380: ldc_w 1082
    //   1383: lload 10
    //   1385: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1388: invokeinterface 593 3 0
    //   1393: pop
    //   1394: aload_0
    //   1395: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1398: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1401: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1404: iload 5
    //   1406: istore 6
    //   1408: goto -784 -> 624
    //   1411: lload 12
    //   1413: lstore 16
    //   1415: iload 5
    //   1417: istore 6
    //   1419: lload 12
    //   1421: lstore 14
    //   1423: ldc_w 271
    //   1426: new 115	java/lang/StringBuilder
    //   1429: dup
    //   1430: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1433: ldc_w 1121
    //   1436: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: lload 12
    //   1441: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1444: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1450: lload 12
    //   1452: lload 26
    //   1454: lcmp
    //   1455: iflt +5847 -> 7302
    //   1458: lload 12
    //   1460: lstore 16
    //   1462: iload 5
    //   1464: istore 6
    //   1466: lload 12
    //   1468: lstore 14
    //   1470: ldc_w 271
    //   1473: ldc_w 1123
    //   1476: iconst_1
    //   1477: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1480: lload 12
    //   1482: lstore 16
    //   1484: iload 5
    //   1486: istore 6
    //   1488: lload 12
    //   1490: lstore 14
    //   1492: aload_0
    //   1493: bipush 112
    //   1495: aconst_null
    //   1496: iconst_1
    //   1497: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   1500: lload 12
    //   1502: lstore 16
    //   1504: iload 5
    //   1506: istore 6
    //   1508: lload 12
    //   1510: lstore 14
    //   1512: aload_0
    //   1513: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1516: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1519: sipush -307
    //   1522: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1525: iload 5
    //   1527: istore 6
    //   1529: iload_1
    //   1530: ifne -906 -> 624
    //   1533: aload_0
    //   1534: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1537: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1540: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1543: ldc_w 1082
    //   1546: lload 12
    //   1548: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1551: invokeinterface 593 3 0
    //   1556: pop
    //   1557: aload_0
    //   1558: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1561: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1564: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1567: iload 5
    //   1569: istore 6
    //   1571: goto -947 -> 624
    //   1574: lload 10
    //   1576: lstore 16
    //   1578: iload 5
    //   1580: istore 6
    //   1582: lload 10
    //   1584: lstore 14
    //   1586: aload_0
    //   1587: iconst_1
    //   1588: putfield 734	com/tencent/smtt/sdk/m:A	Z
    //   1591: lload 10
    //   1593: lstore 16
    //   1595: iload 5
    //   1597: istore 6
    //   1599: lload 10
    //   1601: lstore 14
    //   1603: aload_0
    //   1604: getfield 726	com/tencent/smtt/sdk/m:k	Ljava/lang/String;
    //   1607: ifnull +888 -> 2495
    //   1610: lload 10
    //   1612: lstore 16
    //   1614: iload 5
    //   1616: istore 6
    //   1618: lload 10
    //   1620: lstore 14
    //   1622: aload_0
    //   1623: getfield 726	com/tencent/smtt/sdk/m:k	Ljava/lang/String;
    //   1626: astore 28
    //   1628: lload 10
    //   1630: lstore 16
    //   1632: iload 5
    //   1634: istore 6
    //   1636: lload 10
    //   1638: lstore 14
    //   1640: ldc_w 271
    //   1643: new 115	java/lang/StringBuilder
    //   1646: dup
    //   1647: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1650: ldc_w 1125
    //   1653: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1656: aload 28
    //   1658: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: ldc_w 1127
    //   1664: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1667: aload_0
    //   1668: getfield 255	com/tencent/smtt/sdk/m:r	I
    //   1671: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1674: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1677: iconst_1
    //   1678: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1681: lload 10
    //   1683: lstore 16
    //   1685: iload 5
    //   1687: istore 6
    //   1689: lload 10
    //   1691: lstore 14
    //   1693: aload 28
    //   1695: aload_0
    //   1696: getfield 1129	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   1699: invokevirtual 463	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1702: ifne +24 -> 1726
    //   1705: lload 10
    //   1707: lstore 16
    //   1709: iload 5
    //   1711: istore 6
    //   1713: lload 10
    //   1715: lstore 14
    //   1717: aload_0
    //   1718: getfield 108	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1721: aload 28
    //   1723: invokevirtual 1132	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1726: lload 10
    //   1728: lstore 16
    //   1730: iload 5
    //   1732: istore 6
    //   1734: lload 10
    //   1736: lstore 14
    //   1738: aload_0
    //   1739: aload 28
    //   1741: putfield 1129	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   1744: lload 10
    //   1746: lstore 16
    //   1748: iload 5
    //   1750: istore 6
    //   1752: lload 10
    //   1754: lstore 14
    //   1756: aload_0
    //   1757: aload 28
    //   1759: invokespecial 1133	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;)V
    //   1762: lconst_0
    //   1763: lstore 12
    //   1765: lload 10
    //   1767: lstore 16
    //   1769: iload 5
    //   1771: istore 6
    //   1773: lload 10
    //   1775: lstore 14
    //   1777: aload_0
    //   1778: getfield 728	com/tencent/smtt/sdk/m:q	Z
    //   1781: ifne +170 -> 1951
    //   1784: lload 10
    //   1786: lstore 16
    //   1788: iload 5
    //   1790: istore 6
    //   1792: lload 10
    //   1794: lstore 14
    //   1796: aload_0
    //   1797: invokespecial 1135	com/tencent/smtt/sdk/m:l	()J
    //   1800: lstore 12
    //   1802: lload 10
    //   1804: lstore 16
    //   1806: iload 5
    //   1808: istore 6
    //   1810: lload 10
    //   1812: lstore 14
    //   1814: ldc_w 271
    //   1817: new 115	java/lang/StringBuilder
    //   1820: dup
    //   1821: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1824: ldc_w 1137
    //   1827: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: lload 12
    //   1832: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1835: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1838: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1841: lload 10
    //   1843: lstore 16
    //   1845: iload 5
    //   1847: istore 6
    //   1849: lload 10
    //   1851: lstore 14
    //   1853: aload_0
    //   1854: getfield 724	com/tencent/smtt/sdk/m:n	J
    //   1857: lconst_0
    //   1858: lcmp
    //   1859: ifgt +657 -> 2516
    //   1862: lload 10
    //   1864: lstore 16
    //   1866: iload 5
    //   1868: istore 6
    //   1870: lload 10
    //   1872: lstore 14
    //   1874: ldc_w 271
    //   1877: new 115	java/lang/StringBuilder
    //   1880: dup
    //   1881: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1884: ldc_w 1139
    //   1887: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: lload 12
    //   1892: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1895: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1898: iconst_1
    //   1899: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1902: lload 10
    //   1904: lstore 16
    //   1906: iload 5
    //   1908: istore 6
    //   1910: lload 10
    //   1912: lstore 14
    //   1914: aload_0
    //   1915: getfield 390	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   1918: ldc_w 1141
    //   1921: new 115	java/lang/StringBuilder
    //   1924: dup
    //   1925: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1928: ldc_w 1143
    //   1931: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1934: lload 12
    //   1936: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1939: ldc_w 1145
    //   1942: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1945: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1948: invokevirtual 407	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1951: lload 10
    //   1953: lstore 16
    //   1955: iload 5
    //   1957: istore 6
    //   1959: lload 10
    //   1961: lstore 14
    //   1963: aload_0
    //   1964: getfield 108	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1967: astore 28
    //   1969: lload 12
    //   1971: lconst_0
    //   1972: lcmp
    //   1973: ifne +886 -> 2859
    //   1976: iconst_0
    //   1977: istore_3
    //   1978: lload 10
    //   1980: lstore 16
    //   1982: iload 5
    //   1984: istore 6
    //   1986: lload 10
    //   1988: lstore 14
    //   1990: aload 28
    //   1992: iload_3
    //   1993: invokevirtual 1148	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1996: lload 10
    //   1998: lstore 16
    //   2000: iload 5
    //   2002: istore 6
    //   2004: lload 10
    //   2006: lstore 14
    //   2008: aload_0
    //   2009: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2012: invokestatic 761	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2015: istore_3
    //   2016: lload 10
    //   2018: lstore 16
    //   2020: iload 5
    //   2022: istore 6
    //   2024: lload 10
    //   2026: lstore 14
    //   2028: aload_0
    //   2029: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2032: invokestatic 757	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   2035: astore 28
    //   2037: lload 10
    //   2039: lstore 16
    //   2041: iload 5
    //   2043: istore 6
    //   2045: lload 10
    //   2047: lstore 14
    //   2049: aload_0
    //   2050: getfield 168	com/tencent/smtt/sdk/m:y	Ljava/lang/String;
    //   2053: ifnonnull +811 -> 2864
    //   2056: lload 10
    //   2058: lstore 16
    //   2060: iload 5
    //   2062: istore 6
    //   2064: lload 10
    //   2066: lstore 14
    //   2068: aload_0
    //   2069: getfield 170	com/tencent/smtt/sdk/m:z	I
    //   2072: iconst_m1
    //   2073: if_icmpne +791 -> 2864
    //   2076: lload 10
    //   2078: lstore 16
    //   2080: iload 5
    //   2082: istore 6
    //   2084: lload 10
    //   2086: lstore 14
    //   2088: aload_0
    //   2089: aload 28
    //   2091: putfield 168	com/tencent/smtt/sdk/m:y	Ljava/lang/String;
    //   2094: lload 10
    //   2096: lstore 16
    //   2098: iload 5
    //   2100: istore 6
    //   2102: lload 10
    //   2104: lstore 14
    //   2106: aload_0
    //   2107: iload_3
    //   2108: putfield 170	com/tencent/smtt/sdk/m:z	I
    //   2111: lload 10
    //   2113: lstore 16
    //   2115: iload 5
    //   2117: istore 6
    //   2119: lload 10
    //   2121: lstore 14
    //   2123: aload_0
    //   2124: getfield 255	com/tencent/smtt/sdk/m:r	I
    //   2127: iconst_1
    //   2128: if_icmplt +29 -> 2157
    //   2131: lload 10
    //   2133: lstore 16
    //   2135: iload 5
    //   2137: istore 6
    //   2139: lload 10
    //   2141: lstore 14
    //   2143: aload_0
    //   2144: getfield 390	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   2147: ldc_w 1150
    //   2150: aload_0
    //   2151: getfield 1047	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   2154: invokevirtual 1153	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2157: lload 10
    //   2159: lstore 16
    //   2161: iload 5
    //   2163: istore 6
    //   2165: lload 10
    //   2167: lstore 14
    //   2169: aload_0
    //   2170: getfield 390	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   2173: invokevirtual 868	java/net/HttpURLConnection:getResponseCode	()I
    //   2176: istore_3
    //   2177: lload 10
    //   2179: lstore 16
    //   2181: iload 5
    //   2183: istore 6
    //   2185: lload 10
    //   2187: lstore 14
    //   2189: ldc_w 271
    //   2192: new 115	java/lang/StringBuilder
    //   2195: dup
    //   2196: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   2199: ldc_w 1155
    //   2202: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: iload_3
    //   2206: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2209: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2212: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2215: lload 10
    //   2217: lstore 16
    //   2219: iload 5
    //   2221: istore 6
    //   2223: lload 10
    //   2225: lstore 14
    //   2227: aload_0
    //   2228: getfield 108	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2231: iload_3
    //   2232: invokevirtual 1158	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   2235: iload_1
    //   2236: ifne +166 -> 2402
    //   2239: lload 10
    //   2241: lstore 16
    //   2243: iload 5
    //   2245: istore 6
    //   2247: lload 10
    //   2249: lstore 14
    //   2251: aload_0
    //   2252: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2255: invokestatic 204	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   2258: ifne +144 -> 2402
    //   2261: lload 10
    //   2263: lstore 16
    //   2265: iload 5
    //   2267: istore 6
    //   2269: lload 10
    //   2271: lstore 14
    //   2273: aload_0
    //   2274: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2277: invokestatic 761	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2280: iconst_3
    //   2281: if_icmpne +25 -> 2306
    //   2284: lload 10
    //   2286: lstore 16
    //   2288: iload 5
    //   2290: istore 6
    //   2292: lload 10
    //   2294: lstore 14
    //   2296: aload_0
    //   2297: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2300: invokestatic 761	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2303: ifne +99 -> 2402
    //   2306: lload 10
    //   2308: lstore 16
    //   2310: iload 5
    //   2312: istore 6
    //   2314: lload 10
    //   2316: lstore 14
    //   2318: invokestatic 1161	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2321: ifne +81 -> 2402
    //   2324: lload 10
    //   2326: lstore 16
    //   2328: iload 5
    //   2330: istore 6
    //   2332: lload 10
    //   2334: lstore 14
    //   2336: aload_0
    //   2337: invokevirtual 1162	com/tencent/smtt/sdk/m:b	()V
    //   2340: lload 10
    //   2342: lstore 16
    //   2344: iload 5
    //   2346: istore 6
    //   2348: lload 10
    //   2350: lstore 14
    //   2352: getstatic 605	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   2355: ifnull +25 -> 2380
    //   2358: lload 10
    //   2360: lstore 16
    //   2362: iload 5
    //   2364: istore 6
    //   2366: lload 10
    //   2368: lstore 14
    //   2370: getstatic 605	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   2373: bipush 111
    //   2375: invokeinterface 610 2 0
    //   2380: lload 10
    //   2382: lstore 16
    //   2384: iload 5
    //   2386: istore 6
    //   2388: lload 10
    //   2390: lstore 14
    //   2392: ldc_w 271
    //   2395: ldc_w 1164
    //   2398: iconst_0
    //   2399: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2402: lload 10
    //   2404: lstore 16
    //   2406: iload 5
    //   2408: istore 6
    //   2410: lload 10
    //   2412: lstore 14
    //   2414: aload_0
    //   2415: getfield 730	com/tencent/smtt/sdk/m:t	Z
    //   2418: ifeq +591 -> 3009
    //   2421: lload 10
    //   2423: lstore 16
    //   2425: iload 5
    //   2427: istore 6
    //   2429: lload 10
    //   2431: lstore 14
    //   2433: aload_0
    //   2434: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2437: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2440: sipush -309
    //   2443: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2446: iload 5
    //   2448: istore 6
    //   2450: iload_1
    //   2451: ifne -1827 -> 624
    //   2454: aload_0
    //   2455: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2458: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2461: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2464: ldc_w 1082
    //   2467: lload 10
    //   2469: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2472: invokeinterface 593 3 0
    //   2477: pop
    //   2478: aload_0
    //   2479: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2482: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2485: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2488: iload 5
    //   2490: istore 6
    //   2492: goto -1868 -> 624
    //   2495: lload 10
    //   2497: lstore 16
    //   2499: iload 5
    //   2501: istore 6
    //   2503: lload 10
    //   2505: lstore 14
    //   2507: aload_0
    //   2508: getfield 1047	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   2511: astore 28
    //   2513: goto -885 -> 1628
    //   2516: lload 10
    //   2518: lstore 16
    //   2520: iload 5
    //   2522: istore 6
    //   2524: lload 10
    //   2526: lstore 14
    //   2528: ldc_w 271
    //   2531: new 115	java/lang/StringBuilder
    //   2534: dup
    //   2535: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   2538: ldc_w 1166
    //   2541: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: lload 12
    //   2546: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2549: ldc_w 1168
    //   2552: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2555: aload_0
    //   2556: getfield 724	com/tencent/smtt/sdk/m:n	J
    //   2559: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2562: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2565: iconst_1
    //   2566: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2569: lload 10
    //   2571: lstore 16
    //   2573: iload 5
    //   2575: istore 6
    //   2577: lload 10
    //   2579: lstore 14
    //   2581: ldc_w 271
    //   2584: new 115	java/lang/StringBuilder
    //   2587: dup
    //   2588: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   2591: ldc_w 1166
    //   2594: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2597: lload 12
    //   2599: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2602: ldc_w 1168
    //   2605: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2608: aload_0
    //   2609: getfield 724	com/tencent/smtt/sdk/m:n	J
    //   2612: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2615: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2618: invokestatic 1171	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2621: pop
    //   2622: lload 10
    //   2624: lstore 16
    //   2626: iload 5
    //   2628: istore 6
    //   2630: lload 10
    //   2632: lstore 14
    //   2634: aload_0
    //   2635: getfield 390	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   2638: ldc_w 1141
    //   2641: new 115	java/lang/StringBuilder
    //   2644: dup
    //   2645: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   2648: ldc_w 1143
    //   2651: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2654: lload 12
    //   2656: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2659: ldc_w 1145
    //   2662: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2665: aload_0
    //   2666: getfield 724	com/tencent/smtt/sdk/m:n	J
    //   2669: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2672: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2675: invokevirtual 407	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2678: goto -727 -> 1951
    //   2681: astore 28
    //   2683: iload 6
    //   2685: istore 7
    //   2687: lload 16
    //   2689: lstore 14
    //   2691: aload 28
    //   2693: instanceof 1173
    //   2696: ifeq +4193 -> 6889
    //   2699: iload_1
    //   2700: ifne +4189 -> 6889
    //   2703: lload 16
    //   2705: lstore 14
    //   2707: aload_0
    //   2708: getfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   2711: ifnull +4178 -> 6889
    //   2714: lload 16
    //   2716: lstore 14
    //   2718: aload_0
    //   2719: iconst_0
    //   2720: invokevirtual 1175	com/tencent/smtt/sdk/m:b	(Z)Z
    //   2723: ifeq +4166 -> 6889
    //   2726: lload 16
    //   2728: lstore 14
    //   2730: ldc_w 271
    //   2733: new 115	java/lang/StringBuilder
    //   2736: dup
    //   2737: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   2740: ldc_w 1177
    //   2743: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2746: aload_0
    //   2747: getfield 726	com/tencent/smtt/sdk/m:k	Ljava/lang/String;
    //   2750: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2753: ldc_w 1179
    //   2756: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2759: aload 28
    //   2761: invokevirtual 429	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2764: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2767: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2770: invokestatic 384	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2773: lload 16
    //   2775: lstore 14
    //   2777: aload_0
    //   2778: bipush 125
    //   2780: aconst_null
    //   2781: iconst_1
    //   2782: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   2785: lload 16
    //   2787: lstore 14
    //   2789: aload_0
    //   2790: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2793: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2796: sipush -316
    //   2799: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2802: lload 16
    //   2804: lstore 12
    //   2806: iload 7
    //   2808: istore 5
    //   2810: iload_1
    //   2811: ifne -2202 -> 609
    //   2814: aload_0
    //   2815: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2818: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2821: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2824: ldc_w 1082
    //   2827: lload 16
    //   2829: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2832: invokeinterface 593 3 0
    //   2837: pop
    //   2838: aload_0
    //   2839: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2842: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2845: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2848: lload 16
    //   2850: lstore 12
    //   2852: iload 7
    //   2854: istore 5
    //   2856: goto -2247 -> 609
    //   2859: iconst_1
    //   2860: istore_3
    //   2861: goto -883 -> 1978
    //   2864: lload 10
    //   2866: lstore 16
    //   2868: iload 5
    //   2870: istore 6
    //   2872: lload 10
    //   2874: lstore 14
    //   2876: iload_3
    //   2877: aload_0
    //   2878: getfield 170	com/tencent/smtt/sdk/m:z	I
    //   2881: if_icmpne +27 -> 2908
    //   2884: lload 10
    //   2886: lstore 16
    //   2888: iload 5
    //   2890: istore 6
    //   2892: lload 10
    //   2894: lstore 14
    //   2896: aload 28
    //   2898: aload_0
    //   2899: getfield 168	com/tencent/smtt/sdk/m:y	Ljava/lang/String;
    //   2902: invokevirtual 463	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2905: ifne -794 -> 2111
    //   2908: lload 10
    //   2910: lstore 16
    //   2912: iload 5
    //   2914: istore 6
    //   2916: lload 10
    //   2918: lstore 14
    //   2920: aload_0
    //   2921: getfield 108	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2924: iconst_0
    //   2925: invokevirtual 770	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   2928: lload 10
    //   2930: lstore 16
    //   2932: iload 5
    //   2934: istore 6
    //   2936: lload 10
    //   2938: lstore 14
    //   2940: aload_0
    //   2941: aload 28
    //   2943: putfield 168	com/tencent/smtt/sdk/m:y	Ljava/lang/String;
    //   2946: lload 10
    //   2948: lstore 16
    //   2950: iload 5
    //   2952: istore 6
    //   2954: lload 10
    //   2956: lstore 14
    //   2958: aload_0
    //   2959: iload_3
    //   2960: putfield 170	com/tencent/smtt/sdk/m:z	I
    //   2963: goto -852 -> 2111
    //   2966: astore 28
    //   2968: iload_1
    //   2969: ifne +37 -> 3006
    //   2972: aload_0
    //   2973: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2976: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2979: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2982: ldc_w 1082
    //   2985: lload 14
    //   2987: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2990: invokeinterface 593 3 0
    //   2995: pop
    //   2996: aload_0
    //   2997: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3000: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3003: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3006: aload 28
    //   3008: athrow
    //   3009: iload_3
    //   3010: sipush 200
    //   3013: if_icmpeq +10 -> 3023
    //   3016: iload_3
    //   3017: sipush 206
    //   3020: if_icmpne +2643 -> 5663
    //   3023: lload 10
    //   3025: lstore 16
    //   3027: iload 5
    //   3029: istore 6
    //   3031: lload 10
    //   3033: lstore 14
    //   3035: aload_0
    //   3036: aload_0
    //   3037: getfield 390	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   3040: invokevirtual 1182	java/net/HttpURLConnection:getContentLength	()I
    //   3043: i2l
    //   3044: lload 12
    //   3046: ladd
    //   3047: putfield 724	com/tencent/smtt/sdk/m:n	J
    //   3050: lload 10
    //   3052: lstore 16
    //   3054: iload 5
    //   3056: istore 6
    //   3058: lload 10
    //   3060: lstore 14
    //   3062: ldc_w 271
    //   3065: new 115	java/lang/StringBuilder
    //   3068: dup
    //   3069: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   3072: ldc_w 1184
    //   3075: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3078: aload_0
    //   3079: getfield 724	com/tencent/smtt/sdk/m:n	J
    //   3082: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3085: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3088: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3091: lload 10
    //   3093: lstore 16
    //   3095: iload 5
    //   3097: istore 6
    //   3099: lload 10
    //   3101: lstore 14
    //   3103: aload_0
    //   3104: getfield 108	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   3107: aload_0
    //   3108: getfield 724	com/tencent/smtt/sdk/m:n	J
    //   3111: invokevirtual 1187	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   3114: lload 10
    //   3116: lstore 16
    //   3118: iload 5
    //   3120: istore 6
    //   3122: lload 10
    //   3124: lstore 14
    //   3126: aload_0
    //   3127: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3130: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3133: getfield 367	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   3136: ldc_w 476
    //   3139: lconst_0
    //   3140: invokeinterface 480 4 0
    //   3145: lstore 18
    //   3147: lload 18
    //   3149: lconst_0
    //   3150: lcmp
    //   3151: ifeq +410 -> 3561
    //   3154: lload 10
    //   3156: lstore 16
    //   3158: iload 5
    //   3160: istore 6
    //   3162: lload 10
    //   3164: lstore 14
    //   3166: aload_0
    //   3167: getfield 724	com/tencent/smtt/sdk/m:n	J
    //   3170: lload 18
    //   3172: lcmp
    //   3173: ifeq +388 -> 3561
    //   3176: lload 10
    //   3178: lstore 16
    //   3180: iload 5
    //   3182: istore 6
    //   3184: lload 10
    //   3186: lstore 14
    //   3188: ldc_w 271
    //   3191: new 115	java/lang/StringBuilder
    //   3194: dup
    //   3195: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   3198: ldc_w 1189
    //   3201: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3204: lload 18
    //   3206: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3209: ldc_w 1191
    //   3212: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3215: aload_0
    //   3216: getfield 724	com/tencent/smtt/sdk/m:n	J
    //   3219: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3222: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3225: iconst_1
    //   3226: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3229: iload_1
    //   3230: ifne +281 -> 3511
    //   3233: lload 10
    //   3235: lstore 16
    //   3237: iload 5
    //   3239: istore 6
    //   3241: lload 10
    //   3243: lstore 14
    //   3245: aload_0
    //   3246: invokespecial 432	com/tencent/smtt/sdk/m:o	()Z
    //   3249: ifne +43 -> 3292
    //   3252: lload 10
    //   3254: lstore 16
    //   3256: iload 5
    //   3258: istore 6
    //   3260: lload 10
    //   3262: lstore 14
    //   3264: invokestatic 1161	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   3267: ifeq +244 -> 3511
    //   3270: lload 10
    //   3272: lstore 16
    //   3274: iload 5
    //   3276: istore 6
    //   3278: lload 10
    //   3280: lstore 14
    //   3282: aload_0
    //   3283: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3286: invokestatic 776	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3289: ifeq +222 -> 3511
    //   3292: lload 10
    //   3294: lstore 16
    //   3296: iload 5
    //   3298: istore 6
    //   3300: lload 10
    //   3302: lstore 14
    //   3304: aload_0
    //   3305: getfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   3308: ifnull +76 -> 3384
    //   3311: lload 10
    //   3313: lstore 16
    //   3315: iload 5
    //   3317: istore 6
    //   3319: lload 10
    //   3321: lstore 14
    //   3323: aload_0
    //   3324: iconst_0
    //   3325: invokevirtual 1175	com/tencent/smtt/sdk/m:b	(Z)Z
    //   3328: istore 7
    //   3330: iload 7
    //   3332: ifeq +52 -> 3384
    //   3335: lload 10
    //   3337: lstore 12
    //   3339: iload_1
    //   3340: ifne -2731 -> 609
    //   3343: aload_0
    //   3344: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3347: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3350: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3353: ldc_w 1082
    //   3356: lload 10
    //   3358: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3361: invokeinterface 593 3 0
    //   3366: pop
    //   3367: aload_0
    //   3368: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3371: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3374: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3377: lload 10
    //   3379: lstore 12
    //   3381: goto -2772 -> 609
    //   3384: lload 10
    //   3386: lstore 16
    //   3388: iload 5
    //   3390: istore 6
    //   3392: lload 10
    //   3394: lstore 14
    //   3396: aload_0
    //   3397: bipush 113
    //   3399: new 115	java/lang/StringBuilder
    //   3402: dup
    //   3403: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   3406: ldc_w 1193
    //   3409: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3412: lload 18
    //   3414: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3417: ldc_w 1191
    //   3420: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3423: aload_0
    //   3424: getfield 724	com/tencent/smtt/sdk/m:n	J
    //   3427: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3430: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3433: iconst_1
    //   3434: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   3437: lload 10
    //   3439: lstore 16
    //   3441: iload 5
    //   3443: istore 6
    //   3445: lload 10
    //   3447: lstore 14
    //   3449: aload_0
    //   3450: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3453: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3456: sipush -310
    //   3459: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3462: iload 5
    //   3464: istore 6
    //   3466: iload_1
    //   3467: ifne -2843 -> 624
    //   3470: aload_0
    //   3471: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3474: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3477: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3480: ldc_w 1082
    //   3483: lload 10
    //   3485: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3488: invokeinterface 593 3 0
    //   3493: pop
    //   3494: aload_0
    //   3495: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3498: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3501: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3504: iload 5
    //   3506: istore 6
    //   3508: goto -2884 -> 624
    //   3511: lload 10
    //   3513: lstore 16
    //   3515: iload 5
    //   3517: istore 6
    //   3519: lload 10
    //   3521: lstore 14
    //   3523: aload_0
    //   3524: bipush 101
    //   3526: ldc_w 1195
    //   3529: iconst_1
    //   3530: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   3533: lload 10
    //   3535: lstore 16
    //   3537: iload 5
    //   3539: istore 6
    //   3541: lload 10
    //   3543: lstore 14
    //   3545: aload_0
    //   3546: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3549: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3552: sipush -304
    //   3555: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3558: goto -96 -> 3462
    //   3561: aconst_null
    //   3562: astore 32
    //   3564: aconst_null
    //   3565: astore 28
    //   3567: aconst_null
    //   3568: astore 30
    //   3570: lload 10
    //   3572: lstore 16
    //   3574: iload 5
    //   3576: istore 6
    //   3578: lload 10
    //   3580: lstore 14
    //   3582: ldc_w 271
    //   3585: ldc_w 1197
    //   3588: invokestatic 278	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3591: aload_0
    //   3592: getfield 390	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   3595: invokevirtual 865	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3598: astore 29
    //   3600: aload 29
    //   3602: ifnull +3691 -> 7293
    //   3605: aload_0
    //   3606: getfield 390	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   3609: invokevirtual 1200	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3612: astore 28
    //   3614: aload 28
    //   3616: ifnull +365 -> 3981
    //   3619: aload 28
    //   3621: ldc_w 1202
    //   3624: invokevirtual 330	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3627: ifeq +354 -> 3981
    //   3630: new 1204	java/util/zip/GZIPInputStream
    //   3633: dup
    //   3634: aload 29
    //   3636: invokespecial 1205	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3639: astore 28
    //   3641: sipush 8192
    //   3644: newarray byte
    //   3646: astore 33
    //   3648: iload_2
    //   3649: ifeq +552 -> 4201
    //   3652: aload_0
    //   3653: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3656: invokestatic 634	com/tencent/smtt/utils/q:b	(Landroid/content/Context;)Z
    //   3659: ifeq +542 -> 4201
    //   3662: new 156	java/io/File
    //   3665: dup
    //   3666: aload_0
    //   3667: getfield 164	com/tencent/smtt/sdk/m:m	Ljava/io/File;
    //   3670: new 115	java/lang/StringBuilder
    //   3673: dup
    //   3674: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   3677: iconst_0
    //   3678: invokestatic 213	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   3681: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3684: ldc_w 377
    //   3687: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3690: ldc_w 641
    //   3693: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3696: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3699: invokespecial 209	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3702: astore 31
    //   3704: aload 31
    //   3706: astore 30
    //   3708: aload 31
    //   3710: invokevirtual 195	java/io/File:exists	()Z
    //   3713: ifeq +13 -> 3726
    //   3716: aload 31
    //   3718: invokevirtual 318	java/io/File:delete	()Z
    //   3721: pop
    //   3722: aload 31
    //   3724: astore 30
    //   3726: ldc_w 271
    //   3729: new 115	java/lang/StringBuilder
    //   3732: dup
    //   3733: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   3736: ldc_w 1207
    //   3739: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3742: aload 30
    //   3744: invokevirtual 295	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3747: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3750: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3753: iconst_1
    //   3754: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3757: new 1209	java/io/FileOutputStream
    //   3760: dup
    //   3761: aload 30
    //   3763: iconst_1
    //   3764: invokespecial 1212	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3767: astore 31
    //   3769: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   3772: lstore 16
    //   3774: iconst_0
    //   3775: istore_3
    //   3776: lload 12
    //   3778: lstore 22
    //   3780: lload 12
    //   3782: lstore 14
    //   3784: iload 5
    //   3786: istore 7
    //   3788: lload 10
    //   3790: lstore 18
    //   3792: iload 5
    //   3794: istore 8
    //   3796: lload 10
    //   3798: lstore 20
    //   3800: aload_0
    //   3801: getfield 730	com/tencent/smtt/sdk/m:t	Z
    //   3804: ifeq +445 -> 4249
    //   3807: iload 5
    //   3809: istore 7
    //   3811: lload 10
    //   3813: lstore 18
    //   3815: iload 5
    //   3817: istore 8
    //   3819: lload 10
    //   3821: lstore 20
    //   3823: ldc_w 271
    //   3826: ldc_w 1214
    //   3829: iconst_1
    //   3830: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3833: iload 5
    //   3835: istore 7
    //   3837: lload 10
    //   3839: lstore 18
    //   3841: iload 5
    //   3843: istore 8
    //   3845: lload 10
    //   3847: lstore 20
    //   3849: aload_0
    //   3850: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3853: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3856: sipush -309
    //   3859: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3862: iload 5
    //   3864: istore 7
    //   3866: iload_3
    //   3867: ifeq +1215 -> 5082
    //   3870: lload 10
    //   3872: lstore 16
    //   3874: iload 7
    //   3876: istore 6
    //   3878: lload 10
    //   3880: lstore 14
    //   3882: aload_0
    //   3883: aload 31
    //   3885: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3888: lload 10
    //   3890: lstore 16
    //   3892: iload 7
    //   3894: istore 6
    //   3896: lload 10
    //   3898: lstore 14
    //   3900: aload_0
    //   3901: aload 28
    //   3903: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3906: lload 10
    //   3908: lstore 16
    //   3910: iload 7
    //   3912: istore 6
    //   3914: lload 10
    //   3916: lstore 14
    //   3918: aload_0
    //   3919: aload 29
    //   3921: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3924: lload 10
    //   3926: lstore 12
    //   3928: iload 7
    //   3930: istore 5
    //   3932: iload_1
    //   3933: ifne -3324 -> 609
    //   3936: aload_0
    //   3937: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3940: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3943: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3946: ldc_w 1082
    //   3949: lload 10
    //   3951: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3954: invokeinterface 593 3 0
    //   3959: pop
    //   3960: aload_0
    //   3961: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3964: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3967: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3970: lload 10
    //   3972: lstore 12
    //   3974: iload 7
    //   3976: istore 5
    //   3978: goto -3369 -> 609
    //   3981: aload 28
    //   3983: ifnull +211 -> 4194
    //   3986: aload 28
    //   3988: ldc_w 1216
    //   3991: invokevirtual 330	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3994: ifeq +200 -> 4194
    //   3997: new 1218	java/util/zip/InflaterInputStream
    //   4000: dup
    //   4001: aload 29
    //   4003: new 1220	java/util/zip/Inflater
    //   4006: dup
    //   4007: iconst_1
    //   4008: invokespecial 1222	java/util/zip/Inflater:<init>	(Z)V
    //   4011: invokespecial 1225	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   4014: astore 28
    //   4016: goto -375 -> 3641
    //   4019: astore 33
    //   4021: aload 29
    //   4023: astore 28
    //   4025: aload 32
    //   4027: astore 31
    //   4029: aload 33
    //   4031: astore 29
    //   4033: iload 5
    //   4035: istore 7
    //   4037: aload 29
    //   4039: invokevirtual 1226	java/io/IOException:printStackTrace	()V
    //   4042: aload 29
    //   4044: instanceof 1228
    //   4047: ifne +11 -> 4058
    //   4050: aload 29
    //   4052: instanceof 1230
    //   4055: ifeq +1178 -> 5233
    //   4058: aload_0
    //   4059: ldc_w 1231
    //   4062: putfield 80	com/tencent/smtt/sdk/m:o	I
    //   4065: aload_0
    //   4066: lconst_0
    //   4067: invokespecial 1233	com/tencent/smtt/sdk/m:a	(J)V
    //   4070: aload_0
    //   4071: bipush 103
    //   4073: aload_0
    //   4074: aload 29
    //   4076: invokespecial 533	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4079: iconst_0
    //   4080: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4083: lload 10
    //   4085: lstore 16
    //   4087: iload 7
    //   4089: istore 6
    //   4091: lload 10
    //   4093: lstore 14
    //   4095: aload_0
    //   4096: aload 31
    //   4098: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4101: lload 10
    //   4103: lstore 16
    //   4105: iload 7
    //   4107: istore 6
    //   4109: lload 10
    //   4111: lstore 14
    //   4113: aload_0
    //   4114: aload 30
    //   4116: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4119: lload 10
    //   4121: lstore 16
    //   4123: iload 7
    //   4125: istore 6
    //   4127: lload 10
    //   4129: lstore 14
    //   4131: aload_0
    //   4132: aload 28
    //   4134: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4137: lload 10
    //   4139: lstore 12
    //   4141: iload 7
    //   4143: istore 5
    //   4145: iload_1
    //   4146: ifne -3537 -> 609
    //   4149: aload_0
    //   4150: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4153: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4156: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4159: ldc_w 1082
    //   4162: lload 10
    //   4164: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4167: invokeinterface 593 3 0
    //   4172: pop
    //   4173: aload_0
    //   4174: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4177: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4180: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4183: lload 10
    //   4185: lstore 12
    //   4187: iload 7
    //   4189: istore 5
    //   4191: goto -3582 -> 609
    //   4194: aload 29
    //   4196: astore 28
    //   4198: goto -557 -> 3641
    //   4201: new 156	java/io/File
    //   4204: dup
    //   4205: aload_0
    //   4206: getfield 141	com/tencent/smtt/sdk/m:l	Ljava/io/File;
    //   4209: ldc_w 450
    //   4212: invokespecial 209	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   4215: astore 30
    //   4217: goto -491 -> 3726
    //   4220: astore 30
    //   4222: aload 29
    //   4224: astore 31
    //   4226: iload 5
    //   4228: istore 7
    //   4230: aload 30
    //   4232: astore 29
    //   4234: aload 28
    //   4236: astore 30
    //   4238: aload 31
    //   4240: astore 28
    //   4242: aload 32
    //   4244: astore 31
    //   4246: goto -209 -> 4037
    //   4249: iload 5
    //   4251: istore 7
    //   4253: lload 10
    //   4255: lstore 18
    //   4257: iload 5
    //   4259: istore 8
    //   4261: lload 10
    //   4263: lstore 20
    //   4265: aload 28
    //   4267: aload 33
    //   4269: iconst_0
    //   4270: sipush 8192
    //   4273: invokevirtual 1239	java/io/InputStream:read	([BII)I
    //   4276: istore 4
    //   4278: iload 4
    //   4280: ifgt +203 -> 4483
    //   4283: iload 5
    //   4285: istore 7
    //   4287: lload 10
    //   4289: lstore 18
    //   4291: iload 5
    //   4293: istore 8
    //   4295: lload 10
    //   4297: lstore 20
    //   4299: aload_0
    //   4300: getfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   4303: ifnull +93 -> 4396
    //   4306: iload 5
    //   4308: istore 7
    //   4310: lload 10
    //   4312: lstore 18
    //   4314: iload 5
    //   4316: istore 8
    //   4318: lload 10
    //   4320: lstore 20
    //   4322: aload_0
    //   4323: iconst_1
    //   4324: iload 9
    //   4326: invokespecial 1029	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   4329: ifne +67 -> 4396
    //   4332: iload_1
    //   4333: ifne +36 -> 4369
    //   4336: iload 5
    //   4338: istore 7
    //   4340: lload 10
    //   4342: lstore 18
    //   4344: iload 5
    //   4346: istore 8
    //   4348: lload 10
    //   4350: lstore 20
    //   4352: aload_0
    //   4353: iconst_0
    //   4354: invokevirtual 1175	com/tencent/smtt/sdk/m:b	(Z)Z
    //   4357: ifeq +12 -> 4369
    //   4360: iconst_1
    //   4361: istore_3
    //   4362: iload 5
    //   4364: istore 7
    //   4366: goto -500 -> 3866
    //   4369: iload 5
    //   4371: istore 7
    //   4373: lload 10
    //   4375: lstore 18
    //   4377: iload 5
    //   4379: istore 8
    //   4381: lload 10
    //   4383: lstore 20
    //   4385: aload_0
    //   4386: iconst_1
    //   4387: putfield 732	com/tencent/smtt/sdk/m:u	Z
    //   4390: iconst_0
    //   4391: istore 7
    //   4393: goto -527 -> 3866
    //   4396: iload 5
    //   4398: istore 7
    //   4400: lload 10
    //   4402: lstore 18
    //   4404: iload 5
    //   4406: istore 8
    //   4408: lload 10
    //   4410: lstore 20
    //   4412: aload_0
    //   4413: iconst_1
    //   4414: putfield 732	com/tencent/smtt/sdk/m:u	Z
    //   4417: iload 5
    //   4419: istore 6
    //   4421: iload 5
    //   4423: istore 7
    //   4425: lload 10
    //   4427: lstore 18
    //   4429: iload 5
    //   4431: istore 8
    //   4433: lload 10
    //   4435: lstore 20
    //   4437: aload_0
    //   4438: getfield 86	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   4441: ifnull +6 -> 4447
    //   4444: iconst_1
    //   4445: istore 6
    //   4447: iload 6
    //   4449: istore 7
    //   4451: lload 10
    //   4453: lstore 18
    //   4455: iload 6
    //   4457: istore 8
    //   4459: lload 10
    //   4461: lstore 20
    //   4463: aload_0
    //   4464: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4467: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4470: sipush -311
    //   4473: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4476: iload 6
    //   4478: istore 7
    //   4480: goto -614 -> 3866
    //   4483: iload 5
    //   4485: istore 7
    //   4487: lload 10
    //   4489: lstore 18
    //   4491: iload 5
    //   4493: istore 8
    //   4495: lload 10
    //   4497: lstore 20
    //   4499: aload 31
    //   4501: aload 33
    //   4503: iconst_0
    //   4504: iload 4
    //   4506: invokevirtual 1243	java/io/FileOutputStream:write	([BII)V
    //   4509: iload 5
    //   4511: istore 7
    //   4513: lload 10
    //   4515: lstore 18
    //   4517: iload 5
    //   4519: istore 8
    //   4521: lload 10
    //   4523: lstore 20
    //   4525: aload 31
    //   4527: invokevirtual 1246	java/io/FileOutputStream:flush	()V
    //   4530: lload 10
    //   4532: lstore 12
    //   4534: iload_1
    //   4535: ifne +292 -> 4827
    //   4538: lload 10
    //   4540: iload 4
    //   4542: i2l
    //   4543: ladd
    //   4544: lstore 10
    //   4546: lload 10
    //   4548: lload 26
    //   4550: lcmp
    //   4551: iflt +120 -> 4671
    //   4554: iload 5
    //   4556: istore 7
    //   4558: lload 10
    //   4560: lstore 18
    //   4562: iload 5
    //   4564: istore 8
    //   4566: lload 10
    //   4568: lstore 20
    //   4570: ldc_w 271
    //   4573: ldc_w 1123
    //   4576: iconst_1
    //   4577: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4580: iload 5
    //   4582: istore 7
    //   4584: lload 10
    //   4586: lstore 18
    //   4588: iload 5
    //   4590: istore 8
    //   4592: lload 10
    //   4594: lstore 20
    //   4596: aload_0
    //   4597: bipush 112
    //   4599: new 115	java/lang/StringBuilder
    //   4602: dup
    //   4603: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   4606: ldc_w 1248
    //   4609: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4612: lload 10
    //   4614: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4617: ldc_w 1250
    //   4620: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4623: lload 26
    //   4625: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4628: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4631: iconst_1
    //   4632: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4635: iload 5
    //   4637: istore 7
    //   4639: lload 10
    //   4641: lstore 18
    //   4643: iload 5
    //   4645: istore 8
    //   4647: lload 10
    //   4649: lstore 20
    //   4651: aload_0
    //   4652: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4655: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4658: sipush -307
    //   4661: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4664: iload 5
    //   4666: istore 7
    //   4668: goto -802 -> 3866
    //   4671: lload 10
    //   4673: lstore 12
    //   4675: iload 5
    //   4677: istore 7
    //   4679: lload 10
    //   4681: lstore 18
    //   4683: iload 5
    //   4685: istore 8
    //   4687: lload 10
    //   4689: lstore 20
    //   4691: aload_0
    //   4692: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4695: invokestatic 1117	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   4698: ifne +129 -> 4827
    //   4701: iload 5
    //   4703: istore 7
    //   4705: lload 10
    //   4707: lstore 18
    //   4709: iload 5
    //   4711: istore 8
    //   4713: lload 10
    //   4715: lstore 20
    //   4717: ldc_w 271
    //   4720: ldc_w 1252
    //   4723: iconst_1
    //   4724: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4727: iload 5
    //   4729: istore 7
    //   4731: lload 10
    //   4733: lstore 18
    //   4735: iload 5
    //   4737: istore 8
    //   4739: lload 10
    //   4741: lstore 20
    //   4743: aload_0
    //   4744: bipush 105
    //   4746: new 115	java/lang/StringBuilder
    //   4749: dup
    //   4750: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   4753: ldc_w 1254
    //   4756: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4759: invokestatic 1256	com/tencent/smtt/utils/q:a	()J
    //   4762: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4765: ldc_w 1258
    //   4768: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4771: aload_0
    //   4772: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4775: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4778: invokevirtual 1261	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4781: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4784: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4787: iconst_1
    //   4788: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4791: iload 5
    //   4793: istore 7
    //   4795: lload 10
    //   4797: lstore 18
    //   4799: iload 5
    //   4801: istore 8
    //   4803: lload 10
    //   4805: lstore 20
    //   4807: aload_0
    //   4808: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4811: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4814: sipush -308
    //   4817: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4820: iload 5
    //   4822: istore 7
    //   4824: goto -958 -> 3866
    //   4827: iload 4
    //   4829: i2l
    //   4830: lstore 10
    //   4832: aload_0
    //   4833: lload 24
    //   4835: lload 10
    //   4837: invokespecial 1263	com/tencent/smtt/sdk/m:a	(JJ)J
    //   4840: lstore 24
    //   4842: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   4845: lstore 20
    //   4847: iload 4
    //   4849: i2l
    //   4850: lload 22
    //   4852: ladd
    //   4853: lstore 18
    //   4855: lload 20
    //   4857: lload 16
    //   4859: lsub
    //   4860: ldc2_w 1264
    //   4863: lcmp
    //   4864: ifle +2418 -> 7282
    //   4867: ldc_w 271
    //   4870: new 115	java/lang/StringBuilder
    //   4873: dup
    //   4874: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   4877: ldc_w 1267
    //   4880: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4883: lload 18
    //   4885: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4888: ldc_w 1168
    //   4891: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4894: aload_0
    //   4895: getfield 724	com/tencent/smtt/sdk/m:n	J
    //   4898: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4901: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4904: iconst_1
    //   4905: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4908: getstatic 605	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   4911: ifnull +29 -> 4940
    //   4914: lload 18
    //   4916: l2d
    //   4917: aload_0
    //   4918: getfield 724	com/tencent/smtt/sdk/m:n	J
    //   4921: l2d
    //   4922: ddiv
    //   4923: ldc2_w 1268
    //   4926: dmul
    //   4927: d2i
    //   4928: istore 4
    //   4930: getstatic 605	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   4933: iload 4
    //   4935: invokeinterface 1272 2 0
    //   4940: lload 14
    //   4942: lstore 10
    //   4944: iload_1
    //   4945: ifne +114 -> 5059
    //   4948: lload 14
    //   4950: lstore 10
    //   4952: lload 18
    //   4954: lload 14
    //   4956: lsub
    //   4957: ldc2_w 1273
    //   4960: lcmp
    //   4961: ifle +98 -> 5059
    //   4964: aload_0
    //   4965: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4968: invokestatic 204	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4971: ifne +84 -> 5055
    //   4974: aload_0
    //   4975: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4978: invokestatic 761	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4981: iconst_3
    //   4982: if_icmpne +13 -> 4995
    //   4985: aload_0
    //   4986: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4989: invokestatic 761	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4992: ifne +63 -> 5055
    //   4995: invokestatic 1161	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4998: ifne +57 -> 5055
    //   5001: aload_0
    //   5002: invokevirtual 1162	com/tencent/smtt/sdk/m:b	()V
    //   5005: getstatic 605	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   5008: ifnull +13 -> 5021
    //   5011: getstatic 605	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   5014: bipush 111
    //   5016: invokeinterface 610 2 0
    //   5021: ldc_w 271
    //   5024: ldc_w 1276
    //   5027: iconst_0
    //   5028: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   5031: aload_0
    //   5032: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5035: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5038: sipush -304
    //   5041: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5044: lload 12
    //   5046: lstore 10
    //   5048: iload 5
    //   5050: istore 7
    //   5052: goto -1186 -> 3866
    //   5055: lload 18
    //   5057: lstore 10
    //   5059: lload 20
    //   5061: lstore 14
    //   5063: lload 14
    //   5065: lstore 16
    //   5067: lload 10
    //   5069: lstore 14
    //   5071: lload 12
    //   5073: lstore 10
    //   5075: lload 18
    //   5077: lstore 22
    //   5079: goto -1295 -> 3784
    //   5082: iload 7
    //   5084: istore 5
    //   5086: iload 5
    //   5088: istore 6
    //   5090: lload 10
    //   5092: lstore 12
    //   5094: lload 10
    //   5096: lstore 14
    //   5098: aload_0
    //   5099: aload 31
    //   5101: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5104: iload 5
    //   5106: istore 6
    //   5108: lload 10
    //   5110: lstore 12
    //   5112: lload 10
    //   5114: lstore 14
    //   5116: aload_0
    //   5117: aload 28
    //   5119: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5122: iload 5
    //   5124: istore 6
    //   5126: lload 10
    //   5128: lstore 12
    //   5130: lload 10
    //   5132: lstore 14
    //   5134: aload_0
    //   5135: aload 29
    //   5137: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5140: iload 5
    //   5142: istore 6
    //   5144: lload 10
    //   5146: lstore 12
    //   5148: lload 10
    //   5150: lstore 14
    //   5152: aload_0
    //   5153: getfield 732	com/tencent/smtt/sdk/m:u	Z
    //   5156: ifne +28 -> 5184
    //   5159: iload 5
    //   5161: istore 6
    //   5163: lload 10
    //   5165: lstore 12
    //   5167: lload 10
    //   5169: lstore 14
    //   5171: aload_0
    //   5172: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5175: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5178: sipush -319
    //   5181: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5184: iload 5
    //   5186: istore 6
    //   5188: iload_1
    //   5189: ifne -4565 -> 624
    //   5192: aload_0
    //   5193: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5196: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5199: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5202: ldc_w 1082
    //   5205: lload 10
    //   5207: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5210: invokeinterface 593 3 0
    //   5215: pop
    //   5216: aload_0
    //   5217: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5220: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5223: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5226: iload 5
    //   5228: istore 6
    //   5230: goto -4606 -> 624
    //   5233: iload_1
    //   5234: ifne +177 -> 5411
    //   5237: aload_0
    //   5238: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5241: invokestatic 1117	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   5244: ifne +167 -> 5411
    //   5247: aload_0
    //   5248: bipush 105
    //   5250: new 115	java/lang/StringBuilder
    //   5253: dup
    //   5254: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   5257: ldc_w 1254
    //   5260: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5263: invokestatic 1256	com/tencent/smtt/utils/q:a	()J
    //   5266: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5269: ldc_w 1258
    //   5272: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5275: aload_0
    //   5276: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5279: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5282: invokevirtual 1261	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   5285: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5288: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5291: iconst_1
    //   5292: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5295: aload_0
    //   5296: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5299: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5302: sipush -308
    //   5305: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5308: lload 10
    //   5310: lstore 16
    //   5312: iload 7
    //   5314: istore 6
    //   5316: lload 10
    //   5318: lstore 14
    //   5320: aload_0
    //   5321: aload 31
    //   5323: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5326: lload 10
    //   5328: lstore 16
    //   5330: iload 7
    //   5332: istore 6
    //   5334: lload 10
    //   5336: lstore 14
    //   5338: aload_0
    //   5339: aload 30
    //   5341: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5344: lload 10
    //   5346: lstore 16
    //   5348: iload 7
    //   5350: istore 6
    //   5352: lload 10
    //   5354: lstore 14
    //   5356: aload_0
    //   5357: aload 28
    //   5359: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5362: iload 7
    //   5364: istore 6
    //   5366: iload_1
    //   5367: ifne -4743 -> 624
    //   5370: aload_0
    //   5371: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5374: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5377: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5380: ldc_w 1082
    //   5383: lload 10
    //   5385: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5388: invokeinterface 593 3 0
    //   5393: pop
    //   5394: aload_0
    //   5395: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5398: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5401: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5404: iload 7
    //   5406: istore 6
    //   5408: goto -4784 -> 624
    //   5411: aload_0
    //   5412: lconst_0
    //   5413: invokespecial 1233	com/tencent/smtt/sdk/m:a	(J)V
    //   5416: aload_0
    //   5417: invokespecial 1278	com/tencent/smtt/sdk/m:k	()Z
    //   5420: ifne +127 -> 5547
    //   5423: aload_0
    //   5424: bipush 106
    //   5426: aload_0
    //   5427: aload 29
    //   5429: invokespecial 533	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5432: iconst_0
    //   5433: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5436: lload 10
    //   5438: lstore 16
    //   5440: iload 7
    //   5442: istore 6
    //   5444: lload 10
    //   5446: lstore 14
    //   5448: aload_0
    //   5449: aload 31
    //   5451: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5454: lload 10
    //   5456: lstore 16
    //   5458: iload 7
    //   5460: istore 6
    //   5462: lload 10
    //   5464: lstore 14
    //   5466: aload_0
    //   5467: aload 30
    //   5469: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5472: lload 10
    //   5474: lstore 16
    //   5476: iload 7
    //   5478: istore 6
    //   5480: lload 10
    //   5482: lstore 14
    //   5484: aload_0
    //   5485: aload 28
    //   5487: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5490: lload 10
    //   5492: lstore 12
    //   5494: iload 7
    //   5496: istore 5
    //   5498: iload_1
    //   5499: ifne -4890 -> 609
    //   5502: aload_0
    //   5503: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5506: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5509: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5512: ldc_w 1082
    //   5515: lload 10
    //   5517: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5520: invokeinterface 593 3 0
    //   5525: pop
    //   5526: aload_0
    //   5527: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5530: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5533: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5536: lload 10
    //   5538: lstore 12
    //   5540: iload 7
    //   5542: istore 5
    //   5544: goto -4935 -> 609
    //   5547: aload_0
    //   5548: bipush 104
    //   5550: aload_0
    //   5551: aload 29
    //   5553: invokespecial 533	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5556: iconst_0
    //   5557: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5560: goto -124 -> 5436
    //   5563: astore 32
    //   5565: aload 28
    //   5567: astore 29
    //   5569: aload 30
    //   5571: astore 28
    //   5573: iload 7
    //   5575: istore 5
    //   5577: aload 32
    //   5579: astore 30
    //   5581: iload 5
    //   5583: istore 6
    //   5585: lload 10
    //   5587: lstore 12
    //   5589: lload 10
    //   5591: lstore 14
    //   5593: aload_0
    //   5594: aload 31
    //   5596: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5599: iload 5
    //   5601: istore 6
    //   5603: lload 10
    //   5605: lstore 12
    //   5607: lload 10
    //   5609: lstore 14
    //   5611: aload_0
    //   5612: aload 28
    //   5614: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5617: iload 5
    //   5619: istore 6
    //   5621: lload 10
    //   5623: lstore 12
    //   5625: lload 10
    //   5627: lstore 14
    //   5629: aload_0
    //   5630: aload 29
    //   5632: invokespecial 845	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5635: iload 5
    //   5637: istore 6
    //   5639: lload 10
    //   5641: lstore 12
    //   5643: lload 10
    //   5645: lstore 14
    //   5647: aload 30
    //   5649: athrow
    //   5650: astore 28
    //   5652: lload 12
    //   5654: lstore 16
    //   5656: iload 6
    //   5658: istore 7
    //   5660: goto -2973 -> 2687
    //   5663: iload_3
    //   5664: sipush 300
    //   5667: if_icmplt +237 -> 5904
    //   5670: iload_3
    //   5671: sipush 307
    //   5674: if_icmpgt +230 -> 5904
    //   5677: lload 10
    //   5679: lstore 16
    //   5681: iload 5
    //   5683: istore 6
    //   5685: lload 10
    //   5687: lstore 14
    //   5689: aload_0
    //   5690: getfield 390	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   5693: ldc_w 1280
    //   5696: invokevirtual 1284	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5699: astore 28
    //   5701: lload 10
    //   5703: lstore 16
    //   5705: iload 5
    //   5707: istore 6
    //   5709: lload 10
    //   5711: lstore 14
    //   5713: aload 28
    //   5715: invokestatic 875	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5718: ifne +92 -> 5810
    //   5721: lload 10
    //   5723: lstore 16
    //   5725: iload 5
    //   5727: istore 6
    //   5729: lload 10
    //   5731: lstore 14
    //   5733: aload_0
    //   5734: aload 28
    //   5736: putfield 726	com/tencent/smtt/sdk/m:k	Ljava/lang/String;
    //   5739: lload 10
    //   5741: lstore 16
    //   5743: iload 5
    //   5745: istore 6
    //   5747: lload 10
    //   5749: lstore 14
    //   5751: aload_0
    //   5752: aload_0
    //   5753: getfield 720	com/tencent/smtt/sdk/m:s	I
    //   5756: iconst_1
    //   5757: iadd
    //   5758: putfield 720	com/tencent/smtt/sdk/m:s	I
    //   5761: lload 10
    //   5763: lstore 12
    //   5765: iload_1
    //   5766: ifne -5157 -> 609
    //   5769: aload_0
    //   5770: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5773: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5776: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5779: ldc_w 1082
    //   5782: lload 10
    //   5784: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5787: invokeinterface 593 3 0
    //   5792: pop
    //   5793: aload_0
    //   5794: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5797: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5800: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5803: lload 10
    //   5805: lstore 12
    //   5807: goto -5198 -> 609
    //   5810: lload 10
    //   5812: lstore 16
    //   5814: iload 5
    //   5816: istore 6
    //   5818: lload 10
    //   5820: lstore 14
    //   5822: aload_0
    //   5823: bipush 124
    //   5825: aconst_null
    //   5826: iconst_1
    //   5827: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5830: lload 10
    //   5832: lstore 16
    //   5834: iload 5
    //   5836: istore 6
    //   5838: lload 10
    //   5840: lstore 14
    //   5842: aload_0
    //   5843: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5846: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5849: sipush -312
    //   5852: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5855: iload 5
    //   5857: istore 6
    //   5859: iload_1
    //   5860: ifne -5236 -> 624
    //   5863: aload_0
    //   5864: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5867: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5870: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5873: ldc_w 1082
    //   5876: lload 10
    //   5878: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5881: invokeinterface 593 3 0
    //   5886: pop
    //   5887: aload_0
    //   5888: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5891: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5894: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5897: iload 5
    //   5899: istore 6
    //   5901: goto -5277 -> 624
    //   5904: lload 10
    //   5906: lstore 16
    //   5908: iload 5
    //   5910: istore 6
    //   5912: lload 10
    //   5914: lstore 14
    //   5916: aload_0
    //   5917: bipush 102
    //   5919: iload_3
    //   5920: invokestatic 1287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5923: iconst_0
    //   5924: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5927: iload_3
    //   5928: sipush 416
    //   5931: if_icmpne +193 -> 6124
    //   5934: lload 10
    //   5936: lstore 16
    //   5938: iload 5
    //   5940: istore 6
    //   5942: lload 10
    //   5944: lstore 14
    //   5946: aload_0
    //   5947: iconst_1
    //   5948: iload 9
    //   5950: invokespecial 1029	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   5953: ifeq +79 -> 6032
    //   5956: iconst_1
    //   5957: istore 6
    //   5959: iconst_1
    //   5960: istore 5
    //   5962: lload 10
    //   5964: lstore 16
    //   5966: lload 10
    //   5968: lstore 14
    //   5970: aload_0
    //   5971: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5974: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5977: sipush -214
    //   5980: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5983: iload 5
    //   5985: istore 6
    //   5987: iload_1
    //   5988: ifne -5364 -> 624
    //   5991: aload_0
    //   5992: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5995: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5998: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6001: ldc_w 1082
    //   6004: lload 10
    //   6006: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6009: invokeinterface 593 3 0
    //   6014: pop
    //   6015: aload_0
    //   6016: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6019: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6022: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6025: iload 5
    //   6027: istore 6
    //   6029: goto -5405 -> 624
    //   6032: lload 10
    //   6034: lstore 16
    //   6036: iload 5
    //   6038: istore 6
    //   6040: lload 10
    //   6042: lstore 14
    //   6044: aload_0
    //   6045: iconst_0
    //   6046: invokespecial 1031	com/tencent/smtt/sdk/m:e	(Z)Z
    //   6049: pop
    //   6050: lload 10
    //   6052: lstore 16
    //   6054: iload 5
    //   6056: istore 6
    //   6058: lload 10
    //   6060: lstore 14
    //   6062: aload_0
    //   6063: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6066: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6069: sipush -313
    //   6072: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6075: iload 5
    //   6077: istore 6
    //   6079: iload_1
    //   6080: ifne -5456 -> 624
    //   6083: aload_0
    //   6084: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6087: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6090: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6093: ldc_w 1082
    //   6096: lload 10
    //   6098: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6101: invokeinterface 593 3 0
    //   6106: pop
    //   6107: aload_0
    //   6108: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6111: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6114: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6117: iload 5
    //   6119: istore 6
    //   6121: goto -5497 -> 624
    //   6124: iload_3
    //   6125: sipush 403
    //   6128: if_icmpeq +10 -> 6138
    //   6131: iload_3
    //   6132: sipush 406
    //   6135: if_icmpne +100 -> 6235
    //   6138: lload 10
    //   6140: lstore 16
    //   6142: iload 5
    //   6144: istore 6
    //   6146: lload 10
    //   6148: lstore 14
    //   6150: aload_0
    //   6151: getfield 724	com/tencent/smtt/sdk/m:n	J
    //   6154: ldc2_w 721
    //   6157: lcmp
    //   6158: ifne +77 -> 6235
    //   6161: lload 10
    //   6163: lstore 16
    //   6165: iload 5
    //   6167: istore 6
    //   6169: lload 10
    //   6171: lstore 14
    //   6173: aload_0
    //   6174: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6177: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6180: sipush -314
    //   6183: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6186: iload 5
    //   6188: istore 6
    //   6190: iload_1
    //   6191: ifne -5567 -> 624
    //   6194: aload_0
    //   6195: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6198: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6201: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6204: ldc_w 1082
    //   6207: lload 10
    //   6209: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6212: invokeinterface 593 3 0
    //   6217: pop
    //   6218: aload_0
    //   6219: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6222: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6225: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6228: iload 5
    //   6230: istore 6
    //   6232: goto -5608 -> 624
    //   6235: iload_3
    //   6236: sipush 202
    //   6239: if_icmpne +52 -> 6291
    //   6242: lload 10
    //   6244: lstore 12
    //   6246: iload_1
    //   6247: ifne -5638 -> 609
    //   6250: aload_0
    //   6251: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6254: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6257: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6260: ldc_w 1082
    //   6263: lload 10
    //   6265: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6268: invokeinterface 593 3 0
    //   6273: pop
    //   6274: aload_0
    //   6275: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6278: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6281: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6284: lload 10
    //   6286: lstore 12
    //   6288: goto -5679 -> 609
    //   6291: lload 10
    //   6293: lstore 16
    //   6295: iload 5
    //   6297: istore 6
    //   6299: lload 10
    //   6301: lstore 14
    //   6303: aload_0
    //   6304: getfield 255	com/tencent/smtt/sdk/m:r	I
    //   6307: aload_0
    //   6308: getfield 84	com/tencent/smtt/sdk/m:D	I
    //   6311: if_icmpge +181 -> 6492
    //   6314: iload_3
    //   6315: sipush 503
    //   6318: if_icmpne +174 -> 6492
    //   6321: lload 10
    //   6323: lstore 16
    //   6325: iload 5
    //   6327: istore 6
    //   6329: lload 10
    //   6331: lstore 14
    //   6333: aload_0
    //   6334: aload_0
    //   6335: getfield 390	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   6338: ldc_w 1289
    //   6341: invokevirtual 1284	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   6344: invokestatic 1293	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   6347: invokespecial 1233	com/tencent/smtt/sdk/m:a	(J)V
    //   6350: lload 10
    //   6352: lstore 16
    //   6354: iload 5
    //   6356: istore 6
    //   6358: lload 10
    //   6360: lstore 14
    //   6362: aload_0
    //   6363: getfield 730	com/tencent/smtt/sdk/m:t	Z
    //   6366: ifeq +77 -> 6443
    //   6369: lload 10
    //   6371: lstore 16
    //   6373: iload 5
    //   6375: istore 6
    //   6377: lload 10
    //   6379: lstore 14
    //   6381: aload_0
    //   6382: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6385: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6388: sipush -309
    //   6391: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6394: iload 5
    //   6396: istore 6
    //   6398: iload_1
    //   6399: ifne -5775 -> 624
    //   6402: aload_0
    //   6403: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6406: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6409: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6412: ldc_w 1082
    //   6415: lload 10
    //   6417: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6420: invokeinterface 593 3 0
    //   6425: pop
    //   6426: aload_0
    //   6427: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6430: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6433: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6436: iload 5
    //   6438: istore 6
    //   6440: goto -5816 -> 624
    //   6443: lload 10
    //   6445: lstore 12
    //   6447: iload_1
    //   6448: ifne -5839 -> 609
    //   6451: aload_0
    //   6452: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6455: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6458: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6461: ldc_w 1082
    //   6464: lload 10
    //   6466: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6469: invokeinterface 593 3 0
    //   6474: pop
    //   6475: aload_0
    //   6476: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6479: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6482: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6485: lload 10
    //   6487: lstore 12
    //   6489: goto -5880 -> 609
    //   6492: lload 10
    //   6494: lstore 16
    //   6496: iload 5
    //   6498: istore 6
    //   6500: lload 10
    //   6502: lstore 14
    //   6504: aload_0
    //   6505: getfield 255	com/tencent/smtt/sdk/m:r	I
    //   6508: aload_0
    //   6509: getfield 84	com/tencent/smtt/sdk/m:D	I
    //   6512: if_icmpge +190 -> 6702
    //   6515: iload_3
    //   6516: sipush 408
    //   6519: if_icmpeq +24 -> 6543
    //   6522: iload_3
    //   6523: sipush 504
    //   6526: if_icmpeq +17 -> 6543
    //   6529: iload_3
    //   6530: sipush 502
    //   6533: if_icmpeq +10 -> 6543
    //   6536: iload_3
    //   6537: sipush 408
    //   6540: if_icmpne +162 -> 6702
    //   6543: lload 10
    //   6545: lstore 16
    //   6547: iload 5
    //   6549: istore 6
    //   6551: lload 10
    //   6553: lstore 14
    //   6555: aload_0
    //   6556: lconst_0
    //   6557: invokespecial 1233	com/tencent/smtt/sdk/m:a	(J)V
    //   6560: lload 10
    //   6562: lstore 16
    //   6564: iload 5
    //   6566: istore 6
    //   6568: lload 10
    //   6570: lstore 14
    //   6572: aload_0
    //   6573: getfield 730	com/tencent/smtt/sdk/m:t	Z
    //   6576: ifeq +77 -> 6653
    //   6579: lload 10
    //   6581: lstore 16
    //   6583: iload 5
    //   6585: istore 6
    //   6587: lload 10
    //   6589: lstore 14
    //   6591: aload_0
    //   6592: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6595: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6598: sipush -309
    //   6601: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6604: iload 5
    //   6606: istore 6
    //   6608: iload_1
    //   6609: ifne -5985 -> 624
    //   6612: aload_0
    //   6613: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6616: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6619: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6622: ldc_w 1082
    //   6625: lload 10
    //   6627: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6630: invokeinterface 593 3 0
    //   6635: pop
    //   6636: aload_0
    //   6637: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6640: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6643: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6646: iload 5
    //   6648: istore 6
    //   6650: goto -6026 -> 624
    //   6653: lload 10
    //   6655: lstore 12
    //   6657: iload_1
    //   6658: ifne -6049 -> 609
    //   6661: aload_0
    //   6662: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6665: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6668: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6671: ldc_w 1082
    //   6674: lload 10
    //   6676: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6679: invokeinterface 593 3 0
    //   6684: pop
    //   6685: aload_0
    //   6686: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6689: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6692: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6695: lload 10
    //   6697: lstore 12
    //   6699: goto -6090 -> 609
    //   6702: lload 10
    //   6704: lstore 16
    //   6706: iload 5
    //   6708: istore 6
    //   6710: lload 10
    //   6712: lstore 14
    //   6714: aload_0
    //   6715: invokespecial 1135	com/tencent/smtt/sdk/m:l	()J
    //   6718: lconst_0
    //   6719: lcmp
    //   6720: ifgt +95 -> 6815
    //   6723: lload 10
    //   6725: lstore 16
    //   6727: iload 5
    //   6729: istore 6
    //   6731: lload 10
    //   6733: lstore 14
    //   6735: aload_0
    //   6736: getfield 728	com/tencent/smtt/sdk/m:q	Z
    //   6739: ifne +76 -> 6815
    //   6742: iload_3
    //   6743: sipush 410
    //   6746: if_icmpeq +69 -> 6815
    //   6749: lload 10
    //   6751: lstore 16
    //   6753: iload 5
    //   6755: istore 6
    //   6757: lload 10
    //   6759: lstore 14
    //   6761: aload_0
    //   6762: iconst_1
    //   6763: putfield 728	com/tencent/smtt/sdk/m:q	Z
    //   6766: lload 10
    //   6768: lstore 12
    //   6770: iload_1
    //   6771: ifne -6162 -> 609
    //   6774: aload_0
    //   6775: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6778: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6781: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6784: ldc_w 1082
    //   6787: lload 10
    //   6789: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6792: invokeinterface 593 3 0
    //   6797: pop
    //   6798: aload_0
    //   6799: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6802: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6805: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6808: lload 10
    //   6810: lstore 12
    //   6812: goto -6203 -> 609
    //   6815: lload 10
    //   6817: lstore 16
    //   6819: iload 5
    //   6821: istore 6
    //   6823: lload 10
    //   6825: lstore 14
    //   6827: aload_0
    //   6828: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6831: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6834: sipush -315
    //   6837: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6840: iload 5
    //   6842: istore 6
    //   6844: iload_1
    //   6845: ifne -6221 -> 624
    //   6848: aload_0
    //   6849: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6852: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6855: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6858: ldc_w 1082
    //   6861: lload 10
    //   6863: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6866: invokeinterface 593 3 0
    //   6871: pop
    //   6872: aload_0
    //   6873: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6876: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6879: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6882: iload 5
    //   6884: istore 6
    //   6886: goto -6262 -> 624
    //   6889: lload 16
    //   6891: lstore 14
    //   6893: aload 28
    //   6895: invokevirtual 846	java/lang/Throwable:printStackTrace	()V
    //   6898: lload 16
    //   6900: lstore 14
    //   6902: aload_0
    //   6903: lconst_0
    //   6904: invokespecial 1233	com/tencent/smtt/sdk/m:a	(J)V
    //   6907: lload 16
    //   6909: lstore 14
    //   6911: aload_0
    //   6912: bipush 107
    //   6914: aload_0
    //   6915: aload 28
    //   6917: invokespecial 533	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   6920: iconst_0
    //   6921: invokespecial 535	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   6924: lload 16
    //   6926: lstore 14
    //   6928: aload_0
    //   6929: getfield 730	com/tencent/smtt/sdk/m:t	Z
    //   6932: ifeq -4147 -> 2785
    //   6935: lload 16
    //   6937: lstore 14
    //   6939: aload_0
    //   6940: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6943: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6946: sipush -309
    //   6949: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6952: iload 7
    //   6954: istore 6
    //   6956: iload_1
    //   6957: ifne -6333 -> 624
    //   6960: aload_0
    //   6961: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6964: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6967: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6970: ldc_w 1082
    //   6973: lload 16
    //   6975: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6978: invokeinterface 593 3 0
    //   6983: pop
    //   6984: aload_0
    //   6985: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6988: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6991: invokevirtual 600	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6994: iload 7
    //   6996: istore 6
    //   6998: goto -6374 -> 624
    //   7001: aload_0
    //   7002: iconst_1
    //   7003: iload 9
    //   7005: invokespecial 1029	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   7008: istore_1
    //   7009: goto -6288 -> 721
    //   7012: iconst_0
    //   7013: istore_3
    //   7014: goto -6281 -> 733
    //   7017: iconst_2
    //   7018: istore_3
    //   7019: goto -6240 -> 779
    //   7022: aload_0
    //   7023: getfield 108	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   7026: iconst_0
    //   7027: invokevirtual 1094	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   7030: goto -6245 -> 785
    //   7033: aload_0
    //   7034: getfield 96	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   7037: invokestatic 363	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   7040: sipush -318
    //   7043: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   7046: aload_0
    //   7047: iconst_0
    //   7048: invokespecial 1031	com/tencent/smtt/sdk/m:e	(Z)Z
    //   7051: pop
    //   7052: goto -6205 -> 847
    //   7055: aload 28
    //   7057: getfield 367	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   7060: ldc_w 1295
    //   7063: iconst_0
    //   7064: invokeinterface 375 3 0
    //   7069: istore_3
    //   7070: aload 28
    //   7072: getfield 580	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   7075: astore 29
    //   7077: iload_3
    //   7078: iconst_1
    //   7079: iadd
    //   7080: istore_3
    //   7081: aload 29
    //   7083: ldc_w 1295
    //   7086: iload_3
    //   7087: invokestatic 526	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7090: invokeinterface 593 3 0
    //   7095: pop
    //   7096: iload_3
    //   7097: aload 28
    //   7099: invokevirtual 1298	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   7102: if_icmpne -6207 -> 895
    //   7105: aload_0
    //   7106: getfield 108	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   7109: iconst_2
    //   7110: invokevirtual 1148	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   7113: goto -6218 -> 895
    //   7116: iconst_0
    //   7117: istore_3
    //   7118: goto -6206 -> 912
    //   7121: astore 28
    //   7123: goto -4155 -> 2968
    //   7126: astore 30
    //   7128: aconst_null
    //   7129: astore 28
    //   7131: aconst_null
    //   7132: astore 29
    //   7134: aconst_null
    //   7135: astore 31
    //   7137: goto -1556 -> 5581
    //   7140: astore 30
    //   7142: aconst_null
    //   7143: astore 28
    //   7145: aconst_null
    //   7146: astore 31
    //   7148: goto -1567 -> 5581
    //   7151: astore 30
    //   7153: aconst_null
    //   7154: astore 31
    //   7156: goto -1575 -> 5581
    //   7159: astore 30
    //   7161: goto -1580 -> 5581
    //   7164: astore 30
    //   7166: iload 7
    //   7168: istore 5
    //   7170: lload 18
    //   7172: lstore 10
    //   7174: goto -1593 -> 5581
    //   7177: astore 30
    //   7179: lload 12
    //   7181: lstore 10
    //   7183: goto -1602 -> 5581
    //   7186: astore 29
    //   7188: iload 5
    //   7190: istore 7
    //   7192: aload 32
    //   7194: astore 31
    //   7196: goto -3159 -> 4037
    //   7199: astore 30
    //   7201: aload 29
    //   7203: astore 32
    //   7205: iload 5
    //   7207: istore 7
    //   7209: aload 30
    //   7211: astore 29
    //   7213: aload 28
    //   7215: astore 30
    //   7217: aload 32
    //   7219: astore 28
    //   7221: goto -3184 -> 4037
    //   7224: astore 30
    //   7226: lload 20
    //   7228: lstore 10
    //   7230: aload 29
    //   7232: astore 32
    //   7234: iload 8
    //   7236: istore 7
    //   7238: aload 30
    //   7240: astore 29
    //   7242: aload 28
    //   7244: astore 30
    //   7246: aload 32
    //   7248: astore 28
    //   7250: goto -3213 -> 4037
    //   7253: astore 30
    //   7255: aload 29
    //   7257: astore 32
    //   7259: lload 12
    //   7261: lstore 10
    //   7263: iload 5
    //   7265: istore 7
    //   7267: aload 30
    //   7269: astore 29
    //   7271: aload 28
    //   7273: astore 30
    //   7275: aload 32
    //   7277: astore 28
    //   7279: goto -3242 -> 4037
    //   7282: lload 14
    //   7284: lstore 10
    //   7286: lload 16
    //   7288: lstore 14
    //   7290: goto -2227 -> 5063
    //   7293: aconst_null
    //   7294: astore 28
    //   7296: aconst_null
    //   7297: astore 31
    //   7299: goto -2213 -> 5086
    //   7302: lload 12
    //   7304: lstore 10
    //   7306: goto -6033 -> 1273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7309	0	this	m
    //   0	7309	1	paramBoolean1	boolean
    //   0	7309	2	paramBoolean2	boolean
    //   54	7064	3	i1	int
    //   4276	658	4	i2	int
    //   603	6661	5	bool1	boolean
    //   460	6537	6	bool2	boolean
    //   2685	4581	7	bool3	boolean
    //   3794	3441	8	bool4	boolean
    //   71	6933	9	bool5	boolean
    //   481	6824	10	l1	long
    //   607	6696	12	l2	long
    //   1125	6164	14	l3	long
    //   1117	6170	16	l4	long
    //   3145	4026	18	l5	long
    //   3798	3429	20	l6	long
    //   3778	1300	22	l7	long
    //   1105	3736	24	l8	long
    //   457	4167	26	l9	long
    //   145	2367	28	localObject1	Object
    //   2681	261	28	localThrowable1	Throwable
    //   2966	41	28	localObject2	Object
    //   3565	2048	28	localObject3	Object
    //   5650	1	28	localThrowable2	Throwable
    //   5699	1399	28	str	String
    //   7121	1	28	localObject4	Object
    //   7129	166	28	localObject5	Object
    //   3598	3535	29	localObject6	Object
    //   7186	16	29	localIOException1	IOException
    //   7211	59	29	localIOException2	IOException
    //   3568	648	30	localObject7	Object
    //   4220	11	30	localIOException3	IOException
    //   4236	1412	30	localObject8	Object
    //   7126	1	30	localObject9	Object
    //   7140	1	30	localObject10	Object
    //   7151	1	30	localObject11	Object
    //   7159	1	30	localObject12	Object
    //   7164	1	30	localObject13	Object
    //   7177	1	30	localObject14	Object
    //   7199	11	30	localIOException4	IOException
    //   7215	1	30	localObject15	Object
    //   7224	15	30	localIOException5	IOException
    //   7244	1	30	localObject16	Object
    //   7253	15	30	localIOException6	IOException
    //   7273	1	30	localObject17	Object
    //   3702	3596	31	localObject18	Object
    //   3562	681	32	localObject19	Object
    //   5563	1630	32	localObject20	Object
    //   7203	73	32	localObject21	Object
    //   3646	1	33	arrayOfByte	byte[]
    //   4019	483	33	localIOException7	IOException
    // Exception table:
    //   from	to	target	type
    //   1127	1156	2681	java/lang/Throwable
    //   1168	1177	2681	java/lang/Throwable
    //   1189	1213	2681	java/lang/Throwable
    //   1225	1248	2681	java/lang/Throwable
    //   1260	1270	2681	java/lang/Throwable
    //   1423	1450	2681	java/lang/Throwable
    //   1470	1480	2681	java/lang/Throwable
    //   1492	1500	2681	java/lang/Throwable
    //   1512	1525	2681	java/lang/Throwable
    //   1586	1591	2681	java/lang/Throwable
    //   1603	1610	2681	java/lang/Throwable
    //   1622	1628	2681	java/lang/Throwable
    //   1640	1681	2681	java/lang/Throwable
    //   1693	1705	2681	java/lang/Throwable
    //   1717	1726	2681	java/lang/Throwable
    //   1738	1744	2681	java/lang/Throwable
    //   1756	1762	2681	java/lang/Throwable
    //   1777	1784	2681	java/lang/Throwable
    //   1796	1802	2681	java/lang/Throwable
    //   1814	1841	2681	java/lang/Throwable
    //   1853	1862	2681	java/lang/Throwable
    //   1874	1902	2681	java/lang/Throwable
    //   1914	1951	2681	java/lang/Throwable
    //   1963	1969	2681	java/lang/Throwable
    //   1990	1996	2681	java/lang/Throwable
    //   2008	2016	2681	java/lang/Throwable
    //   2028	2037	2681	java/lang/Throwable
    //   2049	2056	2681	java/lang/Throwable
    //   2068	2076	2681	java/lang/Throwable
    //   2088	2094	2681	java/lang/Throwable
    //   2106	2111	2681	java/lang/Throwable
    //   2123	2131	2681	java/lang/Throwable
    //   2143	2157	2681	java/lang/Throwable
    //   2169	2177	2681	java/lang/Throwable
    //   2189	2215	2681	java/lang/Throwable
    //   2227	2235	2681	java/lang/Throwable
    //   2251	2261	2681	java/lang/Throwable
    //   2273	2284	2681	java/lang/Throwable
    //   2296	2306	2681	java/lang/Throwable
    //   2318	2324	2681	java/lang/Throwable
    //   2336	2340	2681	java/lang/Throwable
    //   2352	2358	2681	java/lang/Throwable
    //   2370	2380	2681	java/lang/Throwable
    //   2392	2402	2681	java/lang/Throwable
    //   2414	2421	2681	java/lang/Throwable
    //   2433	2446	2681	java/lang/Throwable
    //   2507	2513	2681	java/lang/Throwable
    //   2528	2569	2681	java/lang/Throwable
    //   2581	2622	2681	java/lang/Throwable
    //   2634	2678	2681	java/lang/Throwable
    //   2876	2884	2681	java/lang/Throwable
    //   2896	2908	2681	java/lang/Throwable
    //   2920	2928	2681	java/lang/Throwable
    //   2940	2946	2681	java/lang/Throwable
    //   2958	2963	2681	java/lang/Throwable
    //   3035	3050	2681	java/lang/Throwable
    //   3062	3091	2681	java/lang/Throwable
    //   3103	3114	2681	java/lang/Throwable
    //   3126	3147	2681	java/lang/Throwable
    //   3166	3176	2681	java/lang/Throwable
    //   3188	3229	2681	java/lang/Throwable
    //   3245	3252	2681	java/lang/Throwable
    //   3264	3270	2681	java/lang/Throwable
    //   3282	3292	2681	java/lang/Throwable
    //   3304	3311	2681	java/lang/Throwable
    //   3323	3330	2681	java/lang/Throwable
    //   3396	3437	2681	java/lang/Throwable
    //   3449	3462	2681	java/lang/Throwable
    //   3523	3533	2681	java/lang/Throwable
    //   3545	3558	2681	java/lang/Throwable
    //   3582	3591	2681	java/lang/Throwable
    //   3882	3888	2681	java/lang/Throwable
    //   3900	3906	2681	java/lang/Throwable
    //   3918	3924	2681	java/lang/Throwable
    //   4095	4101	2681	java/lang/Throwable
    //   4113	4119	2681	java/lang/Throwable
    //   4131	4137	2681	java/lang/Throwable
    //   5320	5326	2681	java/lang/Throwable
    //   5338	5344	2681	java/lang/Throwable
    //   5356	5362	2681	java/lang/Throwable
    //   5448	5454	2681	java/lang/Throwable
    //   5466	5472	2681	java/lang/Throwable
    //   5484	5490	2681	java/lang/Throwable
    //   5689	5701	2681	java/lang/Throwable
    //   5713	5721	2681	java/lang/Throwable
    //   5733	5739	2681	java/lang/Throwable
    //   5751	5761	2681	java/lang/Throwable
    //   5822	5830	2681	java/lang/Throwable
    //   5842	5855	2681	java/lang/Throwable
    //   5916	5927	2681	java/lang/Throwable
    //   5946	5956	2681	java/lang/Throwable
    //   5970	5983	2681	java/lang/Throwable
    //   6044	6050	2681	java/lang/Throwable
    //   6062	6075	2681	java/lang/Throwable
    //   6150	6161	2681	java/lang/Throwable
    //   6173	6186	2681	java/lang/Throwable
    //   6303	6314	2681	java/lang/Throwable
    //   6333	6350	2681	java/lang/Throwable
    //   6362	6369	2681	java/lang/Throwable
    //   6381	6394	2681	java/lang/Throwable
    //   6504	6515	2681	java/lang/Throwable
    //   6555	6560	2681	java/lang/Throwable
    //   6572	6579	2681	java/lang/Throwable
    //   6591	6604	2681	java/lang/Throwable
    //   6714	6723	2681	java/lang/Throwable
    //   6735	6742	2681	java/lang/Throwable
    //   6761	6766	2681	java/lang/Throwable
    //   6827	6840	2681	java/lang/Throwable
    //   1127	1156	2966	finally
    //   1168	1177	2966	finally
    //   1189	1213	2966	finally
    //   1225	1248	2966	finally
    //   1260	1270	2966	finally
    //   1423	1450	2966	finally
    //   1470	1480	2966	finally
    //   1492	1500	2966	finally
    //   1512	1525	2966	finally
    //   1586	1591	2966	finally
    //   1603	1610	2966	finally
    //   1622	1628	2966	finally
    //   1640	1681	2966	finally
    //   1693	1705	2966	finally
    //   1717	1726	2966	finally
    //   1738	1744	2966	finally
    //   1756	1762	2966	finally
    //   1777	1784	2966	finally
    //   1796	1802	2966	finally
    //   1814	1841	2966	finally
    //   1853	1862	2966	finally
    //   1874	1902	2966	finally
    //   1914	1951	2966	finally
    //   1963	1969	2966	finally
    //   1990	1996	2966	finally
    //   2008	2016	2966	finally
    //   2028	2037	2966	finally
    //   2049	2056	2966	finally
    //   2068	2076	2966	finally
    //   2088	2094	2966	finally
    //   2106	2111	2966	finally
    //   2123	2131	2966	finally
    //   2143	2157	2966	finally
    //   2169	2177	2966	finally
    //   2189	2215	2966	finally
    //   2227	2235	2966	finally
    //   2251	2261	2966	finally
    //   2273	2284	2966	finally
    //   2296	2306	2966	finally
    //   2318	2324	2966	finally
    //   2336	2340	2966	finally
    //   2352	2358	2966	finally
    //   2370	2380	2966	finally
    //   2392	2402	2966	finally
    //   2414	2421	2966	finally
    //   2433	2446	2966	finally
    //   2507	2513	2966	finally
    //   2528	2569	2966	finally
    //   2581	2622	2966	finally
    //   2634	2678	2966	finally
    //   2691	2699	2966	finally
    //   2707	2714	2966	finally
    //   2718	2726	2966	finally
    //   2730	2773	2966	finally
    //   2777	2785	2966	finally
    //   2789	2802	2966	finally
    //   2876	2884	2966	finally
    //   2896	2908	2966	finally
    //   2920	2928	2966	finally
    //   2940	2946	2966	finally
    //   2958	2963	2966	finally
    //   3035	3050	2966	finally
    //   3062	3091	2966	finally
    //   3103	3114	2966	finally
    //   3126	3147	2966	finally
    //   3166	3176	2966	finally
    //   3188	3229	2966	finally
    //   3245	3252	2966	finally
    //   3264	3270	2966	finally
    //   3282	3292	2966	finally
    //   3304	3311	2966	finally
    //   3323	3330	2966	finally
    //   3396	3437	2966	finally
    //   3449	3462	2966	finally
    //   3523	3533	2966	finally
    //   3545	3558	2966	finally
    //   3582	3591	2966	finally
    //   3882	3888	2966	finally
    //   3900	3906	2966	finally
    //   3918	3924	2966	finally
    //   4095	4101	2966	finally
    //   4113	4119	2966	finally
    //   4131	4137	2966	finally
    //   5320	5326	2966	finally
    //   5338	5344	2966	finally
    //   5356	5362	2966	finally
    //   5448	5454	2966	finally
    //   5466	5472	2966	finally
    //   5484	5490	2966	finally
    //   5689	5701	2966	finally
    //   5713	5721	2966	finally
    //   5733	5739	2966	finally
    //   5751	5761	2966	finally
    //   5822	5830	2966	finally
    //   5842	5855	2966	finally
    //   5916	5927	2966	finally
    //   5946	5956	2966	finally
    //   5970	5983	2966	finally
    //   6044	6050	2966	finally
    //   6062	6075	2966	finally
    //   6150	6161	2966	finally
    //   6173	6186	2966	finally
    //   6303	6314	2966	finally
    //   6333	6350	2966	finally
    //   6362	6369	2966	finally
    //   6381	6394	2966	finally
    //   6504	6515	2966	finally
    //   6555	6560	2966	finally
    //   6572	6579	2966	finally
    //   6591	6604	2966	finally
    //   6714	6723	2966	finally
    //   6735	6742	2966	finally
    //   6761	6766	2966	finally
    //   6827	6840	2966	finally
    //   6893	6898	2966	finally
    //   6902	6907	2966	finally
    //   6911	6924	2966	finally
    //   6928	6935	2966	finally
    //   6939	6952	2966	finally
    //   3605	3614	4019	java/io/IOException
    //   3619	3641	4019	java/io/IOException
    //   3986	4016	4019	java/io/IOException
    //   3641	3648	4220	java/io/IOException
    //   3652	3704	4220	java/io/IOException
    //   3708	3722	4220	java/io/IOException
    //   3726	3769	4220	java/io/IOException
    //   4201	4217	4220	java/io/IOException
    //   4037	4058	5563	finally
    //   4058	4083	5563	finally
    //   5237	5308	5563	finally
    //   5411	5436	5563	finally
    //   5547	5560	5563	finally
    //   1285	1295	5650	java/lang/Throwable
    //   1307	1317	5650	java/lang/Throwable
    //   1329	1337	5650	java/lang/Throwable
    //   1349	1362	5650	java/lang/Throwable
    //   5098	5104	5650	java/lang/Throwable
    //   5116	5122	5650	java/lang/Throwable
    //   5134	5140	5650	java/lang/Throwable
    //   5152	5159	5650	java/lang/Throwable
    //   5171	5184	5650	java/lang/Throwable
    //   5593	5599	5650	java/lang/Throwable
    //   5611	5617	5650	java/lang/Throwable
    //   5629	5635	5650	java/lang/Throwable
    //   5647	5650	5650	java/lang/Throwable
    //   1285	1295	7121	finally
    //   1307	1317	7121	finally
    //   1329	1337	7121	finally
    //   1349	1362	7121	finally
    //   5098	5104	7121	finally
    //   5116	5122	7121	finally
    //   5134	5140	7121	finally
    //   5152	5159	7121	finally
    //   5171	5184	7121	finally
    //   5593	5599	7121	finally
    //   5611	5617	7121	finally
    //   5629	5635	7121	finally
    //   5647	5650	7121	finally
    //   3591	3600	7126	finally
    //   3605	3614	7140	finally
    //   3619	3641	7140	finally
    //   3986	4016	7140	finally
    //   3641	3648	7151	finally
    //   3652	3704	7151	finally
    //   3708	3722	7151	finally
    //   3726	3769	7151	finally
    //   4201	4217	7151	finally
    //   3769	3774	7159	finally
    //   3800	3807	7164	finally
    //   3823	3833	7164	finally
    //   3849	3862	7164	finally
    //   4265	4278	7164	finally
    //   4299	4306	7164	finally
    //   4322	4332	7164	finally
    //   4352	4360	7164	finally
    //   4385	4390	7164	finally
    //   4412	4417	7164	finally
    //   4437	4444	7164	finally
    //   4463	4476	7164	finally
    //   4499	4509	7164	finally
    //   4525	4530	7164	finally
    //   4570	4580	7164	finally
    //   4596	4635	7164	finally
    //   4651	4664	7164	finally
    //   4691	4701	7164	finally
    //   4717	4727	7164	finally
    //   4743	4791	7164	finally
    //   4807	4820	7164	finally
    //   4832	4847	7177	finally
    //   4867	4940	7177	finally
    //   4964	4995	7177	finally
    //   4995	5021	7177	finally
    //   5021	5044	7177	finally
    //   3591	3600	7186	java/io/IOException
    //   3769	3774	7199	java/io/IOException
    //   3800	3807	7224	java/io/IOException
    //   3823	3833	7224	java/io/IOException
    //   3849	3862	7224	java/io/IOException
    //   4265	4278	7224	java/io/IOException
    //   4299	4306	7224	java/io/IOException
    //   4322	4332	7224	java/io/IOException
    //   4352	4360	7224	java/io/IOException
    //   4385	4390	7224	java/io/IOException
    //   4412	4417	7224	java/io/IOException
    //   4437	4444	7224	java/io/IOException
    //   4463	4476	7224	java/io/IOException
    //   4499	4509	7224	java/io/IOException
    //   4525	4530	7224	java/io/IOException
    //   4570	4580	7224	java/io/IOException
    //   4596	4635	7224	java/io/IOException
    //   4651	4664	7224	java/io/IOException
    //   4691	4701	7224	java/io/IOException
    //   4717	4727	7224	java/io/IOException
    //   4743	4791	7224	java/io/IOException
    //   4807	4820	7224	java/io/IOException
    //   4832	4847	7253	java/io/IOException
    //   4867	4940	7253	java/io/IOException
    //   4964	4995	7253	java/io/IOException
    //   4995	5021	7253	java/io/IOException
    //   5021	5044	7253	java/io/IOException
  }
  
  public boolean b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!o()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.h)))) {}
    while ((this.b == null) || (this.c < 0) || (this.c >= this.b.length)) {
      return false;
    }
    String[] arrayOfString = this.b;
    int i1 = this.c;
    this.c = (i1 + 1);
    this.k = arrayOfString[i1];
    this.r = 0;
    this.s = 0;
    this.n = -1L;
    this.q = false;
    this.t = false;
    this.u = false;
    this.A = false;
    return true;
  }
  
  public int c(boolean paramBoolean)
  {
    File localFile = c(this.h);
    if (paramBoolean) {
      if (localFile != null) {}
    }
    while (localFile == null)
    {
      return 0;
      return a.a(this.h, new File(localFile, TbsDownloader.getBackupFileName(true)));
    }
    Context localContext = this.h;
    if (TbsDownloader.getOverSea(this.h)) {}
    for (String str = "x5.oversea.tbs.org";; str = TbsDownloader.getBackupFileName(false)) {
      return a.a(localContext, new File(localFile, str));
    }
  }
  
  public void c()
  {
    b();
    e(false);
    e(true);
  }
  
  public boolean d()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.E);
    return this.E;
  }
  
  void e()
  {
    TbsLog.i("TbsDownload", "pauseDownload,isPause=" + this.d + "isDownloading=" + TbsDownloader.isDownloading());
    if ((!this.d) && (TbsDownloader.isDownloading()))
    {
      b();
      this.d = true;
      this.A = false;
    }
  }
  
  void f()
  {
    TbsLog.i("TbsDownload", "resumeDownload,isPause=" + this.d + "isDownloading=" + TbsDownloader.isDownloading());
    if ((this.d) && (TbsDownloader.isDownloading()))
    {
      this.d = false;
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.m
 * JD-Core Version:    0.7.0.1
 */