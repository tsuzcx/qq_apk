import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.BaseFileViewerActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.Map;

class fxu
  implements ActionSheet.OnButtonClickListener
{
  fxu(fxt paramfxt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (((Integer)this.jdField_a_of_type_Fxt.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).intValue())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("<FileAssistant>QfileBaseBusiFileController", 2, "bug, why come here, which" + paramInt);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_Fxt.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.f();
      return;
      this.jdField_a_of_type_Fxt.c();
      continue;
      QfavBuilder.c(this.jdField_a_of_type_Fxt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath).a(this.jdField_a_of_type_Fxt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Fxt.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_Fxt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_Fxt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7, 3);
      continue;
      this.jdField_a_of_type_Fxt.d();
      continue;
      FileManagerUtil.a(this.jdField_a_of_type_Fxt.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_Fxt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
      continue;
      FileManagerUtil.b(this.jdField_a_of_type_Fxt.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity, this.jdField_a_of_type_Fxt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
      continue;
      this.jdField_a_of_type_Fxt.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fxu
 * JD-Core Version:    0.7.0.1
 */