import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ypr
  implements View.OnClickListener
{
  ypr(ypq paramypq, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.onItemClick(paramView, this.val$position);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypr
 * JD-Core Version:    0.7.0.1
 */