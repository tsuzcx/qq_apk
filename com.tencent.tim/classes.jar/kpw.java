import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kpw
  implements View.OnClickListener
{
  public kpw(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadInJoyDeliverBiuActivity.e(this.this$0)) && ((!ReadInJoyDeliverBiuActivity.f(this.this$0)) || (ReadInJoyDeliverBiuActivity.m(this.this$0) != -1))) {
      this.this$0.pw(ReadInJoyDeliverBiuActivity.n(this.this$0));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.finish();
      kbp.a(null, "", "0X8008661", "0X8008661", 0, 0, ReadInJoyDeliverBiuActivity.n(this.this$0) + "", "", "", ReadInJoyBaseDeliverActivity.ig(), false);
      ReadInJoyDeliverBiuActivity.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpw
 * JD-Core Version:    0.7.0.1
 */