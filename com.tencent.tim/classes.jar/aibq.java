import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class aibq
  implements PluginManagerUpdater
{
  private final AtomicLong A = new AtomicLong(System.currentTimeMillis() - 180000L);
  aibp jdField_a_of_type_Aibp;
  private aibq.a jdField_a_of_type_Aibq$a;
  private final IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
  private final File ay;
  private final File az;
  private final String bME;
  private final String bMF;
  private final String bMG;
  private final boolean cjP;
  private Future<File> d;
  private String mVersion;
  private final SharedPreferences preferences = BaseApplicationImpl.getContext().getSharedPreferences("IVShadowCdnPmUpdater", 0);
  private final String url;
  
  public aibq(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.mVersion = paramString3;
    this.az = new File(new File(paramContext.getFilesDir(), "IVShadowCdnPmUpdater"), paramString1);
    this.az.mkdirs();
    this.ay = new File(this.az, paramString1 + this.mVersion + "_pm.temp");
    this.bME = paramString1;
    this.bMF = ("pm_name_" + paramString1 + "_" + paramString2 + "_" + this.mVersion);
    this.bMG = ("wasUpdate_" + paramString1 + "_" + this.mVersion);
    this.cjP = "Now".equals(paramString1);
    this.jdField_a_of_type_Aibp = new aibp(paramContext, paramString1, paramString3);
    if (this.cjP)
    {
      paramContext = "9";
      if (!aqmr.isEmpty(paramString2)) {
        paramContext = paramString2.substring(paramString2.length() - 1);
      }
      this.url = ("https://dlied5sdk.myapp.com/now/pluginmanager/" + "" + this.mVersion + "/ShadowPluginManager_nowPlugin_" + paramContext);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("shadow").opName(paramString1);
      if (QLog.isColorLevel()) {
        QLog.i("shadow::CdnPmUpdater", 2, "use cdnupdater url = " + this.url);
      }
      return;
      if (!"Reader".equals(paramString1)) {
        break;
      }
      if ((paramString2 != null) && (paramString2.endsWith("0"))) {
        this.url = "https://down.qq.com/reading/android/plugin/release/5/reader-plugin-manager-release-gray.apk";
      } else {
        this.url = "https://down.qq.com/reading/android/plugin/release/5/reader-plugin-manager-release.apk";
      }
    }
    if ((paramString2 != null) && (paramString2.endsWith("0"))) {}
    for (paramContext = "_A";; paramContext = "_B")
    {
      this.url = ("https://dlied5sdk.myapp.com/huayang/Android/ShadowPluginManager1_1_" + paramString1 + paramContext);
      break;
    }
  }
  
  @SuppressLint({"ApplySharedPref"})
  private void KT(boolean paramBoolean)
  {
    this.preferences.edit().putBoolean(this.bMG, paramBoolean).commit();
    if (QLog.isColorLevel()) {
      QLog.i("shadow::CdnPmUpdater", 2, "setWasUpdating:" + paramBoolean);
    }
  }
  
  private boolean aoQ()
    throws IOException
  {
    boolean bool1 = true;
    boolean bool2 = true;
    File localFile = getLatest();
    if (localFile == null) {}
    for (;;)
    {
      return bool2;
      long l = System.currentTimeMillis() - this.A.get();
      if (l <= 180000L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("shadow::CdnPmUpdater", 2, "短时间内不重复检测interval==" + l);
        }
        return false;
      }
      try
      {
        localObject1 = new URL(this.url).openConnection();
        if ((localObject1 instanceof HttpURLConnection)) {
          break label149;
        }
        throw new Error(this.url + acfp.m(2131703520));
      }
      finally
      {
        localObject1 = null;
      }
      label136:
      if (localObject1 != null) {
        ((HttpURLConnection)localObject1).disconnect();
      }
      throw localObject2;
      label149:
      Object localObject1 = (HttpURLConnection)localObject1;
      try
      {
        if (((HttpURLConnection)localObject1).getResponseCode() != 200) {
          throw new Error(acfp.m(2131703522) + 200 + acfp.m(2131703523) + ((HttpURLConnection)localObject1).getResponseCode());
        }
        l = localObject2.length();
        int i = ((HttpURLConnection)localObject1).getContentLength();
        this.A.set(System.currentTimeMillis());
        if (l != i) {}
        for (;;)
        {
          bool2 = bool1;
          if (localObject1 == null) {
            break;
          }
          ((HttpURLConnection)localObject1).disconnect();
          return bool1;
          bool1 = false;
        }
        break label136;
      }
      finally {}
    }
  }
  
  private boolean aoR()
  {
    return this.preferences.getBoolean(this.bMG, false);
  }
  
  private void x(File paramFile)
  {
    this.preferences.edit().putString(this.bMF, paramFile.getAbsolutePath()).apply();
  }
  
  public File F()
    throws Exception
  {
    if (QLog.isColorLevel()) {
      QLog.d("shadow::CdnPmUpdater", 2, "start download ");
    }
    File localFile = new File(this.az, this.bME + "_" + Long.valueOf(new StringBuilder().append(System.currentTimeMillis()).append("").toString(), 36) + ".apk");
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Exception[] arrayOfException = new Exception[1];
    long l = System.currentTimeMillis();
    aiex localaiex = new aiex();
    localaiex.init(BaseApplicationImpl.getContext());
    localaiex.a(this.url, new aibs(this, localFile, arrayOfException, l, localCountDownLatch));
    localaiex.c(aiez.a(this.url, this.url, this.ay.getAbsolutePath()));
    localCountDownLatch.await();
    if (arrayOfException[0] == null)
    {
      localFile.setLastModified(localFile.lastModified() + 1000L);
      x(localFile);
      return localFile;
    }
    throw arrayOfException[0];
  }
  
  public void a(aibq.a parama)
  {
    this.jdField_a_of_type_Aibq$a = parama;
  }
  
  public void drU()
  {
    File localFile = getLatest();
    if (localFile != null) {
      localFile.delete();
    }
  }
  
  public File getLatest()
  {
    Object localObject = this.preferences.getString(this.bMF, null);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return null;
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    throw new UnsupportedOperationException(acfp.m(2131703521));
  }
  
  public Future<File> update()
  {
    KT(true);
    if (QLog.isColorLevel()) {
      QLog.i("shadow::CdnPmUpdater", 2, "update");
    }
    if (this.cjP) {}
    for (String str = "33669796";; str = "33669801")
    {
      aids.report(str);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("update").report();
      if ((this.d == null) || (this.d.isDone())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("shadow::CdnPmUpdater", 2, "上一次update还没结束，返回相同Future");
      }
      return this.d;
    }
    this.d = acmo.a(192).submit(new aibr(this));
    return this.d;
  }
  
  public boolean wasUpdating()
  {
    return aoR();
  }
  
  public static abstract interface a
  {
    public abstract void drV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibq
 * JD-Core Version:    0.7.0.1
 */