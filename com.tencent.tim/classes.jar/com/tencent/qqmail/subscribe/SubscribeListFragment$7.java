package com.tencent.qqmail.subscribe;

import android.view.View;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeSubscribeListView.OnSubscribeItemClickListener;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;

class SubscribeListFragment$7
  implements PopularizeSubscribeListView.OnSubscribeItemClickListener
{
  SubscribeListFragment$7(SubscribeListFragment paramSubscribeListFragment) {}
  
  public void onItemClick(int paramInt, Popularize paramPopularize, View paramView)
  {
    PopularizeUIHelper.handleActionAndGotoLink(this.this$0.getActivity(), paramPopularize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.7
 * JD-Core Version:    0.7.0.1
 */