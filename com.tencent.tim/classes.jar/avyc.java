import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class avyc
  implements Handler.Callback
{
  private static long aAD = 20971520L;
  private static String cOs;
  private static int ezt;
  private static long startDownloadTime;
  private Downloader a;
  private int btj;
  Handler handler;
  private Context mContext;
  private Map<String, avyc.b> qk;
  
  avyc(Context paramContext)
  {
    this.mContext = paramContext;
    DownloaderFactory.getInstance(this.mContext);
    DownloaderFactory.init(new avxy(), new avye());
    this.a = DownloaderFactory.createDownloader("QZonePluginDownloader");
    this.a.setPortConfigStrategy(new avyb());
    this.a.setDirectIPConfigStrategy(new avya());
    this.a.setBackupIPConfigStrategy(new avxx());
    this.a.setKeepAliveStrategy(new avxz());
    this.a.setDownloadMode(Downloader.DownloadMode.StrictMode);
    this.a.enableResumeTransfer(true);
    this.qk = new HashMap();
    this.handler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(avyc.b paramb)
  {
    PluginRecord localPluginRecord = avyc.b.a(paramb);
    Object localObject = avyc.b.a(paramb);
    avyc.b.a(paramb).state = 1;
    ((avyc.c)localObject).a(localPluginRecord);
    File localFile = avyo.g(this.mContext, localPluginRecord.id);
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "downloadPluginInner url:" + localPluginRecord.url + ",path:" + localFile);
    }
    startDownloadTime = System.currentTimeMillis();
    ezt = NetworkState.g().getNetworkType();
    if (TextUtils.isEmpty(cOs)) {
      localObject = "";
    }
    try
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = str;
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.w("QZonePluginManger", 1, "", localException);
        }
      } while (this.a.download(localPluginRecord.url, localFile.getAbsolutePath(), new avyc.a(paramb)));
      localObject = Message.obtain(this.handler, 3);
      ((Message)localObject).obj = paramb;
      ((Message)localObject).sendToTarget();
    }
    cOs = startDownloadTime + "_" + (String)localObject;
    this.btj = 0;
    if (tC(localFile.getParent()))
    {
      localObject = Message.obtain(this.handler, 3);
      ((Message)localObject).obj = paramb;
      ((Message)localObject).arg1 = -9998;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  private void a(avyc.b paramb, int paramInt, String paramString)
  {
    PluginRecord localPluginRecord = avyc.b.a(paramb);
    long l1 = System.currentTimeMillis();
    long l2 = startDownloadTime;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, cOs, ezt + "", avyc.b.a(paramb), (l1 - l2) / 1000.0D, paramInt, this.btj, paramString);
  }
  
  private void a(avyc.b paramb, int paramInt, String paramString1, String paramString2)
  {
    PluginRecord localPluginRecord = avyc.b.a(paramb);
    long l1 = System.currentTimeMillis();
    long l2 = startDownloadTime;
    LpReportInfo_dc01500.reportDownload(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, cOs, ezt + "", avyc.b.a(paramb), (l1 - l2) / 1000.0D, paramInt, this.btj, paramString1, paramString2);
  }
  
  private void b(avyc.b paramb)
  {
    if ((paramb == null) || (avyc.b.a(paramb) == null))
    {
      QLog.w("QZonePluginManger", 1, "cancelDownLoadPlugin, downloadRecord or record is null, downloadRecord=" + paramb);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "cancelDownLoadPlugin url:" + avyc.b.a(paramb).url);
    }
    PluginRecord localPluginRecord = avyc.b.a(paramb);
    this.a.abort(localPluginRecord.url, new avyc.a(paramb));
  }
  
  private boolean tC(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      if (l < QzoneConfig.getInstance().getConfig("LiveSetting", "livePluginDownloadAvailableSpace", aAD)) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          QLog.w("QZonePluginManger", 1, "low storage: totalSize=" + localStatFs.getBlockCount() * localStatFs.getBlockSize() + ", availableSize=" + l + ", path=" + paramString);
        }
        return bool;
      }
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.e("QZonePluginManger", 1, "", paramString);
    }
  }
  
  public void a(PluginRecord paramPluginRecord, avyc.c paramc)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    avyc.b localb = new avyc.b(null);
    avyc.b.a(localb, paramPluginRecord.id);
    avyc.b.a(localb, paramPluginRecord);
    avyc.b.a(localb, -1);
    avyc.b.a(localb, paramc);
    localMessage.obj = localb;
    this.handler.sendMessage(localMessage);
  }
  
  public void a(PluginRecord paramPluginRecord, avyc.c paramc, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    avyc.b localb = new avyc.b(null);
    avyc.b.a(localb, paramPluginRecord.id);
    paramPluginRecord.state = 0;
    avyc.b.a(localb, paramPluginRecord);
    avyc.b.a(localb, paramc);
    avyc.b.a(localb, paramInt);
    localMessage.obj = localb;
    this.handler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (avyc.b)paramMessage.obj;
      if (this.qk.containsKey(avyc.b.a(paramMessage))) {
        return false;
      }
      this.qk.put(avyc.b.a(paramMessage), paramMessage);
      a(paramMessage);
      return true;
      paramMessage = (avyc.b)paramMessage.obj;
      if (this.qk.containsKey(avyc.b.a(paramMessage)))
      {
        a(paramMessage, 3, "");
        this.qk.remove(avyc.b.a(paramMessage));
        b(paramMessage);
        Object localObject = avyc.b.a(paramMessage);
        if (localObject != null)
        {
          ((avyc.c)localObject).b(avyc.b.a(paramMessage));
          continue;
          paramMessage = (avyc.b)paramMessage.obj;
          if (this.qk.containsKey(avyc.b.a(paramMessage)))
          {
            a(paramMessage, 1, "");
            this.qk.remove(avyc.b.a(paramMessage));
            localObject = avyc.b.a(paramMessage);
            if (localObject != null)
            {
              ((avyc.c)localObject).b(avyc.b.a(paramMessage));
              continue;
              localObject = (avyc.b)paramMessage.obj;
              if (this.qk.containsKey(avyc.b.a((avyc.b)localObject)))
              {
                a((avyc.b)localObject, 2, paramMessage.arg1 + "", paramMessage.arg2 + "");
                this.qk.remove(avyc.b.a((avyc.b)localObject));
                avyc.c localc = avyc.b.a((avyc.b)localObject);
                if (localc != null)
                {
                  localc.a(avyc.b.a((avyc.b)localObject), paramMessage.arg1);
                  continue;
                  paramMessage = (avyc.b)paramMessage.obj;
                  if (this.qk.containsKey(avyc.b.a(paramMessage)))
                  {
                    a(paramMessage, 0, "");
                    this.qk.remove(avyc.b.a(paramMessage));
                    localObject = avyc.b.a(paramMessage);
                    if (localObject != null)
                    {
                      avyc.b.a(paramMessage).state = 2;
                      ((avyc.c)localObject).b(avyc.b.a(paramMessage), avyc.b.a(paramMessage));
                      continue;
                      paramMessage = (avyc.b)paramMessage.obj;
                      if (this.qk.containsKey(avyc.b.a(paramMessage)))
                      {
                        localObject = avyc.b.a(paramMessage);
                        if (localObject != null) {
                          ((avyc.c)localObject).c(avyc.b.a(paramMessage));
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
  
  public void onDestroy()
  {
    startDownloadTime = 0L;
    ezt = 0;
    cOs = null;
  }
  
  class a
    implements Downloader.DownloadListener
  {
    avyc.b jdField_a_of_type_Avyc$b;
    
    public a(avyc.b paramb)
    {
      this.jdField_a_of_type_Avyc$b = paramb;
    }
    
    public void onDownloadCanceled(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 1, "plugin download canceled, url=" + paramString);
      }
      paramString = Message.obtain(avyc.this.handler, 2);
      paramString.obj = this.jdField_a_of_type_Avyc$b;
      paramString.sendToTarget();
    }
    
    public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
    {
      paramString = Message.obtain(avyc.this.handler, 3);
      paramString.obj = this.jdField_a_of_type_Avyc$b;
      paramString.arg1 = -9999;
      if ((paramDownloadResult != null) && (paramDownloadResult.getReport() != null)) {}
      for (;;)
      {
        try
        {
          paramDownloadResult = new ImageDownloadReporter().obtainReportObj(paramDownloadResult, paramDownloadResult.getReport());
          paramString.arg1 = paramDownloadResult.retCode;
          if (!AppNetConnInfo.isNetSupport()) {
            continue;
          }
          i = 1;
          paramString.arg2 = i;
          QLog.w("QZonePluginManger", 1, "plugin download failed, code=" + paramDownloadResult.retCode + ", arg2=" + paramString.arg2);
        }
        catch (Exception paramDownloadResult)
        {
          int i;
          QLog.w("QZonePluginManger", 1, "onDownloadFailed", paramDownloadResult);
          continue;
        }
        paramString.sendToTarget();
        return;
        i = 0;
      }
    }
    
    public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
    {
      avyc.a(avyc.this, (int)(100.0F * paramFloat));
      paramString = Message.obtain(avyc.this.handler, 5);
      avyc.b.a(this.jdField_a_of_type_Avyc$b).progress = paramFloat;
      paramString.obj = this.jdField_a_of_type_Avyc$b;
      paramString.sendToTarget();
    }
    
    public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QZonePluginManger", 2, "onDownloadSucceed, downloaded path:" + paramDownloadResult.getPath());
        paramString = avyo.g(avyc.a(avyc.this), avyc.b.a(this.jdField_a_of_type_Avyc$b));
        QLog.d("QZonePluginManger", 2, "onDownloadSucceed, saved path:" + paramString + ", exsit:" + paramString.exists());
      }
      paramString = Message.obtain(avyc.this.handler, 4);
      paramString.obj = this.jdField_a_of_type_Avyc$b;
      paramString.sendToTarget();
    }
  }
  
  static class b
  {
    private avyc.c jdField_a_of_type_Avyc$c;
    private PluginRecord jdField_a_of_type_CooperationQzonePluginPluginRecord;
    private String id;
    private int refer;
  }
  
  public static abstract interface c
  {
    public abstract void a(PluginRecord paramPluginRecord);
    
    public abstract void a(PluginRecord paramPluginRecord, int paramInt);
    
    public abstract void b(PluginRecord paramPluginRecord);
    
    public abstract void b(PluginRecord paramPluginRecord, int paramInt);
    
    public abstract void c(PluginRecord paramPluginRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyc
 * JD-Core Version:    0.7.0.1
 */