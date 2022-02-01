package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.model.contact.QMContactManager;

class CardPopChooseFragment$5
  implements Runnable
{
  CardPopChooseFragment$5(CardPopChooseFragment paramCardPopChooseFragment, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {}
  
  public void run()
  {
    CardPopChooseFragment.access$502(this.this$0, QMContactManager.sharedInstance().getContactByAccountsAndTypes(this.val$accountIds, this.val$finalTypes));
    CardPopChooseFragment.access$602(this.this$0, true);
    CardPopChooseFragment.access$1000(this.this$0, new CardPopChooseFragment.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.5
 * JD-Core Version:    0.7.0.1
 */