import android.app.Activity;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

public class dsr
  extends FMObserver
{
  public dsr(BaseQfileActionBar paramBaseQfileActionBar) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    FileManagerUtil.a(paramLong, paramInt, paramString);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    if (paramLong1 == this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
    }
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramInt != 0))
    {
      FileManagerUtil.a(paramString2);
      return;
    }
    FileManagerUtil.a(paramLong);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    FileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {}
    do
    {
      return;
      paramLong1 = ((float)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 0) {
        break;
      }
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131362006) + "(" + FileUtil.a(paramLong1) + "/" + FileUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";
    } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 10);
    for (;;)
    {
      this.a.h();
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 6) || ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 8) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 1) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 5))) {
        paramString = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131361992) + "(" + FileUtil.a(paramLong1) + "/" + FileUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";
      } else {
        paramString = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131361993) + "(" + FileUtil.a(paramLong1) + "/" + FileUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseActionBar<FileAssistant>", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (paramLong2 == this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId)
    {
      this.a.g();
      if ((!paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOLfileSessionId == 0L)) {
        break label134;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
    }
    while (paramBoolean)
    {
      FileManagerUtil.a(paramLong2);
      return;
      label134:
      this.a.c();
    }
    FileManagerUtil.a(paramLong2, paramInt2, paramString2);
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
      return;
    }
    this.a.h();
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
  }
  
  protected void c(int paramInt, String paramString)
  {
    FileManagerUtil.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dsr
 * JD-Core Version:    0.7.0.1
 */