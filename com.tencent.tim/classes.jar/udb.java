import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class udb
  implements View.OnClickListener
{
  public udb(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    PublicFragmentActivity.startForResult(this.this$0, localIntent, AccountOnlineStateActivity.class, 0);
    aktm.dA(this.this$0.app);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udb
 * JD-Core Version:    0.7.0.1
 */