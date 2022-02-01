import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jsy
  implements View.OnClickListener
{
  public jsy(EqqAccountDetailActivity paramEqqAccountDetailActivity, jzs.a parama) {}
  
  public void onClick(View paramView)
  {
    this.this$0.aCX = this.a.state;
    this.this$0.a(this.a, this.this$0.aCX);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsy
 * JD-Core Version:    0.7.0.1
 */