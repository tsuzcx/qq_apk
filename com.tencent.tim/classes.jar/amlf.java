import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amlf
  implements View.OnClickListener
{
  public amlf(BaseSearchActivity paramBaseSearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amlf
 * JD-Core Version:    0.7.0.1
 */