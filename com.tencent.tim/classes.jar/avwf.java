import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class avwf
  implements Handler.Callback
{
  private static String TAG = "QzoneModuleDownloadManager";
  private avrq c;
  private Downloader.DownloadListener e = new avwg(this);
  private Context mContext;
  private Handler mHandler;
  private Map<String, avwf.a> qj = new ConcurrentHashMap();
  
  public avwf(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.c = avrq.a();
    this.mHandler = new Handler(QzoneHandlerThreadFactory.getHandlerThreadLooper("Normal_HandlerThread"), this);
  }
  
  private void a(avwf.a parama)
  {
    String str1 = parama.c.mUrl;
    if (this.qj.containsKey(str1)) {
      return;
    }
    this.qj.put(str1, parama);
    Object localObject = parama.c;
    String str2 = QzoneModuleConst.getModuleSavePath(this.mContext, (avwe.a)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "----------savePath--" + str2);
    }
    File localFile = new File(str2);
    if (localFile.exists())
    {
      String str3 = ((avwe.a)localObject).mMD5;
      if ((TextUtils.isEmpty(str3)) || ((((avwe.a)localObject).aAA != 0L) && (((avwe.a)localObject).aAA == localFile.length())))
      {
        QLog.i(TAG, 1, "download succeed: from cache.");
        avwe.a().a((avwe.a)localObject);
        if (parama.b != null)
        {
          parama.b.onDownloadSucceed(parama.kx);
          this.qj.remove(str1);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 1, "before download-- orgMD5: " + str3 + " , downloadFilePath: " + localFile.getPath());
        }
        localObject = new File(str2);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        QLog.i(TAG, 1, "check download cache failed: md5 verify is not passed.");
      }
    }
    QLog.i(TAG, 1, "start download--" + parama.kx + ",priority: " + parama.priority + " ,startImmediately: " + parama.dph);
    parama.startTimeStamp = System.nanoTime();
    this.c.a(str1, str2, parama.priority, parama.dph, this.e);
  }
  
  private void aaq(String paramString)
  {
    avwf.a locala = (avwf.a)this.qj.get(paramString);
    String str2;
    avwe.a locala1;
    String str3;
    long l;
    if (locala != null)
    {
      str2 = QzoneModuleConst.getModuleSavePath(this.mContext, locala.c);
      locala1 = locala.c;
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 1, "download complete: " + str2);
      }
      str3 = locala1.mMD5;
      String str1 = "";
      if (!TextUtils.isEmpty(str3)) {
        str1 = arwv.encodeFileHexStr(str2);
      }
      l = (System.nanoTime() - locala.startTimeStamp) / 1000000L;
      if ((!TextUtils.isEmpty(str3)) && (!str3.equalsIgnoreCase(str1))) {
        break label254;
      }
      avwe.a().a(locala1);
    }
    for (;;)
    {
      try
      {
        if (QzoneModuleConst.QZONE_MODULES_NEED_INSTALL.contains(locala1.mModuleId)) {
          new DexClassLoader(str2, this.mContext.getApplicationContext().getDir("dex", 0).getAbsolutePath(), str2, this.mContext.getApplicationContext().getClassLoader());
        }
        if (locala.b != null) {
          locala.b.onDownloadSucceed(locala.kx);
        }
        avwm.a(locala1, true, l);
        this.qj.remove(paramString);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e(TAG, 1, "after download,new DexClassLoader error: ", localThrowable);
        continue;
      }
      label254:
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 1, "download complete-- orgMD5: " + str3 + " , downloadMD5: " + localThrowable);
      }
      File localFile = new File(str2);
      if (localFile.exists()) {
        localFile.delete();
      }
      QLog.i(TAG, 1, "download failed: md5 verify is not passed.");
      if (locala.b != null) {
        locala.b.onDownloadFailed(locala.kx);
      }
      avwm.a(locala1, false, l);
    }
  }
  
  public boolean a(avwe.a parama, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parama, false, paramModuleDownloadListener);
  }
  
  public boolean a(avwe.a parama, boolean paramBoolean, ModuleDownloadListener paramModuleDownloadListener)
  {
    return a(parama, paramBoolean, false, paramModuleDownloadListener);
  }
  
  public boolean a(avwe.a parama, boolean paramBoolean1, boolean paramBoolean2, ModuleDownloadListener paramModuleDownloadListener)
  {
    if (parama == null) {
      return false;
    }
    avwf.a locala = new avwf.a(null);
    locala.kx = parama.mModuleId;
    locala.c = parama;
    locala.b = paramModuleDownloadListener;
    locala.priority = paramBoolean1;
    locala.dph = paramBoolean2;
    parama = Message.obtain(this.mHandler);
    parama.what = 1;
    parama.obj = locala;
    parama.sendToTarget();
    return true;
  }
  
  public void abortDownloadModule(String paramString)
  {
    paramString = avwe.a().a(paramString);
    if ((paramString == null) || (!this.qj.containsKey(paramString.mUrl))) {}
    do
    {
      return;
      paramString = (avwf.a)this.qj.get(paramString.mUrl);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.mHandler);
    localMessage.what = 7;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public void cancelDownloadModule(String paramString)
  {
    paramString = avwe.a().a(paramString);
    if ((paramString == null) || (!this.qj.containsKey(paramString.mUrl))) {}
    do
    {
      return;
      paramString = (avwf.a)this.qj.get(paramString.mUrl);
    } while (paramString == null);
    Message localMessage = Message.obtain(this.mHandler);
    localMessage.what = 4;
    localMessage.obj = paramString;
    localMessage.sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    avwf.a locala;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      a((avwf.a)paramMessage.obj);
      return true;
    case 2: 
      aaq((String)paramMessage.obj);
      return true;
    case 3: 
      paramMessage = (String)paramMessage.obj;
      locala = (avwf.a)this.qj.get(paramMessage);
      if (locala != null)
      {
        QLog.e(TAG, 1, "download failed: " + locala.kx);
        if (locala.b != null) {
          locala.b.onDownloadFailed(locala.kx);
        }
        long l = (System.nanoTime() - locala.startTimeStamp) / 1000000L;
        avwm.a(locala.c, false, l);
      }
      this.qj.remove(paramMessage);
      return true;
    case 4: 
      paramMessage = (avwf.a)paramMessage.obj;
      QLog.w(TAG, 1, "cancel download: " + paramMessage.kx);
      paramMessage = paramMessage.c.mUrl;
      this.c.cancel(paramMessage, this.e);
      return true;
    case 5: 
      paramMessage = (String)paramMessage.obj;
      locala = (avwf.a)this.qj.get(paramMessage);
      if (locala != null)
      {
        QLog.w(TAG, 1, "download canceled: " + locala.kx);
        if (locala.b != null) {
          locala.b.onDownloadCanceled(locala.kx);
        }
      }
      this.qj.remove(paramMessage);
      return true;
    case 6: 
      paramMessage = (avwf.a)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.b != null))
      {
        float f = ((Float)paramMessage.obj).floatValue();
        paramMessage.b.onDownloadProgress(paramMessage.kx, f);
      }
      return true;
    }
    paramMessage = (avwf.a)paramMessage.obj;
    QLog.w(TAG, 1, "abort download: " + paramMessage.kx);
    paramMessage = paramMessage.c.mUrl;
    this.c.abort(paramMessage, this.e);
    return true;
  }
  
  static class a
  {
    ModuleDownloadListener b;
    avwe.a c;
    boolean dph;
    String kx;
    Object obj;
    boolean priority;
    long startTimeStamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avwf
 * JD-Core Version:    0.7.0.1
 */