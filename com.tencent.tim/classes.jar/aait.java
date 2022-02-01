import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aait
  implements View.OnClickListener
{
  aait(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aahb.a(this.this$0), NotifyPushSettingActivity.class);
    aahb.a(this.this$0).startActivity(localIntent);
    anot.a(aahb.a(this.this$0).app, "CliOper", "", "", "0X8009EBB", "0X8009EBB", 0, 1, "", "", "", "");
    anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 2, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aait
 * JD-Core Version:    0.7.0.1
 */