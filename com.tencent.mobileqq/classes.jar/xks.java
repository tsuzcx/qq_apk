import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import mqq.os.MqqHandler;

public class xks
  implements TVK_IMediaPlayer.OnCompletionListener
{
  xks(xkq paramxkq) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    xkq.a(this.a).d = paramTVK_IMediaPlayer.getDuration();
    xkq.a(this.a).e = paramTVK_IMediaPlayer.getCurrentPostion();
    paramTVK_IMediaPlayer = this.a.a;
    if (paramTVK_IMediaPlayer != null) {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.2.1(this, paramTVK_IMediaPlayer));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xks
 * JD-Core Version:    0.7.0.1
 */