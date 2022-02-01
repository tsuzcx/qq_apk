import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avdy
  implements View.OnClickListener
{
  avdy(avdx paramavdx) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a.s != null) && (!this.a.a.s.isFinishing())) {
      this.a.a.s.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avdy
 * JD-Core Version:    0.7.0.1
 */