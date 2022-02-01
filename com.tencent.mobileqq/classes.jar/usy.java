import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class usy
  implements View.OnClickListener
{
  usy(usx paramusx) {}
  
  public void onClick(View paramView)
  {
    usx.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usy
 * JD-Core Version:    0.7.0.1
 */