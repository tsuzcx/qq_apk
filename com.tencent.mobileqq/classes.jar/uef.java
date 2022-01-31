import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import mqq.os.MqqHandler;

public class uef
  implements TVK_IMediaPlayer.OnCompletionListener
{
  uef(ued paramued) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ued.a(this.a).d = paramTVK_IMediaPlayer.getDuration();
    ued.a(this.a).e = paramTVK_IMediaPlayer.getCurrentPostion();
    paramTVK_IMediaPlayer = this.a.a;
    if (paramTVK_IMediaPlayer != null) {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.2.1(this, paramTVK_IMediaPlayer));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uef
 * JD-Core Version:    0.7.0.1
 */