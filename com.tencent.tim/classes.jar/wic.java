import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wic
  implements View.OnClickListener
{
  public wic(SendBirthdayWishesActivity paramSendBirthdayWishesActivity) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.app, "CliOper", "", "", "0X8004E0A", "0X8004E0A", 0, 0, "", "", "", "");
    this.this$0.setResult(0);
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wic
 * JD-Core Version:    0.7.0.1
 */