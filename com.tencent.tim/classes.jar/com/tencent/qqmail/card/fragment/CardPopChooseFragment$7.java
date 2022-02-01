package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.QMCardManager;
import java.util.ArrayList;

class CardPopChooseFragment$7
  implements Runnable
{
  CardPopChooseFragment$7(CardPopChooseFragment paramCardPopChooseFragment, ArrayList paramArrayList) {}
  
  public void run()
  {
    CardPopChooseFragment.access$200(this.this$0).batchSyncCardByCardIds(this.val$cardIds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.7
 * JD-Core Version:    0.7.0.1
 */