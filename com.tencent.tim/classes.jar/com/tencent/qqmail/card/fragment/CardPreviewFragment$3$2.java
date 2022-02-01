package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.BottomHorizonLineView;
import com.tencent.qqmail.utilities.ui.PressableImageView;
import java.util.ArrayList;

class CardPreviewFragment$3$2
  implements Runnable
{
  CardPreviewFragment$3$2(CardPreviewFragment.3 param3, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 0;
    if ((this.val$cardIds != null) && (this.val$cardIds.size() > 0))
    {
      QMLog.log(4, "CardPreviewFragment", "batch load card list success:" + this.val$cardIds.toString());
      if (CardPreviewFragment.access$1200(this.this$1.this$0).equals(this.val$cardIds.get(0)))
      {
        CardPreviewFragment.access$102(this.this$1.this$0, CardPreviewFragment.access$800(this.this$1.this$0).getCardDataByCardId(CardPreviewFragment.access$1200(this.this$1.this$0)));
        CardPreviewFragment.access$100(this.this$1.this$0).setCardParaList(CardPreviewFragment.access$800(this.this$1.this$0).getCardParaListByCardId(CardPreviewFragment.access$100(this.this$1.this$0).getCardId()));
        CardPreviewFragment localCardPreviewFragment = this.this$1.this$0;
        if (CardPreviewFragment.access$100(this.this$1.this$0).getCardParaList() != null) {
          break label362;
        }
        CardPreviewFragment.access$1302(localCardPreviewFragment, new ArrayList(i));
        CardPreviewFragment.access$1400(this.this$1.this$0);
        CardPreviewFragment.access$302(this.this$1.this$0, CardPreviewFragment.access$800(this.this$1.this$0).getCardDataContent(CardPreviewFragment.access$100(this.this$1.this$0).getCardUrl()));
        if (CardPreviewFragment.access$300(this.this$1.this$0) != null) {
          break label382;
        }
        CardPreviewFragment.access$1000(this.this$1.this$0);
        CardPreviewFragment.access$800(this.this$1.this$0).loadCardDataContent(CardPreviewFragment.access$100(this.this$1.this$0).getCardId(), CardPreviewFragment.access$100(this.this$1.this$0).getCardUrl());
      }
    }
    for (;;)
    {
      CardPreviewFragment.access$1600(this.this$1.this$0).addItem(2130840864, new CardPreviewFragment.3.2.1(this), true);
      CardPreviewFragment.access$1600(this.this$1.this$0).getPressableImageViewByResourcesId(2130840864).setContentDescription(this.this$1.this$0.getString(2131720805));
      CardPreviewFragment.access$1600(this.this$1.this$0).toggleRightFixedViewVisiable(true);
      return;
      label362:
      i = CardPreviewFragment.access$100(this.this$1.this$0).getCardParaList().size();
      break;
      label382:
      CardPreviewFragment.access$200(this.this$1.this$0);
      CardPreviewFragment.access$400(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPreviewFragment.3.2
 * JD-Core Version:    0.7.0.1
 */