import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ohm
  implements AbsListView.OnScrollListener
{
  boolean axm = false;
  
  ohm(ohl paramohl) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramAbsListView.getFirstVisiblePosition() + paramInt2 >= paramInt3)) {}
    for (boolean bool = true;; bool = false)
    {
      this.axm = bool;
      return;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((this.axm) && (paramInt == 0) && (!ohl.a(this.this$0)) && (!ohl.b(this.this$0)))
    {
      ooz.w(ohl.a(this.this$0), "onScrollStateChanged scrollState:" + paramInt);
      ohl.a(this.this$0, this.this$0.a().getAttachInfo(ohl.b(this.this$0)));
      if (ohl.c(this.this$0) != null)
      {
        this.this$0.a().a(ohl.a(this.this$0), true);
        ohl.a(this.this$0, true);
      }
    }
    else
    {
      return;
    }
    ooz.w(ohl.a(this.this$0), "mCommentAttachInfo is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohm
 * JD-Core Version:    0.7.0.1
 */