package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.watcher.DeleteCardWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CardGalleryFragment$12
  implements DeleteCardWatcher
{
  CardGalleryFragment$12(CardGalleryFragment paramCardGalleryFragment) {}
  
  public void onError(String paramString, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "CardGalleryFragment", "delete card error:" + paramString);
  }
  
  public void onLocalSuccess(String paramString)
  {
    QMLog.log(4, "CardGalleryFragment", "delete card local success:" + paramString);
    CardGalleryFragment.access$2900(this.this$0, new CardGalleryFragment.12.1(this));
  }
  
  public void onSuccess(String paramString)
  {
    QMLog.log(4, "CardGalleryFragment", "delete card success:" + paramString);
    CardGalleryFragment.access$3000(this.this$0, new CardGalleryFragment.12.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.12
 * JD-Core Version:    0.7.0.1
 */