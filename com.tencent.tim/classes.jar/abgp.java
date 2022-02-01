import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;

class abgp
  implements DialogInterface.OnClickListener
{
  abgp(abgo paramabgo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(abgo.a(this.a), 2, "On Click Left Button! ");
    }
    if (this.a.mRuntime.getActivity() != null) {
      this.a.mRuntime.getActivity().finish();
    }
    for (;;)
    {
      abgo.a(this.a, 1);
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d(abgo.a(this.a), 4, "Call back object is null!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgp
 * JD-Core Version:    0.7.0.1
 */