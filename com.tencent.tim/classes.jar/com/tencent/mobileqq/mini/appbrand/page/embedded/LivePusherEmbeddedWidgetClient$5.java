package com.tencent.mobileqq.mini.appbrand.page.embedded;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePushListenerReflect.ITXSnapshotListener;

class LivePusherEmbeddedWidgetClient$5
  implements TXLivePushListenerReflect.ITXSnapshotListener
{
  LivePusherEmbeddedWidgetClient$5(LivePusherEmbeddedWidgetClient paramLivePusherEmbeddedWidgetClient, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    ThreadManagerV2.excute(new LivePusherEmbeddedWidgetClient.5.1(this, paramBitmap), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.LivePusherEmbeddedWidgetClient.5
 * JD-Core Version:    0.7.0.1
 */