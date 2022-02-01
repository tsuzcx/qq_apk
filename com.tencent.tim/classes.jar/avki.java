import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.widget.LocationDetailActivity;

public class avki
  implements View.OnClickListener
{
  public avki(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.WE(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avki
 * JD-Core Version:    0.7.0.1
 */