import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.activity.SplashActivity;

public class bkr
  implements View.OnClickListener
{
  public bkr(SplashActivity paramSplashActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = null;
    switch (paramView.getId())
    {
    default: 
      paramView = localObject;
    }
    for (;;)
    {
      this.a.onTabChanged(paramView);
      return;
      paramView = Conversation.class.getName();
      continue;
      paramView = Contacts.class.getName();
      continue;
      paramView = QQSetting.class.getName();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bkr
 * JD-Core Version:    0.7.0.1
 */