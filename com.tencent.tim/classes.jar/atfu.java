import com.tencent.tim.cloudfile.CloudFileListFragment;
import com.tencent.tim.cloudfile.feeds.CloudFileUploadingStatusBar;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class atfu
  implements AbsListView.e
{
  public atfu(CloudFileListFragment paramCloudFileListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (CloudFileListFragment.a(this.this$0) != null) {
      CloudFileListFragment.a(this.this$0).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (CloudFileListFragment.a(this.this$0) != null)
    {
      if (paramInt1 >= 1) {
        CloudFileListFragment.a(this.this$0).setForceHide(false);
      }
      if (paramInt1 <= 0) {
        CloudFileListFragment.a(this.this$0).setForceHide(true);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (CloudFileListFragment.a(this.this$0) != null) {
      CloudFileListFragment.a(this.this$0).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfu
 * JD-Core Version:    0.7.0.1
 */