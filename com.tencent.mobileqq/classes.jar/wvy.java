import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.3.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import mqq.os.MqqHandler;

public class wvy
  implements TVK_IMediaPlayer.OnErrorListener
{
  wvy(wvv paramwvv) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.3.1(this, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvy
 * JD-Core Version:    0.7.0.1
 */