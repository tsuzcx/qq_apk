import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class adsq
  implements DialogInterface.OnDismissListener
{
  adsq(adso paramadso) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    adso.a(this.this$0, false);
    QLog.d("ark.download.ctrl", 1, "ark.dctrl [showDownloadDialog] onDismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsq
 * JD-Core Version:    0.7.0.1
 */