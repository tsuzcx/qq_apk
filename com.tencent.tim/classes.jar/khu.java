import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class khu
  implements View.OnClickListener
{
  public khu(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.a instanceof kfs)) {
      ((kfs)this.this$0.a).aCm();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     khu
 * JD-Core Version:    0.7.0.1
 */