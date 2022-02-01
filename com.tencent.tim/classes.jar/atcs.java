import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.call.activity.CallActivity;

public class atcs
  implements View.OnClickListener
{
  public atcs(CallActivity paramCallActivity) {}
  
  public void onClick(View paramView)
  {
    anot.a(null, "dc01331", "", "", "0X800551F", "0X800551F", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcs
 * JD-Core Version:    0.7.0.1
 */