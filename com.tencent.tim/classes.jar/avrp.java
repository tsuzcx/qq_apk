import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qzone.QzonePluginProxyActivity.4.1;

public class avrp
  implements DialogInterface.OnDismissListener
{
  public avrp(QzonePluginProxyActivity.4.1 param1) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.this$0.val$dismissListener != null) {
      this.a.this$0.val$dismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avrp
 * JD-Core Version:    0.7.0.1
 */