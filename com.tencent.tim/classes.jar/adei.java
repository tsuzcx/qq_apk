import android.os.Handler;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.ArConfigService.4.1;
import com.tencent.mobileqq.ar.ArConfigService.4.2;
import com.tencent.mobileqq.ar.ArConfigService.4.3;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class adei
  implements afem.b
{
  public adei(ArConfigService paramArConfigService) {}
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "EarlyDownLoadListener");
    }
  }
  
  public void a(XmlData paramXmlData, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onDownloadProgress data=%s curOffset=%s totalLen=%s", new Object[] { paramXmlData, Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    if ("qq.android.ar.native.so_v8.3.6".equals(paramXmlData.strResName)) {
      ArConfigService.a(this.this$0, (int)(100L * paramLong1 / paramLong2));
    }
    int i = (ArConfigService.a(this.this$0) + ArConfigService.b(this.this$0) + ArConfigService.c(this.this$0) + ArConfigService.d(this.this$0) + ArConfigService.e(this.this$0)) / 5;
    if (!ArConfigService.e(this.this$0)) {
      ArConfigService.a(this.this$0).post(new ArConfigService.4.1(this, i));
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onDownloadFinish data=%s result=%s", new Object[] { paramXmlData, Boolean.valueOf(paramBoolean1) }));
    }
    if (paramBoolean1)
    {
      if ("qq.android.ar.native.so_v8.3.6".equals(paramXmlData.strResName)) {
        ArConfigService.b(this.this$0, true);
      }
      if ((ArConfigService.f(this.this$0)) && (ArConfigService.g(this.this$0)) && (ArConfigService.h(this.this$0)) && (ArConfigService.i(this.this$0)) && (ArConfigService.j(this.this$0))) {
        ArConfigService.a(this.this$0).post(new ArConfigService.4.2(this));
      }
    }
    while (ArConfigService.e(this.this$0)) {
      return;
    }
    ArConfigService.a(this.this$0).post(new ArConfigService.4.3(this));
    ArConfigService.a(this.this$0, true);
  }
  
  public void b(XmlData paramXmlData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adei
 * JD-Core Version:    0.7.0.1
 */