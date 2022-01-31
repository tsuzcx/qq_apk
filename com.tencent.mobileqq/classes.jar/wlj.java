import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;

class wlj
  extends RecyclerView.OnScrollListener
{
  wlj(wlg paramwlg) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((this.a.a instanceof StaggeredGridLayoutManager))
    {
      paramRecyclerView = (StaggeredGridLayoutManager)this.a.a;
      int[] arrayOfInt = new int[paramRecyclerView.getColumnCountForAccessibility(null, null)];
      paramRecyclerView.findFirstVisibleItemPositions(arrayOfInt);
      if ((this.a.b(arrayOfInt[0]) <= 0) && (!wlg.b(this.a)))
      {
        wlg.a(this.a, true);
        paramRecyclerView.invalidateSpanAssignments();
      }
      if (arrayOfInt[0] > 2) {
        wlg.a(this.a, false);
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wlj
 * JD-Core Version:    0.7.0.1
 */