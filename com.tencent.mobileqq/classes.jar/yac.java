import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;

class yac
  extends RecyclerView.OnScrollListener
{
  yac(xzz paramxzz) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((this.a.a instanceof StaggeredGridLayoutManager))
    {
      paramRecyclerView = (StaggeredGridLayoutManager)this.a.a;
      int[] arrayOfInt = new int[paramRecyclerView.getColumnCountForAccessibility(null, null)];
      paramRecyclerView.findFirstVisibleItemPositions(arrayOfInt);
      if ((this.a.b(arrayOfInt[0]) <= 0) && (!xzz.b(this.a)))
      {
        xzz.a(this.a, true);
        paramRecyclerView.invalidateSpanAssignments();
      }
      if (arrayOfInt[0] > 2) {
        xzz.a(this.a, false);
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yac
 * JD-Core Version:    0.7.0.1
 */