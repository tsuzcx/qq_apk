import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class avxu
  implements Handler.Callback
{
  private static String cOq = "livepluginso.jar";
  private Downloader a;
  Handler handler;
  private Context mContext;
  private Map<String, avxu.a> qk;
  
  avxu(Context paramContext)
  {
    this.mContext = paramContext;
    this.a = DownloaderFactory.getInstance(this.mContext).getCommonDownloader();
    this.a.enableResumeTransfer(true);
    this.qk = new HashMap();
    this.handler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(avxu.a parama)
  {
    if (parama != null)
    {
      Object localObject = avxu.a.a(parama);
      if (localObject != null) {
        ((avxu.b)localObject).c(parama);
      }
      localObject = avyo.bO(BaseApplicationImpl.getContext()) + cOq;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "downloadSoInner url:" + avxu.a.a(parama) + "     path:" + (String)localObject);
      }
      if (!this.a.download(avxu.a.a(parama), (String)localObject, new avxu.c(parama)))
      {
        localObject = Message.obtain(this.handler, 3);
        ((Message)localObject).obj = parama;
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  private void a(avxu.a parama, int paramInt1, int paramInt2)
  {
    parama = new HashMap();
    parama.put("ret_code", String.valueOf(paramInt1));
    parama.put("refer", String.valueOf(paramInt2));
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actQZLiveDownloadSoReport", true, 0L, 0L, parama, null);
    }
  }
  
  private void b(avxu.a parama)
  {
    if (parama != null) {
      this.a.cancel(avxu.a.a(parama), new avxu.c(parama));
    }
  }
  
  private static void eCw()
  {
    String str = avyo.bO(BaseApplicationImpl.getContext());
    if (TextUtils.isEmpty(str)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(str + cOq);
    } while (!localFile.exists());
    try
    {
      awcf.d(localFile, new File(str));
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "unZipPluginSo success");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QZoneLiveSoDownloader", 1, "unzipTofolder" + localException.getMessage());
      return;
    }
    finally
    {
      localFile.delete();
    }
  }
  
  public void a(String paramString, avxu.b paramb, int paramInt)
  {
    avxu.a locala = new avxu.a();
    avxu.a.a(locala, paramString);
    avxu.a.a(locala, paramb);
    avxu.a.a(locala, paramInt);
    if ((avyo.cV(BaseApplicationImpl.getContext())) && (paramb != null))
    {
      paramb.f(locala);
      return;
    }
    paramString = Message.obtain();
    paramString.what = 0;
    paramString.obj = locala;
    this.handler.sendMessage(paramString);
  }
  
  public void aas(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramString;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj instanceof avxu.a))
      {
        paramMessage = (avxu.a)paramMessage.obj;
        if (this.qk.containsKey(avxu.a.a(paramMessage))) {
          return false;
        }
        this.qk.put(avxu.a.a(paramMessage), paramMessage);
        a(paramMessage);
        return true;
        if ((paramMessage.obj instanceof String))
        {
          paramMessage = (String)paramMessage.obj;
          if (this.qk.containsKey(paramMessage))
          {
            Object localObject = (avxu.a)this.qk.get(paramMessage);
            a((avxu.a)localObject, 3, avxu.a.a((avxu.a)localObject));
            this.qk.remove(paramMessage);
            b((avxu.a)localObject);
            continue;
            if ((paramMessage.obj instanceof avxu.a))
            {
              paramMessage = (avxu.a)paramMessage.obj;
              if (this.qk.containsKey(avxu.a.a(paramMessage)))
              {
                a(paramMessage, 1, avxu.a.a(paramMessage));
                this.qk.remove(avxu.a.a(paramMessage));
                localObject = avxu.a.a(paramMessage);
                if (localObject != null)
                {
                  ((avxu.b)localObject).d(paramMessage);
                  continue;
                  if ((paramMessage.obj instanceof avxu.a))
                  {
                    paramMessage = (avxu.a)paramMessage.obj;
                    if (this.qk.containsKey(avxu.a.a(paramMessage)))
                    {
                      a(paramMessage, 2, avxu.a.a(paramMessage));
                      this.qk.remove(avxu.a.a(paramMessage));
                      localObject = avxu.a.a(paramMessage);
                      if (localObject != null)
                      {
                        ((avxu.b)localObject).e(paramMessage);
                        continue;
                        if ((paramMessage.obj instanceof avxu.a))
                        {
                          paramMessage = (avxu.a)paramMessage.obj;
                          if (this.qk.containsKey(avxu.a.a(paramMessage)))
                          {
                            localObject = avxu.a.a(paramMessage);
                            eCw();
                            LocalMultiProcConfig.putInt("QzoneLiveSoVersion", QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOVersion", 5));
                            if (avyo.cV(BaseApplicationImpl.getContext()))
                            {
                              a(paramMessage, 0, avxu.a.a(paramMessage));
                              this.qk.remove(avxu.a.a(paramMessage));
                              if (localObject != null) {
                                ((avxu.b)localObject).f(paramMessage);
                              }
                            }
                            else if (localObject != null)
                            {
                              ((avxu.b)localObject).e(paramMessage);
                              continue;
                              if ((paramMessage.obj instanceof avxu.a))
                              {
                                paramMessage = (avxu.a)paramMessage.obj;
                                if (this.qk.containsKey(avxu.a.a(paramMessage)))
                                {
                                  localObject = avxu.a.a(paramMessage);
                                  if (localObject != null) {
                                    ((avxu.b)localObject).g(paramMessage);
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static class a
  {
    private avxu.b a;
    private String cOr;
    public int errorCode;
    public float progress;
    private int refer;
  }
  
  public static abstract interface b
  {
    public abstract void c(avxu.a parama);
    
    public abstract void d(avxu.a parama);
    
    public abstract void e(avxu.a parama);
    
    public abstract void f(avxu.a parama);
    
    public abstract void g(avxu.a parama);
  }
  
  class c
    implements Downloader.DownloadListener
  {
    avxu.a jdField_a_of_type_Avxu$a;
    
    public c(avxu.a parama)
    {
      this.jdField_a_of_type_Avxu$a = parama;
    }
    
    public void onDownloadCanceled(String paramString)
    {
      paramString = Message.obtain(avxu.this.handler, 2);
      paramString.obj = this.jdField_a_of_type_Avxu$a;
      paramString.sendToTarget();
    }
    
    public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
    {
      paramString = Message.obtain(avxu.this.handler, 3);
      paramString.obj = this.jdField_a_of_type_Avxu$a;
      paramString.arg1 = -9999;
      if ((paramDownloadResult != null) && (paramDownloadResult.getReport() != null)) {}
      for (;;)
      {
        try
        {
          paramDownloadResult = new ImageDownloadReporter().obtainReportObj(paramDownloadResult, paramDownloadResult.getReport());
          if (paramDownloadResult != null)
          {
            paramString.arg1 = paramDownloadResult.retCode;
            QLog.w("QZoneLiveSoDownloader", 1, "So download failed, code=" + paramDownloadResult.retCode);
            this.jdField_a_of_type_Avxu$a.errorCode = paramDownloadResult.retCode;
          }
        }
        catch (Exception paramDownloadResult)
        {
          QLog.w("QZoneLiveSoDownloader", 1, "", paramDownloadResult);
          continue;
        }
        paramString.sendToTarget();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QZoneLiveSoDownloader", 2, "So download failed downloadResult:null");
        }
      }
    }
    
    public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
    {
      int i = (int)(100.0F * paramFloat);
      if (this.jdField_a_of_type_Avxu$a != null) {
        this.jdField_a_of_type_Avxu$a.progress = i;
      }
      paramString = Message.obtain(avxu.this.handler, 5);
      paramString.obj = this.jdField_a_of_type_Avxu$a;
      paramString.sendToTarget();
    }
    
    public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "onDownloadSucceed path:" + paramDownloadResult.getPath());
      }
      paramString = Message.obtain(avxu.this.handler, 4);
      paramString.obj = this.jdField_a_of_type_Avxu$a;
      paramString.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxu
 * JD-Core Version:    0.7.0.1
 */