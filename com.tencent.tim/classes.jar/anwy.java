import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class anwy
  implements anxe
{
  private final AtomicLong A = new AtomicLong(System.currentTimeMillis() - 180000L);
  private final File ay;
  private final File az;
  private final String bME;
  private final String bMF;
  private final String bMG;
  private final boolean cjP;
  private Future<File> d;
  private final SharedPreferences preferences;
  private final String url;
  private final String version;
  
  public anwy(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.version = paramString3;
    this.preferences = paramContext.getSharedPreferences(String.format("%sShadowCdnPmUpdater", new Object[] { paramString1 }), 0);
    this.az = new File(new File(paramContext.getFilesDir(), "ShadowCdnPmUpdater"), paramString1);
    this.az.mkdirs();
    this.ay = new File(this.az, paramString1 + this.version + "_pm.temp");
    this.bME = paramString1;
    this.bMF = ("pm_name_" + paramString1 + "_" + paramString2 + "_" + this.version);
    this.bMG = ("wasUpdate_" + paramString1 + "_" + this.version);
    this.cjP = false;
    this.url = "https://down.qq.com/innovate/qq/pm/release/StudyRoomPluginManager.apk";
    if (QLog.isColorLevel()) {
      QLog.i("studyroom.CdnPmUpdater", 2, "use cdnupdater url = " + this.url);
    }
  }
  
  @SuppressLint({"ApplySharedPref"})
  private void KT(boolean paramBoolean)
  {
    this.preferences.edit().putBoolean(this.bMG, paramBoolean).commit();
    if (QLog.isColorLevel()) {
      QLog.i("studyroom.CdnPmUpdater", 2, "setWasUpdating:" + paramBoolean);
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
          QLog.i("studyroom.CdnPmUpdater", 2, "短时间内不重复检测interval==" + l);
        }
        return false;
      }
      try
      {
        localObject1 = new URL(this.url).openConnection();
        if ((localObject1 instanceof HttpURLConnection)) {
          break label148;
        }
        throw new Error(this.url + acfp.m(2131703520));
      }
      finally
      {
        localObject1 = null;
      }
      label135:
      if (localObject1 != null) {
        ((HttpURLConnection)localObject1).disconnect();
      }
      throw localObject2;
      label148:
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
        break label135;
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
      QLog.d("studyroom.CdnPmUpdater", 2, "start download ");
    }
    File localFile = new File(this.az, this.bME + "_" + Long.valueOf(new StringBuilder().append(System.currentTimeMillis()).append("").toString(), 36) + ".apk");
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Exception[] arrayOfException = new Exception[1];
    System.currentTimeMillis();
    anwp localanwp = new anwp();
    localanwp.init(BaseApplicationImpl.getContext());
    localanwp.a(this.url, new anxa(this, localFile, arrayOfException, localCountDownLatch));
    localanwp.b(anwr.a(this.url, this.url, this.ay.getAbsolutePath()));
    localCountDownLatch.await();
    if (arrayOfException[0] == null)
    {
      localFile.setLastModified(localFile.lastModified() + 1000L);
      x(localFile);
      return localFile;
    }
    throw arrayOfException[0];
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
  
  public boolean isAvailable()
  {
    return true;
  }
  
  public Future<File> update()
  {
    KT(true);
    if (QLog.isColorLevel()) {
      QLog.i("studyroom.CdnPmUpdater", 2, "update");
    }
    if ((this.d != null) && (!this.d.isDone()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("studyroom.CdnPmUpdater", 2, "上一次update还没结束，返回相同Future");
      }
      return this.d;
    }
    this.d = acmo.a(192).submit(new anwz(this));
    return this.d;
  }
  
  public boolean wasUpdating()
  {
    return aoR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwy
 * JD-Core Version:    0.7.0.1
 */