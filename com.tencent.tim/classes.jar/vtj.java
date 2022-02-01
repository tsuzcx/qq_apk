import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vtj
  implements View.OnClickListener
{
  public vtj(SelectedAndSearchBar paramSelectedAndSearchBar, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.cM != null) {
      this.cM.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vtj
 * JD-Core Version:    0.7.0.1
 */