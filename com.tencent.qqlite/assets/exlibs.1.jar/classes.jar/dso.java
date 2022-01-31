import android.widget.ProgressBar;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class dso
  extends DataLineObserver
{
  public dso(BaseActionBarDataLineFile paramBaseActionBarDataLineFile) {}
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.h();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = paramFloat;
    BaseActionBarDataLineFile.d(this.a);
    BaseActionBarDataLineFile.d(this.a).setProgress((int)(100.0F * paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramEFILETYPE, paramBoolean1, paramBoolean2, paramLong2);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong1 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {}
    do
    {
      return;
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().b(paramLong1);
    } while (paramString.isSendFromLocal());
    paramString.fileMsgStatus = 0L;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().c(paramString.msgId);
    this.a.h();
    BaseActionBarDataLineFile.d(this.a);
    BaseActionBarDataLineFile.b(this.a).setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
  }
  
  protected void a(String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.g();
    if (paramBoolean)
    {
      this.a.a();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath = paramString;
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a().b(paramLong);
      if (paramString.strMoloKey != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = FileManagerUtil.a(paramString.path);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
      return;
    }
    this.a.c();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
  }
  
  protected void b(long paramLong1, String paramString, DataLineHandler.EFILETYPE paramEFILETYPE, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramEFILETYPE, paramBoolean1, paramBoolean2, paramLong2);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong1 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.h();
    BaseActionBarDataLineFile.d(this.a);
    BaseActionBarDataLineFile.c(this.a).setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.g();
    if (paramBoolean)
    {
      this.a.a();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      return;
    }
    this.a.c();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dso
 * JD-Core Version:    0.7.0.1
 */