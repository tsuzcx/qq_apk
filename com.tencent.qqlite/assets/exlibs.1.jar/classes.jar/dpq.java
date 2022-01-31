import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.qphone.base.util.QLog;

class dpq
  implements Runnable
{
  dpq(dpp paramdpp, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    QfavFilePreviewController.a(this.jdField_a_of_type_Dpp.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    QfavFilePreviewController.a(this.jdField_a_of_type_Dpp.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    QfavFilePreviewController.a(this.jdField_a_of_type_Dpp.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    QfavFilePreviewController.b(this.jdField_a_of_type_Dpp.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    QfavFilePreviewController.c(this.jdField_a_of_type_Dpp.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + QfavFilePreviewController.a(this.jdField_a_of_type_Dpp.a) + ", port=" + String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Dpp.a)) + ", key=" + QfavFilePreviewController.b(this.jdField_a_of_type_Dpp.a) + ", retCode =" + String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Dpp.a)));
    }
    FilePreviewActivity.ControlerCallback localControlerCallback;
    if (1 == QfavFilePreviewController.b(this.jdField_a_of_type_Dpp.a))
    {
      localControlerCallback = this.jdField_a_of_type_Dpp.a.a;
      if (0L != QfavFilePreviewController.a(this.jdField_a_of_type_Dpp.a)) {
        break label319;
      }
    }
    for (;;)
    {
      localControlerCallback.a(bool, QfavFilePreviewController.a(this.jdField_a_of_type_Dpp.a), String.valueOf(QfavFilePreviewController.a(this.jdField_a_of_type_Dpp.a)), QfavFilePreviewController.a(this.jdField_a_of_type_Dpp.a), null, QfavFilePreviewController.b(this.jdField_a_of_type_Dpp.a), QfavFilePreviewController.c(this.jdField_a_of_type_Dpp.a));
      QfavFilePreviewController.b(this.jdField_a_of_type_Dpp.a, 3);
      return;
      label319:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dpq
 * JD-Core Version:    0.7.0.1
 */