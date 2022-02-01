import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeft
  implements View.OnClickListener
{
  public aeft(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeft
 * JD-Core Version:    0.7.0.1
 */