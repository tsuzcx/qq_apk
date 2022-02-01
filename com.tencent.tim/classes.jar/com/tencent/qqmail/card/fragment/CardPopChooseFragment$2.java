package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.model.QMCardData;

class CardPopChooseFragment$2
  implements View.OnClickListener
{
  CardPopChooseFragment$2(CardPopChooseFragment paramCardPopChooseFragment) {}
  
  public void onClick(View paramView)
  {
    if (CardPopChooseFragment.access$000(this.this$0) != null)
    {
      CardPopChooseFragment.access$102(this.this$0, CardPopChooseFragment.access$200(this.this$0).getSaveCardKey(CardPopChooseFragment.access$000(this.this$0).getCardId(), CardPopChooseFragment.access$000(this.this$0).getCardParaList()));
      CardPopChooseFragment.access$200(this.this$0).saveCard(CardPopChooseFragment.access$000(this.this$0).getCardId(), CardPopChooseFragment.access$000(this.this$0).getCardParaList(), CardPopChooseFragment.access$300(this.this$0).getDefaultMailAccount());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.2
 * JD-Core Version:    0.7.0.1
 */