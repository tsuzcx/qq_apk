package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.watcher.LoadCardContentWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CardPreviewFragment$1
  implements LoadCardContentWatcher
{
  CardPreviewFragment$1(CardPreviewFragment paramCardPreviewFragment) {}
  
  public void onError(String paramString, QMNetworkError paramQMNetworkError)
  {
    CardPreviewFragment.access$700(this.this$0, new CardPreviewFragment.1.2(this, paramString));
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    CardPreviewFragment.access$500(this.this$0, new CardPreviewFragment.1.1(this, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */