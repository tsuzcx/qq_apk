import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;

public class udt
  extends RecyclerView.OnScrollListener
{
  public udt(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 1) {
      WSRecommendFragment.c(this.a, true);
    }
    switch (paramInt)
    {
    default: 
      adcd.a().a("weishi_recommend_list");
      return;
    }
    adcd.a().a("weishi_recommend_list", false);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     udt
 * JD-Core Version:    0.7.0.1
 */