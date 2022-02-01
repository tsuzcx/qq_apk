import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqkc
  implements View.OnClickListener
{
  aqkc(aqju paramaqju, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.val$nl != null) {
      this.val$nl.onClick(this.aG, 1);
    }
    try
    {
      if ((this.aG.isShowing()) && (this.val$isDismiss)) {
        this.aG.dismiss();
      }
      label45:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqkc
 * JD-Core Version:    0.7.0.1
 */