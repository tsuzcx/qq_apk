import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;

public class ofa
  extends RecyclerView.OnScrollListener
{
  public ofa(WSFollowFragment paramWSFollowFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 1) {
      WSFollowFragment.a(this.this$0, true);
    }
    switch (paramInt)
    {
    default: 
      txn.a().startMonitorScene("weishi_follow_list");
      return;
    }
    txn.a().stopMonitorScene("weishi_follow_list", false);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (WSFollowFragment.a(this.this$0).a == null)
    {
      paramInt1 = WSFollowFragment.a(this.this$0).findFirstVisibleItemPosition();
      paramRecyclerView = WSFollowFragment.a(this.this$0, paramInt1, false);
      ooz.e("WSFollowContinuePlayLog", "mAdapter.mPlayingHolder is null. startPosition:" + paramInt1 + ", lastOrNextVideoHolder:" + paramRecyclerView);
      if (WSFollowFragment.a(this.this$0, paramRecyclerView))
      {
        if (!WSFollowFragment.a(this.this$0)) {
          break label149;
        }
        ooz.e("WSFollowContinuePlayLog", "[WSFollowFragment.java][onScrolled] mIsHandlingBackFromVertical true.");
      }
    }
    else
    {
      paramRecyclerView = this.this$0;
      localObject = WSFollowFragment.a(this.this$0).a;
      if (paramInt2 > 0) {}
      for (bool1 = true;; bool1 = false)
      {
        paramRecyclerView = paramRecyclerView.a((ojm)localObject, bool1, false);
        break;
      }
    }
    label149:
    ooz.ca("WSFollowContinuePlayLog", "[WSFollowFragment.java][onScrolled] playVideo title:" + paramRecyclerView.a.mTitle + ", mPlayingHolder:" + paramRecyclerView);
    WSFollowFragment.a(this.this$0, paramRecyclerView);
    Object localObject = this.this$0;
    boolean bool1 = bool2;
    if (paramInt2 > 0) {
      bool1 = true;
    }
    paramRecyclerView = ((WSFollowFragment)localObject).a(paramRecyclerView, bool1, true);
    ooz.i("WS_VIDEO_PRE_PLAY", "[WSFollowFragment.java][onScrolled] setPrePlayingHolder prePlayHolder:" + paramRecyclerView);
    WSFollowFragment.a(this.this$0).b(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofa
 * JD-Core Version:    0.7.0.1
 */