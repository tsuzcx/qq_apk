import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;

public class ucu
  extends RecyclerView.OnScrollListener
{
  public ucu(WSFollowFragment paramWSFollowFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 1) {
      WSFollowFragment.a(this.a, true);
    }
    switch (paramInt)
    {
    default: 
      adlb.a().a("weishi_follow_list");
      return;
    }
    adlb.a().a("weishi_follow_list", false);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (WSFollowFragment.a(this.a).a == null)
    {
      paramInt1 = WSFollowFragment.a(this.a).findFirstVisibleItemPosition();
      paramRecyclerView = WSFollowFragment.a(this.a, paramInt1, false);
      uqf.d("WSFollowContinuePlayLog", "mAdapter.mPlayingHolder is null. startPosition:" + paramInt1 + ", lastOrNextVideoHolder:" + paramRecyclerView);
      if (WSFollowFragment.a(this.a, paramRecyclerView))
      {
        if (!WSFollowFragment.a(this.a)) {
          break label149;
        }
        uqf.d("WSFollowContinuePlayLog", "[WSFollowFragment.java][onScrolled] mIsHandlingBackFromVertical true.");
      }
    }
    else
    {
      paramRecyclerView = this.a;
      localObject = WSFollowFragment.a(this.a).a;
      if (paramInt2 > 0) {}
      for (bool1 = true;; bool1 = false)
      {
        paramRecyclerView = paramRecyclerView.a((uiu)localObject, bool1, false);
        break;
      }
    }
    label149:
    uqf.g("WSFollowContinuePlayLog", "[WSFollowFragment.java][onScrolled] playVideo title:" + paramRecyclerView.a.d + ", mPlayingHolder:" + paramRecyclerView);
    WSFollowFragment.a(this.a, paramRecyclerView);
    Object localObject = this.a;
    boolean bool1 = bool2;
    if (paramInt2 > 0) {
      bool1 = true;
    }
    paramRecyclerView = ((WSFollowFragment)localObject).a(paramRecyclerView, bool1, true);
    uqf.a("WS_VIDEO_PRE_PLAY", "[WSFollowFragment.java][onScrolled] setPrePlayingHolder prePlayHolder:" + paramRecyclerView);
    WSFollowFragment.a(this.a).b(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ucu
 * JD-Core Version:    0.7.0.1
 */