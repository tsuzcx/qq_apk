import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xqj
  implements View.OnClickListener
{
  xqj(xqh paramxqh) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363744) {
      xqh.a(this.a).fx(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131363745) {
        xqh.a(this.a).fy(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqj
 * JD-Core Version:    0.7.0.1
 */