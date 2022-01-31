import android.os.Handler;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

public class zxm
  implements ARPreSoResourceDownload.ARResourceDownloadCallback
{
  public zxm(ArConfigService paramArConfigService) {}
  
  public void a() {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onARResourceDownloadUpdateProgress curOffset=%s totalLen=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    ArConfigService.b(this.a, (int)(100L * paramLong1 / paramLong2));
    int i = (ArConfigService.a(this.a) + ArConfigService.b(this.a) + ArConfigService.c(this.a)) / 3;
    if (!ArConfigService.d(this.a)) {
      ArConfigService.a(this.a).post(new zxn(this, i));
    }
  }
  
  public void a(boolean paramBoolean, ARPreSoResourceDownload.DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onARResourceDownloadComplete result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean)
    {
      ArConfigService.c(this.a, true);
      if ((ArConfigService.e(this.a)) && (ArConfigService.f(this.a)) && (ArConfigService.g(this.a))) {
        ArConfigService.a(this.a).post(new zxo(this));
      }
    }
    while (ArConfigService.d(this.a)) {
      return;
    }
    ArConfigService.a(this.a).post(new zxp(this));
    ArConfigService.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zxm
 * JD-Core Version:    0.7.0.1
 */