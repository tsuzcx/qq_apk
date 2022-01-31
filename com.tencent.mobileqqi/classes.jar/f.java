import com.dataline.activities.DLBaseFileViewActivity;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class f
  implements FMDialogUtil.FMDialogInterface
{
  public f(DLBaseFileViewActivity paramDLBaseFileViewActivity, FileManagerEntity paramFileManagerEntity, long paramLong) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      FMToastUtil.b(this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.getString(2131558737, new Object[] { FileManagerUtil.d(this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.a.b) }));
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.b.a().a(this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.a.a, null, this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.b.getAccount(), 0, false);
      this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.a(localFileManagerEntity.nSessionId);
      return;
    }
    FMToastUtil.b(this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.getString(2131558737, new Object[] { FileManagerUtil.d(this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.a.b) }));
    this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity.b.a().a(this.jdField_a_of_type_Long);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     f
 * JD-Core Version:    0.7.0.1
 */