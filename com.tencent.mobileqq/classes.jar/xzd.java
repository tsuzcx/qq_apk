import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;

class xzd
  implements View.OnClickListener
{
  xzd(xzc paramxzc) {}
  
  public void onClick(View paramView)
  {
    xyw localxyw = new xyw();
    if (this.a.a.a) {
      this.a.a.a = false;
    }
    for (localxyw.a = 0;; localxyw.a = 1)
    {
      wfo.a().dispatch(localxyw);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzd
 * JD-Core Version:    0.7.0.1
 */