package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.card.QMCardManager;

class CardPopChooseFragment$6
  implements Runnable
{
  CardPopChooseFragment$6(CardPopChooseFragment paramCardPopChooseFragment, Account paramAccount) {}
  
  public void run()
  {
    int i = this.val$firstQQAccount.getId();
    QMCardManager.shareInstance().loadQQHotFriend(i, CardPopChooseFragment.access$1100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.6
 * JD-Core Version:    0.7.0.1
 */