import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;

public class vhn
  implements vgw<TVK_UserInfo, TVK_PlayerVideoInfo>
{
  public vgu<TVK_UserInfo, TVK_PlayerVideoInfo> a()
  {
    return new vhp();
  }
  
  public vgv a(Context paramContext, vhc paramvhc)
  {
    paramvhc = null;
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null) {
      paramvhc = localTVK_IProxyFactory.createMediaPlayer(paramContext, null);
    }
    return new vho(paramvhc);
  }
  
  public vgy a(Context paramContext)
  {
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null) {
      return new vhq(localTVK_IProxyFactory.getCacheMgr(paramContext));
    }
    return null;
  }
  
  public vhc a(Context paramContext, boolean paramBoolean)
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
      return new vhu(localIVideoViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhn
 * JD-Core Version:    0.7.0.1
 */