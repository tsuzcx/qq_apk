import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.QLog;

public class dnh
  implements Runnable
{
  public dnh(FileTransferHandler paramFileTransferHandler, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Long + "] Handle upload progress notify. speed=" + this.jdField_a_of_type_Int + " progress =" + this.b);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dnh
 * JD-Core Version:    0.7.0.1
 */