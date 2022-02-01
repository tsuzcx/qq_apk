import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aayi
  implements View.OnClickListener
{
  aayi(aayg paramaayg) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.bu((Activity)aayg.a(this.this$0));
    anot.a(aayg.a(this.this$0), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aayi
 * JD-Core Version:    0.7.0.1
 */