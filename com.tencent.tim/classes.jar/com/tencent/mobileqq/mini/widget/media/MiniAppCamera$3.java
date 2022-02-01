package com.tencent.mobileqq.mini.widget.media;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.util.Log;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;

class MiniAppCamera$3
  implements MediaRecorder.OnErrorListener
{
  MiniAppCamera$3(MiniAppCamera paramMiniAppCamera, WebviewContainer paramWebviewContainer, String paramString) {}
  
  public void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    Log.i("MiniAppCamera", "onError: " + paramInt1);
    this.val$wc.callbackJsEventFail(this.val$event, null, MiniAppCamera.access$100());
    MiniAppCamera.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppCamera.3
 * JD-Core Version:    0.7.0.1
 */