import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tza
  implements View.OnClickListener
{
  tza(tyo paramtyo) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tza
 * JD-Core Version:    0.7.0.1
 */