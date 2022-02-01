package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.OnActionCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class BottleConversationFragment$32
  implements OnActionCallback
{
  BottleConversationFragment$32(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onErrorInMainThread(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccessInMainThread(String paramString1, String paramString2)
  {
    this.this$0.refreshData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.32
 * JD-Core Version:    0.7.0.1
 */