package com.tencent.qqmail.subscribe;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class SubscribeListFragment$4
  extends QMRefreshCallback
{
  SubscribeListFragment$4(SubscribeListFragment paramSubscribeListFragment, Runnable paramRunnable) {}
  
  public void onRefreshComplete()
  {
    if (SubscribeListFragment.access$000(this.this$0) == null) {}
    do
    {
      return;
      SubscribeListFragment.access$100(this.this$0);
    } while (this.val$operationComplete == null);
    this.val$operationComplete.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.4
 * JD-Core Version:    0.7.0.1
 */