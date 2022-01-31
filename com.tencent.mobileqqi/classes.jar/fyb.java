import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileViewerActivity;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public final class fyb
  implements FMDialogUtil.FMDialogInterface
{
  public fyb(String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, BaseFileViewerActivity paramBaseFileViewerActivity) {}
  
  public void a()
  {
    String str = FileManagerUtil.b(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>QfileFileViewerFacade", 1, "file maybe resoved ,recreateFilePath[" + this.jdField_a_of_type_JavaLangString + "]");
    }
    FileUtils.b(this.b, str);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(str);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath = str;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.b);
    if (localFileManagerEntity != null)
    {
      localFileManagerEntity.strFilePath = str;
      localFileManagerEntity.fileName = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.f();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fyb
 * JD-Core Version:    0.7.0.1
 */