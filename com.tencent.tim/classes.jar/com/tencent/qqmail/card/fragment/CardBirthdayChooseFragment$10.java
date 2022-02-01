package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.watcher.SaveCardWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CardBirthdayChooseFragment$10
  implements SaveCardWatcher
{
  CardBirthdayChooseFragment$10(CardBirthdayChooseFragment paramCardBirthdayChooseFragment) {}
  
  public void onBefore() {}
  
  public void onError(QMNetworkError paramQMNetworkError, int paramInt)
  {
    QMLog.log(4, "CardBirthdayChooseFragment", "cardpreview h5url: error: " + paramInt, paramQMNetworkError);
    if (CardBirthdayChooseFragment.access$1200(this.this$0) == paramInt) {
      CardBirthdayChooseFragment.access$1800(this.this$0, new CardBirthdayChooseFragment.10.2(this));
    }
  }
  
  public void onSuccess(String paramString1, String paramString2, int paramInt)
  {
    QMLog.log(4, "CardBirthdayChooseFragment", "cardpreview h5url: " + paramString1 + ", key: " + paramInt + ", " + CardBirthdayChooseFragment.access$1200(this.this$0));
    if (CardBirthdayChooseFragment.access$1200(this.this$0) == paramInt) {
      CardBirthdayChooseFragment.access$1600(this.this$0, new CardBirthdayChooseFragment.10.1(this, paramString1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment.10
 * JD-Core Version:    0.7.0.1
 */