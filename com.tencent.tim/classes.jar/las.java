import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;

public class las
  extends RecyclerView.OnScrollListener
{
  public las(ReadInJoyDynamicChannelBaseFragment paramReadInJoyDynamicChannelBaseFragment, StaggeredGridLayoutManager paramStaggeredGridLayoutManager) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0) {
      this.a.invalidateSpanAssignments();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     las
 * JD-Core Version:    0.7.0.1
 */