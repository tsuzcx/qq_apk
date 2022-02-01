import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amkz
  implements View.OnClickListener
{
  public amkz(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amkz
 * JD-Core Version:    0.7.0.1
 */