import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;

class vao
  extends RecyclerView.OnScrollListener
{
  vao(van paramvan) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((van.a(this.a) instanceof StaggeredGridLayoutManager))
    {
      paramRecyclerView = (StaggeredGridLayoutManager)van.a(this.a);
      int[] arrayOfInt = new int[paramRecyclerView.getColumnCountForAccessibility(null, null)];
      paramRecyclerView.findFirstVisibleItemPositions(arrayOfInt);
      if ((this.a.getLocalPosition(arrayOfInt[0]) <= 0) && (!van.a(this.a)))
      {
        van.a(this.a, true);
        paramRecyclerView.invalidateSpanAssignments();
      }
      if (arrayOfInt[0] > 2) {
        van.a(this.a, false);
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vao
 * JD-Core Version:    0.7.0.1
 */