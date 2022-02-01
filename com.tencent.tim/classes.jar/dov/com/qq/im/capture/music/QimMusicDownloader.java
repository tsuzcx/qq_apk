package dov.com.qq.im.capture.music;

import android.os.SystemClock;
import android.text.TextUtils;
import aqft;
import aquz;
import aqva;
import axrh;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

public class QimMusicDownloader
{
  public static void a(String paramString1, String paramString2, axrh paramaxrh)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("MusicProviderView.Downloader", 1, "invalid downlaod params " + paramString1 + ", " + paramString2);
      return;
    }
    ThreadManager.post(new DownloadMusicTask(paramString1, paramString2, paramaxrh), 5, null, false);
  }
  
  static class DownloadMusicTask
    implements Runnable
  {
    axrh b;
    String mPath;
    String mUrlStr;
    
    public DownloadMusicTask(String paramString1, String paramString2, axrh paramaxrh)
    {
      this.mUrlStr = paramString1;
      this.mPath = paramString2;
      this.b = paramaxrh;
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView.Downloader", 2, "begin download " + this.mPath + " " + this.mUrlStr);
      }
      if ((aqft.cC()) && (aqft.hE() < 20971520L))
      {
        if (this.b != null) {
          this.b.ax(this.mUrlStr, false);
        }
        QLog.e("MusicProviderView.Downloader", 1, "download err no space");
      }
      Object localObject;
      long l1;
      int i;
      long l2;
      do
      {
        return;
        localObject = new File(SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = new File(this.mPath);
        l1 = SystemClock.uptimeMillis();
        localObject = new aquz(this.mUrlStr, (File)localObject);
        ((aquz)localObject).cWw = true;
        ((aquz)localObject).retryCount = 2;
        ((aquz)localObject).key = this.mPath;
        ((aquz)localObject).XY(512);
        ((aquz)localObject).c(this.b);
        i = aqva.a((aquz)localObject, null, null);
        l2 = SystemClock.uptimeMillis();
      } while (!QLog.isColorLevel());
      QLog.i("MusicProviderView.Downloader", 2, "download cost " + (l2 - l1) + " result " + i + " key " + ((aquz)localObject).key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QimMusicDownloader
 * JD-Core Version:    0.7.0.1
 */