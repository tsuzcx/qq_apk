import android.os.SystemClock;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class vtx
  implements AbsListView.OnScrollListener
{
  vtx(vtv paramvtv) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SystemClock.uptimeMillis() - vtv.a(this.a) < 500L) {}
    int i;
    do
    {
      do
      {
        return;
        vtv.a(this.a, SystemClock.uptimeMillis());
      } while (!(this.a.jdField_a_of_type_Vpm instanceof vqa));
      i = paramInt1 + paramInt2;
      ((vqa)this.a.jdField_a_of_type_Vpm).a = i;
    } while ((paramInt3 <= 0) || (paramInt3 - paramInt1 - paramInt2 >= 10));
    this.a.jdField_a_of_type_Vsj.a();
    wxe.a("VideoCoverListGroupHolder", "onScroll mStartRequestDataRunnable mShowPosition=%d totalItemCount=%d, groupId=%s", Integer.valueOf(i), Integer.valueOf(paramInt3), this.a.jdField_a_of_type_Vpm.toString());
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      vtv.a(this.a, false);
    }
    for (;;)
    {
      if ((paramInt == 0) && (vtv.a(this.a))) {
        this.a.d();
      }
      return;
      vtv.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vtx
 * JD-Core Version:    0.7.0.1
 */