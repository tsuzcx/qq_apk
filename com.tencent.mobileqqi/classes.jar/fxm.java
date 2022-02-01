import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;

public class fxm
  implements Runnable
{
  public fxm(FileManagerProxy paramFileManagerProxy, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bDelInFM) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fxm
 * JD-Core Version:    0.7.0.1
 */