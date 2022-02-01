import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.qphone.base.util.QLog;

class apzi
  implements DialogInterface.OnDismissListener
{
  apzi(apzg paramapzg) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.this$0.atU == -1) && ((this.this$0.a instanceof TroopCreateLogicActivity)))
    {
      ((TroopCreateLogicActivity)this.this$0.a).finish();
      if (QLog.isColorLevel()) {
        QLog.d("TroopShareUtility", 2, "mShareActionSheet noItemClick, onDismiss");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzi
 * JD-Core Version:    0.7.0.1
 */