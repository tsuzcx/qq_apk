import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aqls
  implements View.OnClickListener
{
  aqls(Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.aC.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqls
 * JD-Core Version:    0.7.0.1
 */