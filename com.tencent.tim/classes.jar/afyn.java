import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class afyn
  implements View.OnClickListener
{
  afyn(Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    anot.a(null, "dc00898", "", "", "kuolie", "0X80097DF", 0, 0, "", "", "", "");
    if ((this.ap != null) && (this.ap.isShowing())) {
      this.ap.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afyn
 * JD-Core Version:    0.7.0.1
 */