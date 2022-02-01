import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;

final class ayah
  implements View.OnClickListener
{
  ayah(AIOLongCaptureCtrl paramAIOLongCaptureCtrl) {}
  
  public void onClick(View paramView)
  {
    this.c.ePp();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayah
 * JD-Core Version:    0.7.0.1
 */