import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class ae
  implements FMDialogUtil.FMDialogInterface
{
  ae(ab paramab, FileManagerEntity paramFileManagerEntity, String paramString, DataLineMsgRecord paramDataLineMsgRecord) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      FMToastUtil.b(FileManagerUtil.d(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_Ab.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131361997));
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ab.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(this.jdField_a_of_type_Ab.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_Ab.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), 0, false);
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId = localFileManagerEntity.nSessionId;
      this.jdField_a_of_type_Ab.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a().c(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId);
      return;
    }
    FMToastUtil.b(FileManagerUtil.d(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_Ab.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131361997));
    this.jdField_a_of_type_Ab.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ae
 * JD-Core Version:    0.7.0.1
 */