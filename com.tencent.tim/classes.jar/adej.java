import android.os.Handler;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.ArConfigService.5.1;
import com.tencent.mobileqq.ar.ArConfigService.5.2;
import com.tencent.mobileqq.ar.ArConfigService.5.3;
import com.tencent.qphone.base.util.QLog;

public class adej
  implements adis.a
{
  public adej(ArConfigService paramArConfigService) {}
  
  public void a(boolean paramBoolean, adis.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onARResourceDownloadComplete mARSDK2ResourceDownloadCallback result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean)
    {
      ArConfigService.c(this.this$0, true);
      if ((ArConfigService.f(this.this$0)) && (ArConfigService.g(this.this$0)) && (ArConfigService.h(this.this$0)) && (ArConfigService.i(this.this$0)) && (ArConfigService.j(this.this$0))) {
        ArConfigService.a(this.this$0).post(new ArConfigService.5.2(this));
      }
    }
    while (ArConfigService.e(this.this$0)) {
      return;
    }
    ArConfigService.a(this.this$0).post(new ArConfigService.5.3(this));
    ArConfigService.a(this.this$0, true);
  }
  
  public void aj(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onARResourceDownloadUpdateProgress curOffset=%s totalLen=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    ArConfigService.b(this.this$0, (int)(100L * paramLong1 / paramLong2));
    int i = (ArConfigService.a(this.this$0) + ArConfigService.b(this.this$0) + ArConfigService.c(this.this$0) + ArConfigService.d(this.this$0) + ArConfigService.e(this.this$0)) / 5;
    if (!ArConfigService.e(this.this$0)) {
      ArConfigService.a(this.this$0).post(new ArConfigService.5.1(this, i));
    }
  }
  
  public void cQU()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "mARSDK2ResourceDownloadCallback");
    }
  }
  
  public void cQV() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adej
 * JD-Core Version:    0.7.0.1
 */