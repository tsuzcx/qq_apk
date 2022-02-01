import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.qzone.panorama.widget.PanoramaLoadingBall;

public class avxe
  extends Handler
{
  public avxe(PanoramaLoadingBall paramPanoramaLoadingBall, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.what == 291) && (Build.VERSION.SDK_INT >= 11))
    {
      if (PanoramaLoadingBall.a(this.this$0)) {
        PanoramaLoadingBall.a(this.this$0, 60.0F);
      }
      if (PanoramaLoadingBall.a(this.this$0) == 0) {
        this.this$0.setRotationX(PanoramaLoadingBall.a(this.this$0));
      }
    }
    else
    {
      return;
    }
    this.this$0.setRotationY(PanoramaLoadingBall.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxe
 * JD-Core Version:    0.7.0.1
 */