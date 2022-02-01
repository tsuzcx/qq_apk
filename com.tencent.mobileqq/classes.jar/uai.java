import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class uai
  extends sfi
{
  private uai(VideoPlayManager paramVideoPlayManager) {}
  
  public void a(spn paramspn, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onVideoPrepared(VideoPlayerWrapper player, Object tag) ");
    }
    paramspn = VideoPlayManager.a(this.a);
    if ((paramspn != null) && (QLog.isColorLevel())) {
      QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onVideoPrepared() vid=" + paramspn.a.a + ", mIsOpenedVideo = " + VideoPlayManager.a(this.a));
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
      ((uam)paramObject.next()).c(paramspn);
    }
    if (VideoPlayManager.b(this.a))
    {
      this.a.a();
      return;
    }
    VideoPlayManager.b(this.a, true);
  }
  
  public void a(spn paramspn, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "onConnectQualityCallback json= " + paramString);
    }
    if (VideoPlayManager.a(this.a) != null) {
      srq.a().a(paramspn, VideoPlayManager.a(this.a).a.d, paramspn.d());
    }
  }
  
  public boolean a(spn paramspn, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramString = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramspn = paramObject.toString();; paramspn = "")
    {
      paramString = paramspn;
      paramspn = VideoPlayManager.a(this.a);
      if ((paramspn != null) && (paramspn.a != null) && (QLog.isColorLevel())) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onError() " + paramString + ", vid=" + paramspn.a.a);
      }
      paramString = ssq.a(paramInt1, paramInt2, paramInt3);
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((uam)paramObject.next()).a(paramspn, paramInt1, paramInt2, paramString);
      }
    }
    return false;
  }
  
  public boolean a(spn paramspn, int paramInt, Object paramObject)
  {
    paramspn = VideoPlayManager.a(this.a);
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
        ((uam)paramObject.next()).f(paramspn);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "播放状态回调 onInfo() PLAYER_INFO_ENDOF_BUFFERING");
      }
      paramObject = VideoPlayManager.a(this.a).iterator();
      while (paramObject.hasNext()) {
        ((uam)paramObject.next()).g(paramspn);
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
  
  public void b(spn paramspn)
  {
    ual localual = VideoPlayManager.a(this.a);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("播放状态回调 onCompletion() vid=");
      if (localual == null) {
        break label93;
      }
    }
    label93:
    for (paramspn = localual.a.a;; paramspn = "param null")
    {
      QLog.d("Viola.VideoPlayManager", 2, paramspn);
      paramspn = VideoPlayManager.a(this.a).iterator();
      while (paramspn.hasNext()) {
        ((uam)paramspn.next()).h(localual);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uai
 * JD-Core Version:    0.7.0.1
 */