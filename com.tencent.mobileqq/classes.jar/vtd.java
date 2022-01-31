import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.8.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import mqq.os.MqqHandler;

public class vtd
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  vtd(vsv paramvsv) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.8.1(this, paramTVK_IMediaPlayer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vtd
 * JD-Core Version:    0.7.0.1
 */