import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yea
  implements View.OnClickListener
{
  yea(ydz paramydz) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.aSY) {
      ujt.a(this.a.sessionInfo, this.a.app, this.a.a());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yea
 * JD-Core Version:    0.7.0.1
 */