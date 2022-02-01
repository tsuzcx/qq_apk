import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqpim.QQPimBridgeActivity;

public class avlg
  implements DialogInterface.OnDismissListener
{
  public avlg(QQPimBridgeActivity paramQQPimBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avlg
 * JD-Core Version:    0.7.0.1
 */