import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jte
  implements View.OnClickListener
{
  public jte(EqqAccountDetailActivity paramEqqAccountDetailActivity, boolean paramBoolean1, String paramString, boolean paramBoolean2, jzs.a parama) {}
  
  public void onClick(View paramView)
  {
    this.this$0.b(this.abD, this.val$phone, this.abE);
    EqqAccountDetailActivity.d(this.this$0, this.a.title);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jte
 * JD-Core Version:    0.7.0.1
 */