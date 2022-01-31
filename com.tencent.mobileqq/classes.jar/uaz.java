import android.os.SystemClock;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class uaz
  implements AbsListView.OnScrollListener
{
  uaz(uax paramuax) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SystemClock.uptimeMillis() - uax.a(this.a) < 500L) {}
    int i;
    do
    {
      do
      {
        return;
        uax.a(this.a, SystemClock.uptimeMillis());
      } while (!(this.a.jdField_a_of_type_Two instanceof txc));
      i = paramInt1 + paramInt2;
      ((txc)this.a.jdField_a_of_type_Two).a = i;
    } while ((paramInt3 <= 0) || (paramInt3 - paramInt1 - paramInt2 >= 10));
    this.a.jdField_a_of_type_Tzl.a();
    veg.a("VideoCoverListGroupHolder", "onScroll mStartRequestDataRunnable mShowPosition=%d totalItemCount=%d, groupId=%s", Integer.valueOf(i), Integer.valueOf(paramInt3), this.a.jdField_a_of_type_Two.toString());
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      uax.a(this.a, false);
    }
    for (;;)
    {
      if ((paramInt == 0) && (uax.a(this.a))) {
        this.a.d();
      }
      return;
      uax.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uaz
 * JD-Core Version:    0.7.0.1
 */