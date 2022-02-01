import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aoyp
  implements View.OnClickListener
{
  aoyp(aoyo paramaoyo) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.bu((Activity)aoyo.a(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoyp
 * JD-Core Version:    0.7.0.1
 */