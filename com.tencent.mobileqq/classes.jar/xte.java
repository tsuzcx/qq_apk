import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;

class xte
  implements View.OnClickListener
{
  xte(xtd paramxtd) {}
  
  public void onClick(View paramView)
  {
    xsx localxsx = new xsx();
    if (this.a.a.a) {
      this.a.a.a = false;
    }
    for (localxsx.a = 0;; localxsx.a = 1)
    {
      wad.a().dispatch(localxsx);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xte
 * JD-Core Version:    0.7.0.1
 */