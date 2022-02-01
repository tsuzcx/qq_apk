import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axha
  implements View.OnClickListener
{
  axha(axgv paramaxgv) {}
  
  public void onClick(View paramView)
  {
    axgv.e(this.this$0);
    axgv.b(this.this$0).setVisibility(8);
    axis.a().ai("CameraModuleSvc.GetPlayShowCatMatTree", "", 4);
    PeakAppInterface.a.aeC(1010);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axha
 * JD-Core Version:    0.7.0.1
 */