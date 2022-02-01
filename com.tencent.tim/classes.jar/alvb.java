import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;

final class alvb
  implements DialogInterface.OnDismissListener
{
  alvb(IosTimepicker paramIosTimepicker, JsBridgeListener paramJsBridgeListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    long l1;
    if ((this.a != null) && (this.c != null))
    {
      l1 = this.a.gG() / 1000L;
      if (!Build.MODEL.equals("Coolpad 5890")) {
        break label126;
      }
      long l2 = new Date().getTime() / 1000L;
      if (l1 >= l2) {
        break label126;
      }
      l1 = l2;
    }
    label126:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(aluz.access$000(), 2, "onDismiss Time :" + alve.bD(1000L * l1));
      }
      this.a.setOnTimePickerSelectListener(null);
      this.c.onComplete(Long.valueOf(l1));
      aluz.czC = true;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvb
 * JD-Core Version:    0.7.0.1
 */