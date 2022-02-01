import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class abqa
  implements DialogInterface.OnKeyListener
{
  abqa(abpw paramabpw, abqe paramabqe) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.b != null)) {
      this.b.aq(this.this$0.getNameSpace(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqa
 * JD-Core Version:    0.7.0.1
 */