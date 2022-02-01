import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;

class xej
  implements View.OnClickListener
{
  xej(xei paramxei) {}
  
  public void onClick(View paramView)
  {
    xec localxec = new xec();
    if (this.a.a.a) {
      this.a.a.a = false;
    }
    for (localxec.a = 0;; localxec.a = 1)
    {
      vli.a().dispatch(localxec);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xej
 * JD-Core Version:    0.7.0.1
 */