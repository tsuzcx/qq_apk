import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.qqstory.view.xrecyclerview.XRecyclerView;

public class xsu
  extends RecyclerView.OnScrollListener
{
  public xsu(XRecyclerView paramXRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    paramInt = paramRecyclerView.getChildCount();
    if ((paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager))
    {
      paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      int i = paramRecyclerView.getItemCount();
      int[] arrayOfInt = paramRecyclerView.findFirstVisibleItemPositions(null);
      if (i - paramInt > paramRecyclerView.getSpanCount() * 3 + arrayOfInt[0]) {
        break label76;
      }
    }
    label76:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        XRecyclerView.a(this.a).b(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xsu
 * JD-Core Version:    0.7.0.1
 */