import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker;
import com.tencent.qphone.base.util.QLog;

public class gaj
  extends fzn
{
  public gaj(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateSaveToWeiYunByPCWhenToOffFailed";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]. recvOnLineFile entity is null");
      return;
    }
    OnlineFileSessionWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 7);
    OnlineFileSessionWorker.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 7);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Fzn.a() + "->StateSaveToWeiYunByPC)");
    this.jdField_a_of_type_Fzn = new gah(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gaj
 * JD-Core Version:    0.7.0.1
 */