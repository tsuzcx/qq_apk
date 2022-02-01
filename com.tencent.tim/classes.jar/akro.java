import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akro
  implements View.OnClickListener
{
  public akro(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onClick(View paramView)
  {
    AccountOnlineStateActivity.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akro
 * JD-Core Version:    0.7.0.1
 */