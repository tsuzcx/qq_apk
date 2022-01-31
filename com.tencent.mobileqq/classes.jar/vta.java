import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.5.1;
import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.5.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import mqq.os.MqqHandler;

public class vta
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  vta(vsv paramvsv) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManager.executeOnSubThread(new VideoViewTVKImpl.5.1(this, paramTVK_IMediaPlayer));
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.5.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vta
 * JD-Core Version:    0.7.0.1
 */