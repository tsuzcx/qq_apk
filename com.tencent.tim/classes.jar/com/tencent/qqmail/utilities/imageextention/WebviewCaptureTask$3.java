package com.tencent.qqmail.utilities.imageextention;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.TitleBarWebView2;
import rx.Subscriber;

class WebviewCaptureTask$3
  extends Subscriber<Long>
{
  WebviewCaptureTask$3(WebviewCaptureTask paramWebviewCaptureTask, Bitmap paramBitmap, Canvas paramCanvas, Paint paramPaint) {}
  
  public void onCompleted()
  {
    Log.v("WebviewCaptureTask", "scrollByInterval complete");
    WebviewCaptureTask.access$100(this.this$0, this.val$image);
    Threads.runOnMainThread(new WebviewCaptureTask.3.1(this), 300L);
  }
  
  public void onError(Throwable paramThrowable)
  {
    QMLog.log(5, "WebviewCaptureTask", "scrollByInterval:" + paramThrowable.getMessage(), paramThrowable);
    WebviewCaptureTask.access$100(this.this$0, null);
    Threads.runOnMainThread(new WebviewCaptureTask.3.2(this), 300L);
  }
  
  public void onNext(Long paramLong)
  {
    int i = paramLong.intValue();
    WebviewCaptureTask.access$400(this.this$0, this.val$canvas, this.val$paint, i);
    i += 1;
    if (i < WebviewCaptureTask.access$500(this.this$0)) {
      WebviewCaptureTask.access$700(this.this$0).scrollTo(0, WebviewCaptureTask.access$600(this.this$0, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.imageextention.WebviewCaptureTask.3
 * JD-Core Version:    0.7.0.1
 */