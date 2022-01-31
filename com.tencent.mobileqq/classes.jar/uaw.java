import android.os.SystemClock;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class uaw
  implements AbsListView.OnScrollListener
{
  uaw(uau paramuau) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SystemClock.uptimeMillis() - uau.a(this.a) < 500L) {}
    int i;
    do
    {
      do
      {
        return;
        uau.a(this.a, SystemClock.uptimeMillis());
      } while (!(this.a.jdField_a_of_type_Twl instanceof twz));
      i = paramInt1 + paramInt2;
      ((twz)this.a.jdField_a_of_type_Twl).a = i;
    } while ((paramInt3 <= 0) || (paramInt3 - paramInt1 - paramInt2 >= 10));
    this.a.jdField_a_of_type_Tzi.a();
    ved.a("VideoCoverListGroupHolder", "onScroll mStartRequestDataRunnable mShowPosition=%d totalItemCount=%d, groupId=%s", Integer.valueOf(i), Integer.valueOf(paramInt3), this.a.jdField_a_of_type_Twl.toString());
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      uau.a(this.a, false);
    }
    for (;;)
    {
      if ((paramInt == 0) && (uau.a(this.a))) {
        this.a.d();
      }
      return;
      uau.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uaw
 * JD-Core Version:    0.7.0.1
 */