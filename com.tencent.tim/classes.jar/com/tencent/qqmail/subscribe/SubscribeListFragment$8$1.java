package com.tencent.qqmail.subscribe;

import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeSubscribeListView;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;

class SubscribeListFragment$8$1
  implements Runnable
{
  SubscribeListFragment$8$1(SubscribeListFragment.8 param8, Popularize paramPopularize) {}
  
  public void run()
  {
    PopularizeUIHelper.handleCancel(this.val$deletePopularize);
    SubscribeListFragment.access$1300(this.this$1.this$0).render(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.8.1
 * JD-Core Version:    0.7.0.1
 */