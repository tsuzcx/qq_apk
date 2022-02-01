package com.tencent.qqmini.map.proxyImpl;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmini.map.CoverMapView;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy.MapSnapshotCallback;

@ProxyService(proxy=MapProxy.class)
public class MapProxyImplDefault
  extends MapProxy
{
  public static final String TAG = "MapProxyImplDefault";
  
  public void captureImage(IMiniAppContext paramIMiniAppContext, View paramView, ViewGroup paramViewGroup, MapProxy.MapSnapshotCallback paramMapSnapshotCallback)
  {
    if ((paramView instanceof CoverMapView)) {
      ((CoverMapView)paramView).captureImage(new MapProxyImplDefault.1(this, paramViewGroup, paramMapSnapshotCallback, paramView, paramIMiniAppContext));
    }
    if (paramMapSnapshotCallback != null) {
      paramMapSnapshotCallback.onSnapshotReady(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.map.proxyImpl.MapProxyImplDefault
 * JD-Core Version:    0.7.0.1
 */