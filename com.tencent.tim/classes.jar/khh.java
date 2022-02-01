import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class khh
  implements View.OnClickListener
{
  public khh(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.afj = true;
    ReadInJoyBaseDeliverActivity.a(this.this$0);
    this.this$0.zp();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     khh
 * JD-Core Version:    0.7.0.1
 */