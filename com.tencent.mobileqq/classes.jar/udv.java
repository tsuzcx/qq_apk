import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;

public class udv
  extends RecyclerView.OnScrollListener
{
  public udv(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 1) {
      WSRecommendFragment.c(this.a, true);
    }
    switch (paramInt)
    {
    default: 
      adlb.a().a("weishi_recommend_list");
      return;
    }
    adlb.a().a("weishi_recommend_list", false);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udv
 * JD-Core Version:    0.7.0.1
 */