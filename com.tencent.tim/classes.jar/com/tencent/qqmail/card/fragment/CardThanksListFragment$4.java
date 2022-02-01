package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.QMCardManager;

class CardThanksListFragment$4
  implements Runnable
{
  CardThanksListFragment$4(CardThanksListFragment paramCardThanksListFragment) {}
  
  public void run()
  {
    QMCardManager.shareInstance().syncThankList(CardThanksListFragment.access$1000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardThanksListFragment.4
 * JD-Core Version:    0.7.0.1
 */