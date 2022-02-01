import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kif
  implements View.OnClickListener
{
  public kif(ReadInJoyNewBaseActivity paramReadInJoyNewBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kif
 * JD-Core Version:    0.7.0.1
 */