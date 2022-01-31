import com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker;
import com.tencent.qphone.base.util.QLog;

public class dpe
  extends don
{
  public dpe(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    super(paramOnlineFileSessionWorker);
  }
  
  protected String a()
  {
    return "StateRefuseByPCWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "]. recvOnLineFile entity is null");
      return;
    }
    OnlineFileSessionWorker.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 6);
    OnlineFileSessionWorker.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker, 11, 6);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.h + "] state change :(" + this.jdField_a_of_type_Don.a() + "->StateRefuseByPC)");
    this.jdField_a_of_type_Don = new dpd(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dpe
 * JD-Core Version:    0.7.0.1
 */