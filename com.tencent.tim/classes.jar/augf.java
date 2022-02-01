import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class augf
  implements View.OnClickListener
{
  augf(auge paramauge) {}
  
  public void onClick(View paramView)
  {
    auge.a(this.this$0);
    auge.a(this.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augf
 * JD-Core Version:    0.7.0.1
 */