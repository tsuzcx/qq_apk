import android.os.SystemClock;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class tod
  implements AbsListView.OnScrollListener
{
  tod(tob paramtob) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SystemClock.uptimeMillis() - tob.a(this.a) < 500L) {}
    int i;
    do
    {
      do
      {
        return;
        tob.a(this.a, SystemClock.uptimeMillis());
      } while (!(this.a.jdField_a_of_type_Tjs instanceof tkg));
      i = paramInt1 + paramInt2;
      ((tkg)this.a.jdField_a_of_type_Tjs).a = i;
    } while ((paramInt3 <= 0) || (paramInt3 - paramInt1 - paramInt2 >= 10));
    this.a.jdField_a_of_type_Tmp.a();
    urk.a("VideoCoverListGroupHolder", "onScroll mStartRequestDataRunnable mShowPosition=%d totalItemCount=%d, groupId=%s", Integer.valueOf(i), Integer.valueOf(paramInt3), this.a.jdField_a_of_type_Tjs.toString());
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      tob.a(this.a, false);
    }
    for (;;)
    {
      if ((paramInt == 0) && (tob.a(this.a))) {
        this.a.d();
      }
      return;
      tob.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tod
 * JD-Core Version:    0.7.0.1
 */