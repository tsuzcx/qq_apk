import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class khi
  implements View.OnClickListener
{
  public khi(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyBaseDeliverActivity.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     khi
 * JD-Core Version:    0.7.0.1
 */