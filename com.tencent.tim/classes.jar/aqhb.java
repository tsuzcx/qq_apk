import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aqhb
  implements View.OnClickListener
{
  aqhb(DialogInterface.OnClickListener paramOnClickListener1, Dialog paramDialog, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365889) {}
    for (;;)
    {
      try
      {
        if (this.X != null) {
          this.X.onClick(this.val$dialog, 0);
        }
        if (this.val$dialog.isShowing()) {
          this.val$dialog.dismiss();
        }
      }
      catch (Exception localException2)
      {
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131365895)
      {
        if (this.Y != null) {
          this.Y.onClick(this.val$dialog, 1);
        }
        try
        {
          if (this.val$dialog.isShowing()) {
            this.val$dialog.dismiss();
          }
        }
        catch (Exception localException1) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqhb
 * JD-Core Version:    0.7.0.1
 */