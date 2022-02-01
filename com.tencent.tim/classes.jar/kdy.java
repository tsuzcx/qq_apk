import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;

class kdy
  implements PopupWindow.OnDismissListener
{
  kdy(kdx paramkdx) {}
  
  public void onDismiss()
  {
    WindowManager.LayoutParams localLayoutParams = ((Activity)this.a.val$context).getWindow().getAttributes();
    localLayoutParams.alpha = 1.0F;
    ((Activity)this.a.val$context).getWindow().setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdy
 * JD-Core Version:    0.7.0.1
 */