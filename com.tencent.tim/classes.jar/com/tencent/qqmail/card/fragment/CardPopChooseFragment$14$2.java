package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;

class CardPopChooseFragment$14$2
  implements Runnable
{
  CardPopChooseFragment$14$2(CardPopChooseFragment.14 param14, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.val$cardIds != null) && (this.val$cardIds.size() > 0))
    {
      QMLog.log(4, CardPopChooseFragment.access$1900(this.this$1.this$0), "batch load card list success:" + this.val$cardIds.toString());
      if (CardPopChooseFragment.access$2400(this.this$1.this$0).equals(this.val$cardIds.get(0)))
      {
        CardPopChooseFragment.access$002(this.this$1.this$0, CardPopChooseFragment.access$200(this.this$1.this$0).getCardDataByCardId(CardPopChooseFragment.access$2400(this.this$1.this$0)));
        CardPopChooseFragment.access$2500(this.this$1.this$0);
        CardPopChooseFragment.access$2600(this.this$1.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.14.2
 * JD-Core Version:    0.7.0.1
 */