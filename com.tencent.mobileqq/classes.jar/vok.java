import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vok
  implements View.OnClickListener
{
  vok(voj paramvoj) {}
  
  public void onClick(View paramView)
  {
    voj.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vok
 * JD-Core Version:    0.7.0.1
 */