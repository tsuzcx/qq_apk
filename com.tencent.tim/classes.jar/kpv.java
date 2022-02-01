import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kpv
  implements View.OnClickListener
{
  public kpv(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadInJoyDeliverBiuActivity.c(this.this$0)) && ((!ReadInJoyDeliverBiuActivity.d(this.this$0)) || (ReadInJoyDeliverBiuActivity.k(this.this$0) != -1))) {
      this.this$0.pw(ReadInJoyDeliverBiuActivity.l(this.this$0));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      kbp.a(null, "", "0X8008661", "0X8008661", 0, 0, ReadInJoyDeliverBiuActivity.l(this.this$0) + "", "", "", ReadInJoyBaseDeliverActivity.ig(), false);
      this.this$0.finish();
      ReadInJoyDeliverBiuActivity.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpv
 * JD-Core Version:    0.7.0.1
 */