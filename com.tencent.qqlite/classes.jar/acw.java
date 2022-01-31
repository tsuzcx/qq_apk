import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;

class acw
  implements DialogInterface.OnCancelListener
{
  acw(acv paramacv) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.a.a != null) {
      this.a.a.a.dismiss();
    }
    ChatHistory.a(this.a.a).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     acw
 * JD-Core Version:    0.7.0.1
 */