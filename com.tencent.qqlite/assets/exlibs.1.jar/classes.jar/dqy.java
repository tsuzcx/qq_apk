import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.qphone.base.util.QLog;

class dqy
  implements Runnable
{
  dqy(dqx paramdqx, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    QfavFilePreviewController.a(this.jdField_a_of_type_Dqx.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    QfavFilePreviewController.a(this.jdField_a_of_type_Dqx.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    QfavFilePreviewController.a(this.jdField_a_of_type_Dqx.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    QfavFilePreviewController.b(this.jdField_a_of_type_Dqx.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    QfavFilePreviewController.c(this.jdField_a_of_type_Dqx.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + QfavFilePreviewController.a(this.jdField_a_of_type_Dqx.a) + ", port=" + String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Dqx.a)) + ", key=" + QfavFilePreviewController.b(this.jdField_a_of_type_Dqx.a) + ", retCode =" + String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Dqx.a)));
    }
    FilePreviewActivity.ControlerCallback localControlerCallback;
    if (1 == QfavFilePreviewController.b(this.jdField_a_of_type_Dqx.a))
    {
      localControlerCallback = this.jdField_a_of_type_Dqx.a.a;
      if (0L != QfavFilePreviewController.a(this.jdField_a_of_type_Dqx.a)) {
        break label319;
      }
    }
    for (;;)
    {
      localControlerCallback.a(bool, QfavFilePreviewController.a(this.jdField_a_of_type_Dqx.a), String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Dqx.a)), QfavFilePreviewController.a(this.jdField_a_of_type_Dqx.a), null, QfavFilePreviewController.b(this.jdField_a_of_type_Dqx.a), QfavFilePreviewController.c(this.jdField_a_of_type_Dqx.a));
      QfavFilePreviewController.b(this.jdField_a_of_type_Dqx.a, 3);
      return;
      label319:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dqy
 * JD-Core Version:    0.7.0.1
 */