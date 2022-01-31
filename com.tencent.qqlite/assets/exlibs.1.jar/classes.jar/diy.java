import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;

public class diy
  implements View.OnClickListener
{
  public diy(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (!QfileBaseCloudFileTabView.a(this.a)) {
      return;
    }
    QfileBaseCloudFileTabView.b(this.a);
    this.a.f();
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() > 0) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() - 1);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a().getCount() - 1);
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     diy
 * JD-Core Version:    0.7.0.1
 */