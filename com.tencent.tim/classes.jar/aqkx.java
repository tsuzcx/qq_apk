import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqkx
  implements View.OnClickListener
{
  aqkx(aqku paramaqku, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    ResultRecord localResultRecord = (ResultRecord)paramView.getTag();
    this.a.hideSoftInputFromWindow();
    MiniChatActivity.a(this.val$activity, localResultRecord.lk(), localResultRecord.uin, localResultRecord.name, 0.86F, this.a.a(this.val$activity, 0.78F));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqkx
 * JD-Core Version:    0.7.0.1
 */