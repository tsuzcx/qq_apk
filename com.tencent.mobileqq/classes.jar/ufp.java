import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ufp
  implements View.OnClickListener
{
  ufp(ufd paramufd) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufp
 * JD-Core Version:    0.7.0.1
 */