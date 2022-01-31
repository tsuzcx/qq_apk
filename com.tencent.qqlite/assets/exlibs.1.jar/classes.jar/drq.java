import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalMusciFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class drq
  implements View.OnClickListener
{
  public drq(ActionBarLocalMusciFile paramActionBarLocalMusciFile) {}
  
  public void onClick(View paramView)
  {
    long l = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b();
    if ((FileManagerUtil.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 5242880L)) {
      FMDialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 2131362018, 2131362016, new drr(this, l));
    }
    while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.g())
    {
      FileManagerReporter.a("0X8004BBB");
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(l);
      this.a.h();
    }
    FileManagerReporter.a("0X8004BD1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     drq
 * JD-Core Version:    0.7.0.1
 */