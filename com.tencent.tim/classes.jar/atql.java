import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.tim.filemanager.widget.QfilePinnedHeaderExpandableListView;

public class atql
  implements View.OnClickListener
{
  public atql(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (!QfileBaseCloudFileTabView.a(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QfileBaseCloudFileTabView.a(this.this$0);
      this.this$0.dfF();
      if (this.this$0.jdField_a_of_type_Atpo.getGroupCount() > 0) {
        this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.expandGroup(this.this$0.jdField_a_of_type_Atpo.getGroupCount() - 1);
      }
      this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfilePinnedHeaderExpandableListView.getAdapter().getCount() - 1);
      QfileBaseCloudFileTabView.a(this.this$0, false);
      this.this$0.onGetMore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atql
 * JD-Core Version:    0.7.0.1
 */