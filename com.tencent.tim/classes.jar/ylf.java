import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ylf
  implements View.OnClickListener
{
  public ylf(BlessActivity paramBlessActivity) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.app, "CliOper", "", "", "0X800632F", "0X800632F", 0, 0, "", "", "", "");
    BlessActivity.a(this.this$0, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ylf
 * JD-Core Version:    0.7.0.1
 */