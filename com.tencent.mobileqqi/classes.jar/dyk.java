import android.content.Context;
import com.tencent.mobileqq.activity.aio.item.FileItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class dyk
  implements FMDialogUtil.FMDialogInterface
{
  public dyk(FileItemBuilder paramFileItemBuilder, Context paramContext, MessageForFile paramMessageForFile, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    FMToastUtil.b(this.jdField_a_of_type_AndroidContentContext.getString(2131558738, new Object[] { FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.fileName) }));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = FileItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, null, FileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder).getAccount(), 0, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      FileItemBuilder.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder).a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]'s relateId[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId) + "] reInit");
      return;
      FileItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dyk
 * JD-Core Version:    0.7.0.1
 */