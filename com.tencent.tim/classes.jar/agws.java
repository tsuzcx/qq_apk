import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;

public class agws
  extends agwv
{
  public agws(aguk paramaguk, Activity paramActivity)
  {
    super(paramaguk, paramActivity);
  }
  
  private boolean amC()
  {
    return (amD()) && (!this.jdField_a_of_type_Aguk.cj());
  }
  
  private boolean amD()
  {
    return (ahav.b(this.mContext.getBaseContext(), this.jdField_a_of_type_Aguk.getFileName(), this.jdField_a_of_type_Aguk.getFileSize())) || (aobw.i(this.jdField_a_of_type_Aguk.getFilePath(), this.jdField_a_of_type_Aguk.getFileName(), this.jdField_a_of_type_Aguk.getFileSize()));
  }
  
  protected void djU()
  {
    if ((this.jdField_a_of_type_Aguk.bF() == 16) || (this.jdField_a_of_type_Aguk.isFromProcessingForward2c2cOrDiscItem())) {}
    do
    {
      return;
      if (aqhq.fileExistsAndNotEmpty(this.jdField_a_of_type_Aguk.getFilePath()))
      {
        super.djU();
        return;
      }
    } while ((!aqiw.isNetSupport(BaseApplicationImpl.getContext())) || (!amC()));
    String str = this.mContext.getString(2131694129);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(str, new agwt(this));
  }
  
  public void init()
  {
    boolean bool = true;
    super.init();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = preview simple");
    }
    label81:
    SimpleFileViewer localSimpleFileViewer;
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Aguk.aC())) || (16 == this.jdField_a_of_type_Aguk.bF()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JR(false);
      if (this.jdField_a_of_type_Aguk.bF() != 16) {
        break label123;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(this.mContext.getString(2131693595));
      djU();
      localSimpleFileViewer = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer;
      if (this.jdField_a_of_type_Aguk.cn()) {
        break label152;
      }
    }
    for (;;)
    {
      localSimpleFileViewer.showTip(bool);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Js(this.jdField_a_of_type_Aguk.aC());
      break;
      label123:
      if (!this.jdField_a_of_type_Aguk.isFromProcessingForward2c2cOrDiscItem()) {
        break label81;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(this.mContext.getString(2131693824));
      break label81;
      label152:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agws
 * JD-Core Version:    0.7.0.1
 */