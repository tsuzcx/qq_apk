package com.tencent.qqmini.sdk.core.generated;

import astt;
import asul;
import asuo;
import asuz;
import asvp;
import asvw;
import aswg;
import aswl;
import aswn;
import aswo;
import asxb;
import asxd;
import asxf;
import asxm;
import asxn;
import asxq;
import asxs;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.PayProxyImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.NavigationProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoPlayerProviderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import java.util.HashMap;
import java.util.Map;

public final class ExtProxyServiceScope
{
  public static final Map PROXY_SERVICES = new HashMap();
  
  static
  {
    PROXY_SERVICES.put(WebSocketProxy.class, asxq.class);
    PROXY_SERVICES.put(UploaderProxy.class, asxd.class);
    PROXY_SERVICES.put(MiniAppProxy.class, asuz.class);
    PROXY_SERVICES.put(DownloaderProxy.class, asul.class);
    PROXY_SERVICES.put(RequestProxy.class, aswl.class);
    PROXY_SERVICES.put(ChannelProxy.class, astt.class);
    PROXY_SERVICES.put(WnsConfigProxy.class, asxs.class);
    PROXY_SERVICES.put(AdProxy.class, AdProxyImpl.class);
    PROXY_SERVICES.put(PayProxy.class, PayProxyImpl.class);
    PROXY_SERVICES.put(VideoPlayerProviderProxy.class, asxm.class);
    PROXY_SERVICES.put(ShareProxy.class, aswo.class);
    PROXY_SERVICES.put(KingCardProxy.class, asuo.class);
    PROXY_SERVICES.put(ThirdAppProxy.class, asxb.class);
    PROXY_SERVICES.put(VoIPProxy.class, asxn.class);
    PROXY_SERVICES.put(VideoJsProxy.class, asxf.class);
    PROXY_SERVICES.put(NavigationProxy.class, asvw.class);
    PROXY_SERVICES.put(PageGestureProxy.class, aswg.class);
    PROXY_SERVICES.put(MusicPlayerProxy.class, asvp.class);
    PROXY_SERVICES.put(RequestStrategyProxy.class, aswn.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtProxyServiceScope
 * JD-Core Version:    0.7.0.1
 */