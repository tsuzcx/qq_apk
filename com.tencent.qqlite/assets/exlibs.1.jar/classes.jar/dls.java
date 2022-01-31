import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;

public class dls
  implements Runnable
{
  public dls(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView != null)
    {
      QLog.e(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 1, "setSelect[" + this.jdField_a_of_type_Int + "] success mFileListView");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileBaseRecentFileTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.c(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dls
 * JD-Core Version:    0.7.0.1
 */