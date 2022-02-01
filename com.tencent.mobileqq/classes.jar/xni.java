import android.os.SystemClock;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xni
  implements AbsListView.OnScrollListener
{
  xni(xng paramxng) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SystemClock.uptimeMillis() - xng.a(this.a) < 500L) {}
    int i;
    do
    {
      do
      {
        return;
        xng.a(this.a, SystemClock.uptimeMillis());
      } while (!(this.a.jdField_a_of_type_Xix instanceof xjl));
      i = paramInt1 + paramInt2;
      ((xjl)this.a.jdField_a_of_type_Xix).a = i;
    } while ((paramInt3 <= 0) || (paramInt3 - paramInt1 - paramInt2 >= 10));
    this.a.jdField_a_of_type_Xlu.a();
    yqp.a("VideoCoverListGroupHolder", "onScroll mStartRequestDataRunnable mShowPosition=%d totalItemCount=%d, groupId=%s", Integer.valueOf(i), Integer.valueOf(paramInt3), this.a.jdField_a_of_type_Xix.toString());
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0) {
      xng.a(this.a, false);
    }
    for (;;)
    {
      if ((paramInt == 0) && (xng.a(this.a))) {
        this.a.d();
      }
      return;
      xng.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xni
 * JD-Core Version:    0.7.0.1
 */