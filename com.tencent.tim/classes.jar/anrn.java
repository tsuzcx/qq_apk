import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;

class anrn
  implements PopupWindow.OnDismissListener
{
  anrn(anrm paramanrm) {}
  
  public void onDismiss()
  {
    WindowManager.LayoutParams localLayoutParams = ((Activity)this.a.val$context).getWindow().getAttributes();
    localLayoutParams.alpha = 1.0F;
    ((Activity)this.a.val$context).getWindow().setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrn
 * JD-Core Version:    0.7.0.1
 */