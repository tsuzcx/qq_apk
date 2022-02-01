import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ucw
  implements View.OnClickListener
{
  public ucw(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bFv();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucw
 * JD-Core Version:    0.7.0.1
 */