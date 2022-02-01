import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqws
  implements View.OnClickListener
{
  aqws(aqwr paramaqwr) {}
  
  public void onClick(View paramView)
  {
    aqwr.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqws
 * JD-Core Version:    0.7.0.1
 */