import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class scy
  implements AbsListView.OnScrollListener
{
  boolean axm = false;
  
  scy(scw paramscw) {}
  
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
    if ((this.axm) && (paramInt == 0) && (!scw.a(this.this$0)) && (!scw.b(this.this$0)))
    {
      QLog.i(scw.access$700(), 1, "onLastItemVisible");
      scw.a(this.this$0, scw.a(this.this$0).a(scw.a(this.this$0)));
      if (scw.a(this.this$0) != null)
      {
        scw.a(this.this$0).a(scw.a(this.this$0), true);
        scw.a(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scy
 * JD-Core Version:    0.7.0.1
 */