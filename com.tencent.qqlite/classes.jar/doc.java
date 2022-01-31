import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class doc
  extends TimerTask
{
  public doc(OnlineFileSessionWorker paramOnlineFileSessionWorker) {}
  
  public void run()
  {
    QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] state:" + OnlineFileSessionWorker.a(this.a).a() + " WaitAskUpProgressResultTimer time out!!!!!!!");
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 43, new Object[] { Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) });
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     doc
 * JD-Core Version:    0.7.0.1
 */