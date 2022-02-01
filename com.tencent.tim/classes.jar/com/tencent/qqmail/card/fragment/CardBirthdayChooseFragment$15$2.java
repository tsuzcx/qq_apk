package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;

class CardBirthdayChooseFragment$15$2
  implements Runnable
{
  CardBirthdayChooseFragment$15$2(CardBirthdayChooseFragment.15 param15, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.val$cardIds != null) && (this.val$cardIds.size() > 0))
    {
      QMLog.log(4, "CardBirthdayChooseFragment", "batch load card list success:" + this.val$cardIds.toString());
      if (CardBirthdayChooseFragment.access$2500(this.this$1.this$0).equals(this.val$cardIds.get(0)))
      {
        CardBirthdayChooseFragment.access$1302(this.this$1.this$0, CardBirthdayChooseFragment.access$1100(this.this$1.this$0).getCardDataByCardId(CardBirthdayChooseFragment.access$2500(this.this$1.this$0)));
        CardBirthdayChooseFragment.access$2600(this.this$1.this$0);
        CardBirthdayChooseFragment.access$2700(this.this$1.this$0, CardBirthdayChooseFragment.access$1300(this.this$1.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment.15.2
 * JD-Core Version:    0.7.0.1
 */