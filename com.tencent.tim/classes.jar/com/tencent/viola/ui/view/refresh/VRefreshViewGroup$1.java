package com.tencent.viola.ui.view.refresh;

import android.os.Handler;
import android.widget.Scroller;
import com.tencent.viola.ui.view.refresh.listener.IFooterCallBack;
import com.tencent.viola.ui.view.refresh.listener.IHeaderCallBack;
import java.util.ArrayList;
import java.util.Iterator;

class VRefreshViewGroup$1
  implements Runnable
{
  VRefreshViewGroup$1(VRefreshViewGroup paramVRefreshViewGroup) {}
  
  public void run()
  {
    int i;
    Iterator localIterator;
    if (VRefreshViewGroup.access$000(this.this$0).computeScrollOffset())
    {
      i = VRefreshViewGroup.access$100(this.this$0).mOffsetY;
      int j = VRefreshViewGroup.access$000(this.this$0).getCurrY();
      this.this$0.moveView(j - i);
      if ((!this.this$0.mPullLoading) && ((VRefreshViewGroup.access$200(this.this$0)) || (VRefreshViewGroup.access$300(this.this$0))))
      {
        localIterator = VRefreshViewGroup.access$400(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((RefreshMoveOberver)localIterator.next()).onRefreshMove(VRefreshViewGroup.access$000(this.this$0).getCurrY());
        }
      }
      if ((VRefreshViewGroup.access$500(this.this$0).isBottom()) && (VRefreshViewGroup.access$600(this.this$0)) && (VRefreshViewGroup.access$700(this.this$0) != null)) {
        VRefreshViewGroup.access$700(this.this$0).onMove(VRefreshViewGroup.access$000(this.this$0).getCurrY());
      }
      VRefreshViewGroup.access$800(this.this$0).post(this);
    }
    do
    {
      return;
      i = VRefreshViewGroup.access$000(this.this$0).getCurrY();
      if (VRefreshViewGroup.access$100(this.this$0).mOffsetY == 0)
      {
        if (VRefreshViewGroup.access$900(this.this$0))
        {
          localIterator = VRefreshViewGroup.access$400(this.this$0).iterator();
          while (localIterator.hasNext()) {
            ((RefreshMoveOberver)localIterator.next()).onRefreshMove(0);
          }
          if (VRefreshViewGroup.access$500(this.this$0).getContentViewProvider() != null) {
            VRefreshViewGroup.access$500(this.this$0).getContentViewProvider().onHeaderRebounded();
          }
        }
        if ((VRefreshViewGroup.access$500(this.this$0).isBottom()) && (VRefreshViewGroup.access$700(this.this$0) != null)) {
          VRefreshViewGroup.access$700(this.this$0).onFooterReachEnd();
        }
        this.this$0.mPullRefreshing = false;
        VRefreshViewGroup.access$1002(this.this$0, false);
        return;
      }
      if (VRefreshViewGroup.access$1100(this.this$0) != null) {
        VRefreshViewGroup.access$1100(this.this$0).onStickRefreshing();
      }
    } while ((!VRefreshViewGroup.access$1000(this.this$0)) || (this.this$0.mPullLoading) || (this.this$0.mPullRefreshing));
    this.this$0.startScroll(-i, this.this$0.computeScrollVerticalDuration(i, this.this$0.getHeight()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.refresh.VRefreshViewGroup.1
 * JD-Core Version:    0.7.0.1
 */