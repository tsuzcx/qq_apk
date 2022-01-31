import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class zuu
  extends DownloadListener
{
  public zuu(String paramString) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    MsgNotifyPushDialog.jdField_a_of_type_ComTencentMobileqqVipDownloadTask = null;
    QLog.d(MsgNotifyPushDialog.jdField_a_of_type_JavaLangString, 1, "downloadZipFile cancel");
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    MsgNotifyPushDialog.jdField_a_of_type_ComTencentMobileqqVipDownloadTask = null;
    if (paramDownloadTask.a() == 3)
    {
      QLog.d(MsgNotifyPushDialog.jdField_a_of_type_JavaLangString, 1, "download finished " + MsgNotifyPushDialog.f);
      paramDownloadTask = new File(this.jdField_a_of_type_JavaLangString);
      if ((paramDownloadTask.exists()) && (MsgNotifyPushDialog.a(paramDownloadTask))) {
        QLog.d(MsgNotifyPushDialog.jdField_a_of_type_JavaLangString, 1, "downloadZipFile suc and zip succ");
      }
      return;
    }
    QLog.d(MsgNotifyPushDialog.jdField_a_of_type_JavaLangString, 1, new Object[] { "downloadZipFile failed: ", paramDownloadTask.b, " code=", Integer.valueOf(paramDownloadTask.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zuu
 * JD-Core Version:    0.7.0.1
 */