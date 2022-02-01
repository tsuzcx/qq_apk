package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.watcher.LoadCardListWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CardGalleryFragment$11
  implements LoadCardListWatcher
{
  CardGalleryFragment$11(CardGalleryFragment paramCardGalleryFragment) {}
  
  public void onBefore(int paramInt) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "CardGalleryFragment", "LoadCardListWatcher error: " + paramInt + ", mTypeId: " + CardGalleryFragment.access$000(this.this$0));
    CardGalleryFragment.access$2800(this.this$0, new CardGalleryFragment.11.2(this, paramInt));
  }
  
  public void onSuccess(int paramInt)
  {
    QMLog.log(4, "CardGalleryFragment", "LoadCardListWatcher success: " + paramInt + ", mTypeId: " + CardGalleryFragment.access$000(this.this$0));
    CardGalleryFragment.access$2500(this.this$0, new CardGalleryFragment.11.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.11
 * JD-Core Version:    0.7.0.1
 */