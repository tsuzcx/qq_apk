import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.emoticon.SogouEmojiTaskController;
import com.tencent.qphone.base.util.QLog;

public class dff
  implements DialogInterface.OnDismissListener
{
  public dff(SogouEmojiTaskController paramSogouEmojiTaskController) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmojiTaskController.jdField_a_of_type_JavaLangString, 2, "func onDismiss begins, mCurTaskId:" + this.a.jdField_a_of_type_Int);
    }
    this.a.a(this.a.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmojiTaskController.jdField_a_of_type_JavaLangString, 2, "func onDismiss ends");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dff
 * JD-Core Version:    0.7.0.1
 */