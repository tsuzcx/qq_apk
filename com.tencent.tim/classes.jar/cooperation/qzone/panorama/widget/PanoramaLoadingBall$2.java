package cooperation.qzone.panorama.widget;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

class PanoramaLoadingBall$2
  extends TimerTask
{
  boolean isSlow = false;
  
  PanoramaLoadingBall$2(PanoramaLoadingBall paramPanoramaLoadingBall) {}
  
  public void run()
  {
    if (!PanoramaLoadingBall.a(this.this$0))
    {
      if (!this.isSlow)
      {
        if (PanoramaLoadingBall.b(this.this$0) == 0) {
          PanoramaLoadingBall.a(this.this$0, PanoramaLoadingBall.a(this.this$0) + 2.0F);
        }
      }
      else
      {
        if (PanoramaLoadingBall.a(this.this$0) <= PanoramaLoadingBall.b(this.this$0)) {
          break label152;
        }
        PanoramaLoadingBall.a(this.this$0, PanoramaLoadingBall.a(this.this$0) - 0.3F);
        this.isSlow = true;
        if (PanoramaLoadingBall.a(this.this$0) <= PanoramaLoadingBall.b(this.this$0))
        {
          PanoramaLoadingBall.a(this.this$0, 1);
          this.isSlow = false;
        }
      }
      for (;;)
      {
        PanoramaLoadingBall.a(this.this$0).sendEmptyMessage(291);
        return;
        PanoramaLoadingBall.a(this.this$0, PanoramaLoadingBall.a(this.this$0) - 2.0F);
        break;
        label152:
        if (PanoramaLoadingBall.a(this.this$0) < 0.0F)
        {
          PanoramaLoadingBall.a(this.this$0, PanoramaLoadingBall.a(this.this$0) + 0.3F);
          this.isSlow = true;
          if (PanoramaLoadingBall.a(this.this$0) >= 0.0F)
          {
            PanoramaLoadingBall.a(this.this$0, 0);
            this.isSlow = false;
          }
        }
      }
    }
    PanoramaLoadingBall.a(this.this$0).cancel();
    cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingBall.2
 * JD-Core Version:    0.7.0.1
 */