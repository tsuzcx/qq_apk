import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class aflg
  implements DialogInterface.OnDismissListener
{
  aflg(aflf paramaflf) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func onDismiss begins, mCurTaskId:" + this.b.cRR);
    }
    this.b.removeTask(this.b.cRR);
    if (QLog.isColorLevel()) {
      QLog.d("SogouEmojiTaskController", 2, "func onDismiss ends");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflg
 * JD-Core Version:    0.7.0.1
 */