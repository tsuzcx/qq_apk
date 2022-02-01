package dov.com.qq.im.ae.camera.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import awwq;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import wja;

public class VideoStoryPiecesPart$2
  implements Runnable
{
  public VideoStoryPiecesPart$2(awwq paramawwq) {}
  
  public void run()
  {
    Drawable localDrawable = awwq.a(this.this$0).getResources().getDrawable(2130850065);
    int i = wja.dp2px(36.0F, awwq.b(this.this$0).getResources());
    localDrawable.setBounds(0, 0, i, i);
    awwq.a(this.this$0).setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.2
 * JD-Core Version:    0.7.0.1
 */