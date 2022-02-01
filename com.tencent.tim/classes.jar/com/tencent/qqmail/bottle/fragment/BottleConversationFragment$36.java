package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleConversationController.ConversationSyncWatcher;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;

class BottleConversationFragment$36
  implements BottleConversationController.ConversationSyncWatcher
{
  BottleConversationFragment$36(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onEndInMainThread()
  {
    this.this$0.getTopBar().showLoading(false);
  }
  
  public void onStartInMainThread()
  {
    if (!BottleConversationFragment.access$3600(this.this$0).isLoading()) {
      this.this$0.getTopBar().showLoading(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.36
 * JD-Core Version:    0.7.0.1
 */