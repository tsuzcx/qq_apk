package dov.com.qq.im.ae.camera.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import aqhu;
import aqnm;
import awry;
import awwq;

public class VideoStoryPiecesPart$11
  implements Runnable
{
  public VideoStoryPiecesPart$11(awwq paramawwq) {}
  
  public void run()
  {
    try
    {
      awwq.a(this.this$0, awry.a(awwq.e(this.this$0), true));
      if ((awwq.a(this.this$0) != null) && (!awwq.a(this.this$0).isRecycled())) {
        awwq.a(this.this$0, aqhu.c(awwq.a(this.this$0), aqnm.dip2px(3.0F), awwq.a(this.this$0).getWidth(), awwq.a(this.this$0).getHeight()));
      }
      awwq.f(this.this$0).runOnUiThread(new VideoStoryPiecesPart.11.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.11
 * JD-Core Version:    0.7.0.1
 */