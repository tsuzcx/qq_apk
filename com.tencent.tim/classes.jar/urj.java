import android.view.View;
import com.tencent.mobileqq.activity.CloudFileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class urj
  implements AbsListView.e
{
  public urj(CloudFileActivity paramCloudFileActivity, String paramString, int paramInt) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    CloudFileActivity.a(this.this$0, paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramAbsListView = new int[2];
      if (!this.this$0.processing) {
        break label19;
      }
    }
    label19:
    View localView;
    do
    {
      return;
      localView = CloudFileActivity.a(this.this$0, this.aMw, paramAbsListView);
    } while (localView == null);
    this.this$0.processing = true;
    paramInt = paramAbsListView[0];
    int i = paramAbsListView[1];
    CloudFileActivity.c(this.this$0, true);
    QLog.d("CloudFileFrame", 1, "onScrollStateChanged will Animating");
    CloudFileActivity.a(this.this$0, paramInt, i, this.bFW, localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     urj
 * JD-Core Version:    0.7.0.1
 */