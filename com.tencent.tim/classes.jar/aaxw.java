import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.2.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaxw
  implements View.OnClickListener
{
  public aaxw(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onBackEvent();
    if (AppSetting.enableTalkBack) {
      this.this$0.Bi.post(new SelectMemberActivity.2.1(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxw
 * JD-Core Version:    0.7.0.1
 */