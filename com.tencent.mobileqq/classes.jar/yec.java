import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.qphone.base.util.QLog;

public class yec
  implements DialogInterface.OnClickListener
{
  public yec(QQStoryMainActivity paramQQStoryMainActivity, Intent paramIntent) {}
  
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
        noe.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity, 0, "", "");
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity.finish();
        try
        {
          paramDialogInterface = (PendingIntent)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("activity_finish_run_pendingIntent");
          if ((paramDialogInterface != null) && ((paramDialogInterface instanceof PendingIntent)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, "-->finish--send callback using PendingIntent");
            }
            paramDialogInterface.send();
          }
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity.moveTaskToBack(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yec
 * JD-Core Version:    0.7.0.1
 */