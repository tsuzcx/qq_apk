import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.antiphing.AntiphingHandler;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class fdi
  implements DialogInterface.OnClickListener
{
  public fdi(AntiphingHandler paramAntiphingHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AntiphingHandler.a(this.a), 2, "On Click Left Button! ");
    }
    if (this.a.mRuntime.a() != null) {
      this.a.mRuntime.a().finish();
    }
    for (;;)
    {
      AntiphingHandler.a(this.a, 1);
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d(AntiphingHandler.a(this.a), 4, "Call back object is null!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fdi
 * JD-Core Version:    0.7.0.1
 */