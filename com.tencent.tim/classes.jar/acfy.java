import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class acfy
  implements View.OnClickListener
{
  acfy(Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.val$dialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acfy
 * JD-Core Version:    0.7.0.1
 */