import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqlf
  implements View.OnClickListener
{
  aqlf(aqla paramaqla, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.val$pl != null)
    {
      this.val$pl.onClick(this.this$0, 0);
      this.this$0.eeg();
    }
    try
    {
      if (this.this$0.isShowing()) {
        this.this$0.dismiss();
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
 * Qualified Name:     aqlf
 * JD-Core Version:    0.7.0.1
 */