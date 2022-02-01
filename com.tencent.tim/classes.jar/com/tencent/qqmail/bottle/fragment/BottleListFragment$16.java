package com.tencent.qqmail.bottle.fragment;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.controller.BottleListController.UpdateListWatcher;
import com.tencent.qqmail.bottle.controller.BottleListCursor;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.fragment.adapter.BottleListAdapter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;

class BottleListFragment$16
  implements BottleListController.UpdateListWatcher
{
  BottleListFragment$16(BottleListFragment paramBottleListFragment) {}
  
  public void onErrorInMainThread(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "BottleListFragment", "mUpdateListWatcher onErrorInMainThread");
    if (BottleListFragment.access$100(this.this$0).getCount() == 0)
    {
      BottleListFragment.access$1800(this.this$0).showTipsReload(2131690974, BottleListFragment.access$1700(this.this$0));
      BottleListFragment.access$200(this.this$0).setVisibility(8);
    }
    for (;;)
    {
      if (BottleListFragment.access$300(this.this$0))
      {
        if ((this.this$0.getTopBar() == null) || (this.this$0.getTopBar().getButtonRight() == null)) {
          break;
        }
        BottleListFragment.access$1200(this.this$0);
      }
      return;
      BottleListFragment.access$200(this.this$0).onRefreshComplete();
      BottleListFragment.access$100(this.this$0).setLoading(false, BottleListFragment.access$200(this.this$0));
      if (this.this$0.getActivity() != null) {
        Toast.makeText(QMApplicationContext.sharedInstance(), this.this$0.getString(2131697354), 1).show();
      }
    }
    QMLog.log(6, "BottleListFragment", "toggleNormalMode top bar is null");
  }
  
  public void onSuccessInMainThread(BottleListCursor paramBottleListCursor)
  {
    QMLog.log(6, "BottleListFragment", "mUpdateListWatcher onSuccessInMainThread");
    StringBuilder localStringBuilder = new StringBuilder().append("updateListWatcher: ");
    if ((BottleListFragment.access$1500(this.this$0) != null) && (BottleListFragment.access$1500(this.this$0).isCompleteOrIgnore())) {}
    for (boolean bool = true;; bool = false)
    {
      BottleManager.log(bool);
      if ((BottleListFragment.access$1500(this.this$0) == null) || (BottleListFragment.access$1500(this.this$0).isCompleteOrIgnore()))
      {
        BottleListFragment.access$200(this.this$0).onRefreshComplete();
        BottleListFragment.access$100(this.this$0).setLoading(false, BottleListFragment.access$200(this.this$0));
        BottleListFragment.access$1600(this.this$0, paramBottleListCursor);
      }
      if (BottleListFragment.access$300(this.this$0))
      {
        if ((this.this$0.getTopBar() == null) || (this.this$0.getTopBar().getButtonRight() == null)) {
          break;
        }
        BottleListFragment.access$1200(this.this$0);
      }
      return;
    }
    QMLog.log(6, "BottleListFragment", "toggleNormalMode top bar is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.16
 * JD-Core Version:    0.7.0.1
 */