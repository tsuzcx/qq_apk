package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.watcher.SaveCardWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CardPopChooseFragment$15
  implements SaveCardWatcher
{
  CardPopChooseFragment$15(CardPopChooseFragment paramCardPopChooseFragment) {}
  
  public void onBefore() {}
  
  public void onError(QMNetworkError paramQMNetworkError, int paramInt)
  {
    QMLog.log(4, CardPopChooseFragment.access$1900(this.this$0), "cardpreview h5url: error: " + paramInt, paramQMNetworkError);
    if (CardPopChooseFragment.access$100(this.this$0) == paramInt) {
      CardPopChooseFragment.access$3300(this.this$0, new CardPopChooseFragment.15.2(this));
    }
  }
  
  public void onSuccess(String paramString1, String paramString2, int paramInt)
  {
    QMLog.log(4, CardPopChooseFragment.access$1900(this.this$0), "cardpreview h5url: " + paramString1 + ", key: " + paramInt + ", " + CardPopChooseFragment.access$100(this.this$0));
    if (CardPopChooseFragment.access$100(this.this$0) == paramInt) {
      CardPopChooseFragment.access$3100(this.this$0, new CardPopChooseFragment.15.1(this, paramString1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.15
 * JD-Core Version:    0.7.0.1
 */