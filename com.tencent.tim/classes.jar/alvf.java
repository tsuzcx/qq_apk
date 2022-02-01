import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alvf
  implements View.OnClickListener
{
  public alvf(IosTimepicker paramIosTimepicker) {}
  
  public void onClick(View paramView)
  {
    if ((IosTimepicker.a(this.b) != null) && (IosTimepicker.a(this.b).isShowing()))
    {
      IosTimepicker.a(this.b).dismiss();
      IosTimepicker.a(this.b, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvf
 * JD-Core Version:    0.7.0.1
 */