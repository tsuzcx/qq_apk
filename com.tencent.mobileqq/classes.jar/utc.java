import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;

public class utc
  implements usl<TVK_UserInfo, TVK_PlayerVideoInfo>
{
  public usj<TVK_UserInfo, TVK_PlayerVideoInfo> a()
  {
    return new ute();
  }
  
  public usk a(Context paramContext, usr paramusr)
  {
    paramusr = null;
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null) {
      paramusr = localTVK_IProxyFactory.createMediaPlayer(paramContext, null);
    }
    return new utd(paramusr);
  }
  
  public usn a(Context paramContext)
  {
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null) {
      return new utf(localTVK_IProxyFactory.getCacheMgr(paramContext));
    }
    return null;
  }
  
  public usr a(Context paramContext, boolean paramBoolean)
  {
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    IVideoViewBase localIVideoViewBase = null;
    if (localTVK_IProxyFactory != null) {
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (localIVideoViewBase = localTVK_IProxyFactory.createVideoView_Scroll(paramContext);; localIVideoViewBase = localTVK_IProxyFactory.createVideoView(paramContext)) {
      return new utj(localIVideoViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utc
 * JD-Core Version:    0.7.0.1
 */