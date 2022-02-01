package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.watcher.LoadBirthdayFriendListWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CardBirthdayChooseFragment$2
  implements LoadBirthdayFriendListWatcher
{
  CardBirthdayChooseFragment$2(CardBirthdayChooseFragment paramCardBirthdayChooseFragment) {}
  
  public void onBefore()
  {
    CardBirthdayChooseFragment.access$400(this.this$0, new CardBirthdayChooseFragment.2.1(this));
  }
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "CardBirthdayChooseFragment", "LoadBirthdayFriendList error");
    CardBirthdayChooseFragment.access$800(this.this$0, new CardBirthdayChooseFragment.2.3(this));
  }
  
  public void onSuccess()
  {
    QMLog.log(4, "CardBirthdayChooseFragment", "LoadBirthdayFriendList success");
    CardBirthdayChooseFragment.access$600(this.this$0, new CardBirthdayChooseFragment.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment.2
 * JD-Core Version:    0.7.0.1
 */