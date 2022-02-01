package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.model.QMCardData;

class CardBirthdayChooseFragment$7
  implements View.OnClickListener
{
  CardBirthdayChooseFragment$7(CardBirthdayChooseFragment paramCardBirthdayChooseFragment) {}
  
  public void onClick(View paramView)
  {
    CardBirthdayChooseFragment.access$1202(this.this$0, CardBirthdayChooseFragment.access$1100(this.this$0).getSaveCardKey(CardBirthdayChooseFragment.access$1300(this.this$0).getCardId(), CardBirthdayChooseFragment.access$1300(this.this$0).getCardParaList()));
    CardBirthdayChooseFragment.access$1100(this.this$0).saveCard(CardBirthdayChooseFragment.access$1300(this.this$0).getCardId(), CardBirthdayChooseFragment.access$1300(this.this$0).getCardParaList(), CardBirthdayChooseFragment.access$1400(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment.7
 * JD-Core Version:    0.7.0.1
 */