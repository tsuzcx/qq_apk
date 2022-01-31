import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOfflineFile.BaseActionBarOfflineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class dry
  implements View.OnClickListener
{
  public dry(BaseActionBarOfflineFile paramBaseActionBarOfflineFile) {}
  
  public void onClick(View paramView)
  {
    if ((FileManagerUtil.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 5242880L)) {
      FMDialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 2131362018, 2131362016, new drz(this));
    }
    while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.g())
    {
      FileManagerReporter.a("0X8004BBA");
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.a.h();
    }
    FileManagerReporter.a("0X8004BD0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dry
 * JD-Core Version:    0.7.0.1
 */