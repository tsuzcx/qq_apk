package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.QMCardManager;
import java.util.ArrayList;

class CardPreviewFragment$4
  implements Runnable
{
  CardPreviewFragment$4(CardPreviewFragment paramCardPreviewFragment, ArrayList paramArrayList) {}
  
  public void run()
  {
    CardPreviewFragment.access$800(this.this$0).batchSyncCardByCardIds(this.val$cardIds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPreviewFragment.4
 * JD-Core Version:    0.7.0.1
 */