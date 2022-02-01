import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class udy
  extends StaggeredGridLayoutManager
{
  public udy(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      super.onLayoutChildren(paramRecycler, paramState);
      return;
    }
    catch (Exception paramRecycler)
    {
      uqf.d("WSStaggeredGridLayoutManager", "onLayoutChildren exception: " + paramRecycler.getLocalizedMessage());
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    try
    {
      super.scrollToPosition(paramInt);
      EventCollector.getInstance().onRecyclerViewScrollToPosition(this);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        uqf.d("WSStaggeredGridLayoutManager", "scrollToPosition exception: " + localException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udy
 * JD-Core Version:    0.7.0.1
 */