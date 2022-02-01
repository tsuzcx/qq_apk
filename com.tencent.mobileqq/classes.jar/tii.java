import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class tii
  extends rlt
{
  private tii(VideoPlayManager paramVideoPlayManager) {}
  
  public void a(rwf paramrwf, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    paramrwf = VideoPlayManager.a(this.a);
    if ((paramrwf != null) && (QLog.isColorLevel())) {
      QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramrwf.a.a + ", mIsOpenedVideo = " + VideoPlayManager.a(this.a));
    }
    if (!VideoPlayManager.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared  return isOpenedVideo false");
      }
      return;
    }
    VideoPlayManager.a(this.a, false);
    VideoPlayManager.a(this.a).removeMessages(0);
    VideoPlayManager.a(this.a).sendEmptyMessage(0);
    paramObject = VideoPlayManager.a(this.a).iterator();
    while (paramObject.hasNext()) {
      ((tim)paramObject.next()).c(paramrwf);
    }
    if (VideoPlayManager.b(this.a))
    {
      this.a.a();
      return;
    }
    VideoPlayManager.b(this.a, true);
  }
  
  public void a(rwf paramrwf, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
    if (VideoPlayManager.a(this.a) != null) {
      ryh.a().a(paramrwf, VideoPlayManager.a(this.a).a.d, paramrwf.d());
    }
  }
  
  public boolean a(rwf paramrwf, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramrwf = paramObject.toString();; paramrwf = "")
    {
      paramString = paramrwf;
      paramrwf = VideoPlayManager.a(this.a);
      if ((paramrwf != null) && (paramrwf.a != null) && (QLog.isColorLevel())) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onError() " + paramString + ", vid=" + paramrwf.a.a);
      }
      paramString = rzh.a(paramInt1, paramInt2, paramInt3);
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((tim)paramObject.next()).a(paramrwf, paramInt1, paramInt2, paramString);
      }
    }
    return false;
  }
  
  public boolean a(rwf paramrwf, int paramInt, Object paramObject)
  {
    paramrwf = VideoPlayManager.a(this.a);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_START_BUFFERING");
      }
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((tim)paramObject.next()).f(paramrwf);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((tim)paramObject.next()).g(paramrwf);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
        }
      }
    }
  }
  
  public void b(rwf paramrwf)
  {
    til localtil = VideoPlayManager.a(this.a);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (localtil == null) {
        break label93;
      }
    }
    label93:
    for (paramrwf = localtil.a.a;; paramrwf = "param null")
    {
      QLog.d("Viola.VideoPlayManager", 2, paramrwf);
      paramrwf = VideoPlayManager.a(this.a).iterator();
      while (paramrwf.hasNext()) {
        ((tim)paramrwf.next()).h(localtil);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tii
 * JD-Core Version:    0.7.0.1
 */