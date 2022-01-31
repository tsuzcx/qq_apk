import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker;
import com.tencent.qphone.base.util.QLog;

public class gam
  extends fzn
{
  public gam(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateSenderCancelSendWhenToOffFailed";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]. recvOnLineFile entity is null");
      return;
    }
    OnlineFileSessionWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 8);
    OnlineFileSessionWorker.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 8);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Fzn.a() + "->StateSenderCancelSend)");
    this.jdField_a_of_type_Fzn = new gak(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gam
 * JD-Core Version:    0.7.0.1
 */