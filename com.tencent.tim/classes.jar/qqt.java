import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.qphone.base.util.QLog;

public class qqt
  implements DialogInterface.OnClickListener
{
  public qqt(QQStoryMainActivity paramQQStoryMainActivity, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.home.QQStoryMainActivity", 2, "qbShowShareResultDialog back");
        }
        jqo.a(this.this$0, 0, "", "");
        this.this$0.finish();
        try
        {
          paramDialogInterface = (PendingIntent)this.val$intent.getParcelableExtra("activity_finish_run_pendingIntent");
          if ((paramDialogInterface != null) && ((paramDialogInterface instanceof PendingIntent)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, "-->finish--send callback using PendingIntent");
            }
            paramDialogInterface.send();
          }
          this.this$0.moveTaskToBack(true);
          return;
        }
        catch (Throwable paramDialogInterface) {}
      } while (!QLog.isColorLevel());
      QLog.e("Q.qqstory.home.QQStoryMainActivity", 2, "qbShowShareResultDialog ", paramDialogInterface);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, "-->qbShowShareResultDialog--stay");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqt
 * JD-Core Version:    0.7.0.1
 */