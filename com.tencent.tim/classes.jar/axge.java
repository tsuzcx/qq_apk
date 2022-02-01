import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.mode.AECaptureMode;

class axge
  implements View.OnClickListener
{
  axge(axga.a parama, AECaptureMode paramAECaptureMode, int paramInt) {}
  
  public void onClick(View paramView)
  {
    axga.a(this.a.a, this.i);
    if (this.i == AECaptureMode.GIF) {
      axim.a().eKU();
    }
    for (;;)
    {
      axiy.i("AEVideoStoryCaptureModePart", "【AE_CAPTURE_MODE】:" + this.val$position);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.i == AECaptureMode.NORMAL) {
        axim.a().eKT();
      } else if (this.i == AECaptureMode.PLAY) {
        axim.a().eLb();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axge
 * JD-Core Version:    0.7.0.1
 */