import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;

class astv
  implements IMediaPlayerUtil
{
  astv(astt paramastt) {}
  
  public int getContentFlag(String paramString)
  {
    return VideoManager.getInstance().probeContentFlag(paramString);
  }
  
  public String getUrl(String paramString)
  {
    return OskPlayerCore.getInstance().getUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     astv
 * JD-Core Version:    0.7.0.1
 */