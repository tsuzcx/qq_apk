import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.appbrand.page.embedded.VideoEmbeddedWidgetClient;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoPlayerProviderProxy;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer;

@ProxyService(proxy=VideoPlayerProviderProxy.class)
public class asxm
  implements VideoPlayerProviderProxy
{
  private boolean inited;
  
  public String getUrl(String paramString)
  {
    return OskPlayerCore.getInstance().getUrl(MiniAppFileManager.getInstance().getAbsolutePath(paramString));
  }
  
  public ReliableVideoPlayer getVideoPlayer()
  {
    if (!this.inited)
    {
      VideoEmbeddedWidgetClient.initOskOnce(BaseApplicationImpl.getContext());
      this.inited = true;
    }
    return new asvx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxm
 * JD-Core Version:    0.7.0.1
 */