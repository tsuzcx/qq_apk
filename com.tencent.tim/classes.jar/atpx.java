import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.tim.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.widget.ExpandableListView.e;

public class atpx
  implements ExpandableListView.e
{
  public atpx(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onGroupExpand(int paramInt)
  {
    if ((paramInt == this.this$0.jdField_a_of_type_Atpo.getGroupCount() - 1) && (this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout != null))
    {
      if (!this.this$0.isEnd()) {
        this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
      }
    }
    else {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setGone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpx
 * JD-Core Version:    0.7.0.1
 */