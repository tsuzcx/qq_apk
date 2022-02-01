import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jsv
  implements View.OnClickListener
{
  public jsv(EqqAccountDetailActivity paramEqqAccountDetailActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.b != null)
    {
      Intent localIntent = new Intent(this.this$0, ChatHistory.class);
      localIntent.putExtra("uin", EqqAccountDetailActivity.i(this.this$0));
      localIntent.putExtra("uintype", 1024);
      this.this$0.startActivity(localIntent);
      kbp.a(EqqAccountDetailActivity.i(this.this$0), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.j(this.this$0), "0X8005A29", "0X8005A29", 0, 0, "", "", "", "", false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsv
 * JD-Core Version:    0.7.0.1
 */