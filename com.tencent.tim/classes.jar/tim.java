import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class tim
  implements DialogInterface.OnDismissListener
{
  tim(tij paramtij) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    tij.a(this.a).setIntent(tij.a(this.a));
    tij.a(this.a).getApplication().unregisterActivityLifecycleCallbacks(tij.a(this.a));
    tij.a(this.a).beforeFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tim
 * JD-Core Version:    0.7.0.1
 */