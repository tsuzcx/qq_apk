import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class axrn
  extends axrh
{
  private axrh b;
  private ConcurrentHashMap<String, MusicItemInfo> ki;
  private ConcurrentHashMap<String, aquz> kj;
  
  public axrn(ConcurrentHashMap<String, MusicItemInfo> paramConcurrentHashMap, ConcurrentHashMap<String, aquz> paramConcurrentHashMap1, axrh paramaxrh)
  {
    this.ki = paramConcurrentHashMap;
    this.kj = paramConcurrentHashMap1;
    this.b = paramaxrh;
  }
  
  public void ax(String paramString, boolean paramBoolean)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.ki.get(paramString);
    if (localMusicItemInfo != null)
    {
      if (paramBoolean) {
        break label60;
      }
      axxj.a(localMusicItemInfo).ePi();
      localMusicItemInfo.mProgress = -1;
      this.ki.remove(paramString);
      this.kj.remove(paramString);
    }
    for (;;)
    {
      this.b.ax(paramString, paramBoolean);
      return;
      label60:
      localMusicItemInfo.mProgress = 1;
    }
  }
  
  public void c(String paramString, boolean paramBoolean, int paramInt)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.ki.get(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicDownloadListener", 2, new Object[] { "onFinish, info:", localMusicItemInfo });
    }
    boolean bool = paramBoolean;
    if (localMusicItemInfo != null)
    {
      if (!paramBoolean) {
        break label214;
      }
      localMusicItemInfo.mProgress = 100;
      axxj.a(localMusicItemInfo).ePh();
      bool = paramBoolean;
      if (localMusicItemInfo.isMyMusicInfo())
      {
        bool = paramBoolean;
        if (localMusicItemInfo.fileSize > 0L)
        {
          File localFile = new File(paramString);
          if (localFile.length() != localMusicItemInfo.fileSize)
          {
            localMusicItemInfo.mProgress = -1;
            axxj.a(localMusicItemInfo).ePi();
            paramBoolean = false;
          }
          bool = paramBoolean;
          if (QLog.isColorLevel()) {
            QLog.d("QQMusicDownloadListener", 2, "file.length =" + localFile.length() + " info.fileSize=" + localMusicItemInfo.fileSize);
          }
        }
      }
    }
    for (bool = paramBoolean;; bool = paramBoolean)
    {
      this.ki.remove(paramString);
      this.kj.remove(paramString);
      this.b.c(paramString, bool, paramInt);
      return;
      label214:
      localMusicItemInfo.mProgress = -1;
      axxj.a(localMusicItemInfo).ePi();
    }
  }
  
  public void onCancel(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicDownloadListener", 2, "onCancel key=" + paramString);
    }
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.ki.get(paramString);
    if (localMusicItemInfo != null) {
      localMusicItemInfo.mProgress = -1;
    }
    this.ki.remove(paramString);
    this.kj.remove(paramString);
    this.b.onCancel(paramString);
    axxj.a(localMusicItemInfo).ePi();
  }
  
  public void onProgress(String paramString, int paramInt)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.ki.get(paramString);
    int i = paramInt;
    if (localMusicItemInfo != null)
    {
      i = paramInt;
      if (paramInt == 100)
      {
        i = paramInt;
        if (this.kj.contains(localMusicItemInfo.getLocalPath())) {
          i = 99;
        }
      }
      localMusicItemInfo.mProgress = i;
    }
    this.b.onProgress(paramString, i);
  }
  
  public void vS(int paramInt)
  {
    this.b.vS(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axrn
 * JD-Core Version:    0.7.0.1
 */