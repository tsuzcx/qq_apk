import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.tim.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.widget.ExpandableListView.d;

public class atqh
  implements ExpandableListView.d
{
  public atqh(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onGroupCollapse(int paramInt)
  {
    if ((paramInt == this.this$0.jdField_a_of_type_Atpo.getGroupCount() - 1) && (this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout != null)) {
      this.this$0.jdField_a_of_type_ComTencentTimFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atqh
 * JD-Core Version:    0.7.0.1
 */