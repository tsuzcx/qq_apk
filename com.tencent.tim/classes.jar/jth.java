import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jth
  implements View.OnClickListener
{
  jth(jtg paramjtg) {}
  
  public void onClick(View paramView)
  {
    ((AccountDetailActivity)this.this$0.s).aAo();
    String str2 = this.this$0.uin;
    if (this.this$0.b.followType == 1) {}
    for (String str1 = "02";; str1 = "01")
    {
      kbp.a(null, str2, "0X8007CA4", "0X8007CA4", 0, 0, str1, String.valueOf(jtg.a(this.this$0)), "", "", false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jth
 * JD-Core Version:    0.7.0.1
 */