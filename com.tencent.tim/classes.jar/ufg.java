import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ufg
  implements View.OnClickListener
{
  public ufg(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.app, "CliOper", "", "", "0X800AA46", "0X800AA46", 0, 0, "", "", "", "");
    this.this$0.bFN();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufg
 * JD-Core Version:    0.7.0.1
 */