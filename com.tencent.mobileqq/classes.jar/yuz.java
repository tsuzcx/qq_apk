import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class yuz
  implements DialogInterface.OnDismissListener
{
  yuz(yuw paramyuw) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    yuw.a(this.a).setIntent(yuw.a(this.a));
    yuw.a(this.a).getApplication().unregisterActivityLifecycleCallbacks(yuw.a(this.a));
    yuw.a(this.a).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yuz
 * JD-Core Version:    0.7.0.1
 */