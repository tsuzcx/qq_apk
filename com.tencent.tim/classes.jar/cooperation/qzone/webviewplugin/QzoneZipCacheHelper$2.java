package cooperation.qzone.webviewplugin;

import ahbj;
import avsw;
import awda;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

final class QzoneZipCacheHelper$2
  implements Runnable
{
  QzoneZipCacheHelper$2(String paramString1, String paramString2, int paramInt, String paramString3, AppInterface paramAppInterface) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("QzoneZipCacheHelper", 2, String.format("delay 10s,url:%s,path:%s", new Object[] { this.Gv, this.Gw }));
    }
    ??? = new File(this.Gw);
    if ((((File)???).exists()) && (((File)???).isDirectory()))
    {
      ??? = ((File)???).listFiles();
      if ((??? == null) || ((this.val$count != -1) && (???.length != this.val$count)) || (???.length <= 0)) {}
    }
    for (boolean bool3 = true;; bool3 = false)
    {
      boolean bool2 = bool3;
      for (;;)
      {
        try
        {
          ??? = new File(this.Gw + System.currentTimeMillis() + ".zip");
          bool1 = bool3;
          if (!bool3)
          {
            bool2 = bool3;
            localObject2 = awda.sa(this.zx);
            bool2 = bool3;
            bool3 = awda.a(this.val$appInterface, (String)localObject2, (File)???);
            if (!bool3) {
              continue;
            }
            bool2 = bool3;
            localObject2 = new File(this.Gw);
            bool2 = bool3;
            if (!((File)localObject2).exists()) {
              break label494;
            }
            bool2 = bool3;
            if (!((File)localObject2).isDirectory()) {
              break label494;
            }
            if (i == 0)
            {
              bool2 = bool3;
              QzoneZipCacheHelper.unzipFile(((File)???).getAbsolutePath(), this.Gw);
            }
            bool2 = bool3;
            QzoneZipCacheHelper.access$100().H(this.Gw, true);
            bool1 = bool3;
            bool2 = bool3;
            if (QLog.isColorLevel())
            {
              bool2 = bool3;
              QLog.i("QzoneZipCacheHelper", 2, String.format("download succ,path:%s", new Object[] { this.Gw }));
              bool1 = bool3;
            }
          }
          bool2 = bool1;
          if (((File)???).exists())
          {
            bool2 = bool1;
            ahbj.deleteFile((File)???);
          }
        }
        catch (Throwable localThrowable)
        {
          Object localObject2;
          Object localObject4;
          boolean bool1 = bool2;
          continue;
          QzoneZipCacheHelper.access$300().remove(this.zx);
          return;
        }
        synchronized (QzoneZipCacheHelper.access$200())
        {
          if (QzoneZipCacheHelper.access$300() == null) {
            continue;
          }
          localObject2 = (CopyOnWriteArrayList)QzoneZipCacheHelper.access$300().get(this.zx);
          if (localObject2 == null) {
            continue;
          }
          localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject4 = ((Iterator)localObject2).next();
          if (!(localObject4 instanceof QzoneZipCacheHelperCallBack)) {
            continue;
          }
          ((QzoneZipCacheHelperCallBack)localObject4).onResult(bool1);
          ((QzoneZipCacheHelperCallBack)localObject4).onResultOfNativeRequest(true, this.Gw, this.zx);
        }
        bool1 = bool3;
        bool2 = bool3;
        if (QLog.isColorLevel())
        {
          bool2 = bool3;
          QLog.i("QzoneZipCacheHelper", 2, String.format("download fail,url:%s,path:%s", new Object[] { localObject3, this.Gw }));
          bool1 = bool3;
          continue;
          label494:
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneZipCacheHelper.2
 * JD-Core Version:    0.7.0.1
 */