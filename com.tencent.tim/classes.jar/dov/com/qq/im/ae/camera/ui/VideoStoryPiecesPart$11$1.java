package dov.com.qq.im.ae.camera.ui;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import awwq;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import wja;

class VideoStoryPiecesPart$11$1
  implements Runnable
{
  VideoStoryPiecesPart$11$1(VideoStoryPiecesPart.11 param11) {}
  
  public void run()
  {
    if ((awwq.a(this.a.this$0) != null) && (awwq.a(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(awwq.a(this.a.this$0));
      int i = wja.dp2px(36.0F, awwq.a(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      awwq.a(this.a.this$0).setImageDrawable(localBitmapDrawable);
      awwq.a(this.a.this$0).setEnabled(true);
      return;
    }
    awwq.a(this.a.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.11.1
 * JD-Core Version:    0.7.0.1
 */