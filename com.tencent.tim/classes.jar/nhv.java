import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.qphone.base.util.QLog;

public class nhv
  extends RecyclerView.OnScrollListener
{
  public nhv(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = 0;
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (ReadInjoyXRecyclerView.c(this.b) == 2)) {
      this.b.aVt();
    }
    int j = paramRecyclerView.getChildCount();
    boolean bool;
    if ((paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager))
    {
      paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      i = paramRecyclerView.getItemCount();
      paramRecyclerView = paramRecyclerView.findFirstVisibleItemPositions(null);
      int k = ReadInjoyXRecyclerView.a(this.b).tV();
      if (i - j <= paramRecyclerView[0] + k)
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("XRecyclerView", 2, new Object[] { "totalItemCount=%d, firstVisibleItem=%d, visibleThreshold=%d, isCloseToTheEnd=%b", Integer.valueOf(i), Integer.valueOf(paramRecyclerView[0]), Integer.valueOf(k), Boolean.valueOf(bool) });
        }
        if (bool) {
          ReadInjoyXRecyclerView.a(this.b).ui(true);
        }
      }
    }
    for (;;)
    {
      ReadInjoyXRecyclerView.c(this.b, paramInt);
      return;
      bool = false;
      break;
      if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
      {
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
        if (paramRecyclerView.getItemCount() - j <= paramRecyclerView.findFirstVisibleItemPosition() + ReadInjoyXRecyclerView.a(this.b).tV()) {
          i = 1;
        }
        if (i != 0) {
          ReadInjoyXRecyclerView.a(this.b).ui(true);
        }
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    ReadInjoyXRecyclerView.a(this.b, ReadInjoyXRecyclerView.a(this.b) + paramInt1);
    ReadInjoyXRecyclerView.b(this.b, ReadInjoyXRecyclerView.b(this.b) + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nhv
 * JD-Core Version:    0.7.0.1
 */