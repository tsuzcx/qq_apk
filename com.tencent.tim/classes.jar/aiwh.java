import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiwh
  implements View.OnClickListener
{
  aiwh(aiwd paramaiwd, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    LoginUserGuideHelper.b(this.val$activity, this.this$0.a.app, aiwd.a(this.this$0));
    this.this$0.dvd();
    anot.a(this.this$0.a.app, "dc00898", "", "", "0X8009F4A", "0X8009F4A", 1, 0, "1", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwh
 * JD-Core Version:    0.7.0.1
 */