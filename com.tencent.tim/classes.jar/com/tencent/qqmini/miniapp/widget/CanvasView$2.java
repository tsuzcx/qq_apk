package com.tencent.qqmini.miniapp.widget;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import org.json.JSONObject;

class CanvasView$2
  implements Runnable
{
  CanvasView$2(CanvasView paramCanvasView, boolean paramBoolean, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = CanvasView.access$000(this.this$0, this.this$0, this.val$isPngFile);
    ThreadManager.getSubThreadHandler().post(new CanvasView.2.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.2
 * JD-Core Version:    0.7.0.1
 */