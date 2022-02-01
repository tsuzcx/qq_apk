import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import cooperation.qzone.panorama.widget.PanoramaGuideAnimate;
import cooperation.qzone.panorama.widget.PanoramaGuideAnimate.a;

public class avxd
  extends Handler
{
  public avxd(PanoramaGuideAnimate paramPanoramaGuideAnimate) {}
  
  @TargetApi(11)
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      PanoramaGuideAnimate.a(this.this$0).setRotationY(PanoramaGuideAnimate.a(this.this$0));
      PanoramaGuideAnimate.a(this.this$0).setTranslationX(PanoramaGuideAnimate.b(this.this$0));
      return;
      if (PanoramaGuideAnimate.c(this.this$0) > 0.0F) {
        break;
      }
    } while (PanoramaGuideAnimate.a(this.this$0) == null);
    PanoramaGuideAnimate.a(this.this$0).Qg();
    return;
    PanoramaGuideAnimate.a(this.this$0, PanoramaGuideAnimate.c(this.this$0) - 0.05F);
    this.this$0.setAlpha(PanoramaGuideAnimate.c(this.this$0));
    PanoramaGuideAnimate.a(this.this$0).sendEmptyMessage(292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxd
 * JD-Core Version:    0.7.0.1
 */