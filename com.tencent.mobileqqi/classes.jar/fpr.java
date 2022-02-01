import android.view.View;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity.OverScrollViewTag;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class fpr
  implements OverScrollViewListener
{
  public fpr(CloudFileBrowserActivity paramCloudFileBrowserActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.c == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.c)
    {
      paramView.c(l);
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(CloudFileBrowserActivity.b, 2, "onViewCompleteVisableAndReleased");
    }
    paramListView = (PullRefreshHeader)paramView;
    if (this.a.c == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.c)
    {
      paramListView.a(l);
      this.a.h();
      ((CloudFileBrowserActivity.OverScrollViewTag)paramView.getTag()).a = true;
      return true;
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(CloudFileBrowserActivity.b, 2, "onViewCompleteVisable");
    }
    paramView = (PullRefreshHeader)paramView;
    if (this.a.c == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.c)
    {
      paramView.b(l);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(CloudFileBrowserActivity.b, 2, "onViewNotCompleteVisableAndReleased");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fpr
 * JD-Core Version:    0.7.0.1
 */