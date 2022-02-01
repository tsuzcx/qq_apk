package com.tencent.mobileqq.mini.appbrand.page.embedded;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter.ISnapshotOuterListener;

class LivePlayerEmbeddedWidgetClient$2
  implements TXLivePlayerJSAdapter.ISnapshotOuterListener
{
  LivePlayerEmbeddedWidgetClient$2(LivePlayerEmbeddedWidgetClient paramLivePlayerEmbeddedWidgetClient, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    ThreadManagerV2.excute(new LivePlayerEmbeddedWidgetClient.2.1(this, paramBitmap), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.LivePlayerEmbeddedWidgetClient.2
 * JD-Core Version:    0.7.0.1
 */