import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class utm
  implements View.OnClickListener
{
  utm(uta paramuta) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utm
 * JD-Core Version:    0.7.0.1
 */