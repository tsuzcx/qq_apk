import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oyy
  implements AbsListView.OnScrollListener
{
  boolean axm = false;
  
  oyy(oyu paramoyu) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramAbsListView.getFirstVisiblePosition() + paramInt2 >= paramInt3))
    {
      this.axm = true;
      return;
    }
    this.axm = false;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((this.axm) && (paramInt == 0) && (!oyu.a(this.this$0)) && (!oyu.b(this.this$0)))
    {
      QLog.i("QCircleCommentPanelView", 1, "onLastItemVisible");
      oyu.a(this.this$0, this.this$0.a().getAttachInfo(oyu.a(this.this$0)));
      if (oyu.b(this.this$0) != null)
      {
        this.this$0.a().a(oyu.a(this.this$0), true);
        oyu.a(this.this$0, true);
      }
    }
    if (paramInt == 0)
    {
      txn.a().stopMonitorScene("qcircle_comment_page", false);
      return;
    }
    txn.a().startMonitorScene("qcircle_comment_page");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyy
 * JD-Core Version:    0.7.0.1
 */