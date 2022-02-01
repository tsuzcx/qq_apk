import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auux
  implements View.OnClickListener
{
  auux(auuw paramauuw) {}
  
  public void onClick(View paramView)
  {
    if (this.g.isShowing()) {
      this.g.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auux
 * JD-Core Version:    0.7.0.1
 */