import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.BaseVMPeakActivity;

class axee
  implements View.OnClickListener
{
  axee(axec paramaxec) {}
  
  public void onClick(View paramView)
  {
    axec.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axee
 * JD-Core Version:    0.7.0.1
 */