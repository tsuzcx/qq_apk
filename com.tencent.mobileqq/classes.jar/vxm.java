import com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.8.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import mqq.os.MqqHandler;

public class vxm
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  vxm(vxe paramvxe) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.8.1(this, paramTVK_IMediaPlayer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxm
 * JD-Core Version:    0.7.0.1
 */