import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class yvc
  implements DialogInterface.OnDismissListener
{
  yvc(yuz paramyuz) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    yuz.a(this.a).setIntent(yuz.a(this.a));
    yuz.a(this.a).getApplication().unregisterActivityLifecycleCallbacks(yuz.a(this.a));
    yuz.a(this.a).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvc
 * JD-Core Version:    0.7.0.1
 */