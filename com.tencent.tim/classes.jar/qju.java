import android.os.SystemClock;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qju
  implements AbsListView.OnScrollListener
{
  qju(qjs paramqjs) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SystemClock.uptimeMillis() - qjs.a(this.a) < 500L) {}
    int i;
    do
    {
      do
      {
        return;
        qjs.a(this.a, SystemClock.uptimeMillis());
      } while (!(this.a.d instanceof qhc.a));
      i = paramInt1 + paramInt2;
      ((qhc.a)this.a.d).bmq = i;
    } while ((paramInt3 <= 0) || (paramInt3 - paramInt1 - paramInt2 >= 10));
    this.a.a.bol();
    ram.a("VideoCoverListGroupHolder", "onScroll mStartRequestDataRunnable mShowPosition=%d totalItemCount=%d, groupId=%s", Integer.valueOf(i), Integer.valueOf(paramInt3), this.a.d.toString());
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0) {
      qjs.a(this.a, false);
    }
    for (;;)
    {
      if ((paramInt == 0) && (qjs.a(this.a))) {
        this.a.bon();
      }
      return;
      qjs.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qju
 * JD-Core Version:    0.7.0.1
 */