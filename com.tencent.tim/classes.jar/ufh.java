import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ufh
  implements View.OnClickListener
{
  public ufh(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bFO();
    anot.a(this.this$0.app, "CliOper", "", "", "0X800AA44", "0X800AA44", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufh
 * JD-Core Version:    0.7.0.1
 */