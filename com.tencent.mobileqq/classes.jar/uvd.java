import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uvd
  implements View.OnClickListener
{
  uvd(uvc paramuvc) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() instanceof uuo)) {
      ((uuo)this.a.a()).f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvd
 * JD-Core Version:    0.7.0.1
 */