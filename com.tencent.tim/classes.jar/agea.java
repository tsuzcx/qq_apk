import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.widget.ExpandableListView.e;

public class agea
  implements ExpandableListView.e
{
  public agea(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onGroupExpand(int paramInt)
  {
    if ((paramInt == this.this$0.b.getGroupCount() - 1) && (this.this$0.a != null))
    {
      if (!this.this$0.isEnd()) {
        this.this$0.a.setVisible();
      }
    }
    else {
      return;
    }
    this.this$0.a.setGone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agea
 * JD-Core Version:    0.7.0.1
 */