package dov.com.qq.im.ae.gif.video;

import android.graphics.Bitmap;
import axfx;
import axfx.b;
import com.tencent.view.RendererUtils;

public class VideoGIFCreator$2
  implements Runnable
{
  public VideoGIFCreator$2(axfx paramaxfx, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    axfx.a(this.this$0, new axfx.b(this.this$0));
    axfx.a(this.this$0).eED = RendererUtils.createTexture(this.hk);
    axfx.a(this.this$0).x = this.val$x;
    axfx.a(this.this$0).y = this.val$y;
    axfx.a(this.this$0).width = this.eQ;
    axfx.a(this.this$0).height = this.eR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.2
 * JD-Core Version:    0.7.0.1
 */