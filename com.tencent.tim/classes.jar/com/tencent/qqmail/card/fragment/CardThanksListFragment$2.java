package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.watcher.LoadThankListWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CardThanksListFragment$2
  implements LoadThankListWatcher
{
  CardThanksListFragment$2(CardThanksListFragment paramCardThanksListFragment) {}
  
  public void onBefore()
  {
    CardThanksListFragment.access$400(this.this$0, new CardThanksListFragment.2.1(this));
  }
  
  public void onError(String paramString, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "CardThanksListFragment", "LoadThankFriendList error");
    CardThanksListFragment.access$700(this.this$0, new CardThanksListFragment.2.3(this));
  }
  
  public void onSuccess(String paramString)
  {
    QMLog.log(4, "CardThanksListFragment", "LoadThankFriendList success");
    CardThanksListFragment.access$600(this.this$0, new CardThanksListFragment.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardThanksListFragment.2
 * JD-Core Version:    0.7.0.1
 */