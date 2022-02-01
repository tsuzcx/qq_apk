import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.BaseActivityView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zpp
  implements View.OnClickListener
{
  public zpp(BaseActivityView paramBaseActivityView) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpp
 * JD-Core Version:    0.7.0.1
 */