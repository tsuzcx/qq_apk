import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;

class dlq
  implements FMDialogUtil.FMDialogInterface
{
  dlq(dlp paramdlp, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    this.jdField_a_of_type_Dlp.a.a.a().ad();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 0)
    {
      QfileBaseRecentFileTabView.e(this.jdField_a_of_type_Dlp.a).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      return;
    }
    QfileBaseRecentFileTabView.f(this.jdField_a_of_type_Dlp.a).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dlq
 * JD-Core Version:    0.7.0.1
 */