import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;

public class agwm
  extends agwv
{
  public agwm(aguk paramaguk, Activity paramActivity)
  {
    super(paramaguk, paramActivity);
  }
  
  private void OD(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(this.mContext.getString(2131693705));
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(this.mContext.getString(2131693704));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(this.mContext.getString(2131693706));
  }
  
  private void OE(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[" + paramInt + "not implemented");
      }
    case -1: 
    case 1: 
    case 12: 
    case 13: 
      return;
    case 11: 
      OF(this.jdField_a_of_type_Aguk.bF());
      return;
    case 9: 
      OG(this.jdField_a_of_type_Aguk.bF());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JK(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(this.mContext.getString(2131696567));
  }
  
  private void OF(int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_BE_PC_HANDLED] status[" + paramInt + "not implemented");
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(this.mContext.getString(2131696563));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(this.mContext.getString(2131696566));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(this.mContext.getString(2131696567));
    }
  }
  
  private void OG(int paramInt)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("SimpleFilePresenter<FileAssistant>", 2, "getFileTips: opType[OPERATION_TYPE_OLFILE_GOTO_UPLOAD] status[" + paramInt + "not implemented");
      }
    case 14: 
    case 15: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(this.mContext.getString(2131696562));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(false);
  }
  
  private void dke()
  {
    int i = this.jdField_a_of_type_Aguk.bI();
    OD(this.jdField_a_of_type_Aguk.getFileType());
    OE(i);
  }
  
  public void djH()
  {
    djX();
    dke();
  }
  
  protected void djT()
  {
    super.djT();
    int i = this.jdField_a_of_type_Aguk.bF();
    if ((i == 8) || (i == 9) || (i == 5) || (i == 7) || (i == 12) || (i == 6) || (i == 16)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(false);
    }
  }
  
  public void init()
  {
    super.init();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = online simple");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Js(ahbj.g(this.jdField_a_of_type_Aguk.getFileSize()));
    dke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwm
 * JD-Core Version:    0.7.0.1
 */