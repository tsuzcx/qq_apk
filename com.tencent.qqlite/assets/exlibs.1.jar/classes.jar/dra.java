import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.qphone.base.util.QLog;

public class dra
  implements Runnable
{
  public dra(QfavFilePreviewController paramQfavFilePreviewController) {}
  
  public void run()
  {
    FilePreviewActivity.ControlerCallback localControlerCallback = this.a.a;
    if (0L == QfavFilePreviewController.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      localControlerCallback.a(bool, QfavFilePreviewController.a(this.a), String.valueOf(QfavFilePreviewController.a(this.a)), QfavFilePreviewController.a(this.a), null, QfavFilePreviewController.b(this.a), QfavFilePreviewController.c(this.a));
      if (QLog.isColorLevel()) {
        QLog.i("QfavFilePreviewController", 2, "sendCS: mHost=" + QfavFilePreviewController.a(this.a) + ", port=" + QfavFilePreviewController.a(this.a) + ", key=" + QfavFilePreviewController.b(this.a) + ", retCode =" + QfavFilePreviewController.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dra
 * JD-Core Version:    0.7.0.1
 */