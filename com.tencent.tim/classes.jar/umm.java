import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;

class umm
  implements DialogInterface.OnCancelListener
{
  umm(uml paramuml) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.this$0.D != null) {
      this.a.this$0.D.dismiss();
    }
    this.a.this$0.CC.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umm
 * JD-Core Version:    0.7.0.1
 */