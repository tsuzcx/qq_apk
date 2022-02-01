import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;

class ycy
  implements View.OnClickListener
{
  ycy(ycx paramycx) {}
  
  public void onClick(View paramView)
  {
    ycr localycr = new ycr();
    if (this.a.a.a) {
      this.a.a.a = false;
    }
    for (localycr.a = 0;; localycr.a = 1)
    {
      wjj.a().dispatch(localycr);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycy
 * JD-Core Version:    0.7.0.1
 */