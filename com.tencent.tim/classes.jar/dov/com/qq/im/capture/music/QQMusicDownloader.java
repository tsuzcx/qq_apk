package dov.com.qq.im.capture.music;

import android.os.SystemClock;
import android.text.TextUtils;
import aqft;
import aquz;
import aqva;
import atao.m;
import axrh;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

public class QQMusicDownloader
{
  public static aquz a(String paramString1, String paramString2, axrh paramaxrh)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("QQMusicDownloader", 1, "invalid downlaod params " + paramString1 + ", " + paramString2);
      return null;
    }
    paramString1 = new aquz(paramString1, new File(paramString2));
    paramString1.cWw = true;
    paramString1.retryCount = 2;
    paramString1.key = paramString2;
    paramString1.XY(512);
    paramString1.c(paramaxrh);
    return paramString1;
  }
  
  public static void a(aquz paramaquz, axrh paramaxrh)
  {
    ThreadManager.post(new DownloadMusicTask(paramaquz, paramaxrh), 5, null, false);
  }
  
  public static void i(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicDownloader", 2, "cancel task " + paramaquz.key);
    }
    paramaquz.cancel(true);
  }
  
  static class DownloadMusicTask
    implements Runnable
  {
    axrh b;
    aquz c;
    
    public DownloadMusicTask(aquz paramaquz, axrh paramaxrh)
    {
      this.c = paramaquz;
      this.b = paramaxrh;
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQMusicDownloader", 2, "begin download " + this.c.key);
      }
      if ((aqft.cC()) && (aqft.hE() < 20971520L))
      {
        if (this.b != null) {
          this.b.ax(this.c.key, false);
        }
        QLog.e("QQMusicDownloader", 1, "download err no space");
      }
      long l1;
      int i;
      long l2;
      do
      {
        return;
        String str = atao.m.cGy;
        Object localObject = str;
        if (SdkContext.getInstance() != null)
        {
          localObject = str;
          if (SdkContext.getInstance().getResources() != null)
          {
            localObject = str;
            if (SdkContext.getInstance().getResources().getAVFilterResource() != null)
            {
              localObject = str;
              if (SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath() != null) {
                localObject = SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath();
              }
            }
          }
        }
        localObject = new File((String)localObject);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        l1 = SystemClock.uptimeMillis();
        i = aqva.a(this.c, null, null);
        l2 = SystemClock.uptimeMillis();
      } while (!QLog.isColorLevel());
      QLog.i("QQMusicDownloader", 2, "download cost " + (l2 - l1) + " result " + i + " key " + this.c.key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicDownloader
 * JD-Core Version:    0.7.0.1
 */