import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ageo
  implements View.OnClickListener
{
  public ageo(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (!QfileBaseCloudFileTabView.a(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QfileBaseCloudFileTabView.a(this.this$0);
      this.this$0.dfF();
      if (this.this$0.jdField_b_of_type_Agdq.getGroupCount() > 0) {
        this.this$0.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(this.this$0.jdField_b_of_type_Agdq.getGroupCount() - 1);
      }
      this.this$0.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(this.this$0.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getAdapter().getCount() - 1);
      QfileBaseCloudFileTabView.a(this.this$0, false);
      this.this$0.onGetMore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ageo
 * JD-Core Version:    0.7.0.1
 */