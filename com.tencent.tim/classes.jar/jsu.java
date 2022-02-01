import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jsu
  implements View.OnClickListener
{
  public jsu(EqqAccountDetailActivity paramEqqAccountDetailActivity, String paramString, jzs.a parama) {}
  
  public void onClick(View paramView)
  {
    EqqAccountDetailActivity.a(this.this$0, this.val$url);
    if ((this.a.title != null) && (this.a.title.contains(""))) {
      kbp.a(EqqAccountDetailActivity.a(this.this$0), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.a(this.this$0), "0X8005A29", "0X8005A29", 0, 0, "", "", "", "", false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      EqqAccountDetailActivity.b(this.this$0, this.a.title);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsu
 * JD-Core Version:    0.7.0.1
 */