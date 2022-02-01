import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wtp
  implements View.OnClickListener
{
  wtp(wtn paramwtn) {}
  
  public void onClick(View paramView)
  {
    this.this$0.ab.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wtp
 * JD-Core Version:    0.7.0.1
 */