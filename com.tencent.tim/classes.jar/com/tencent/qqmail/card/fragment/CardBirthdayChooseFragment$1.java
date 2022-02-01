package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class CardBirthdayChooseFragment$1
  extends QMRefreshCallback
{
  CardBirthdayChooseFragment$1(CardBirthdayChooseFragment paramCardBirthdayChooseFragment) {}
  
  public void onBeforeRefresh()
  {
    CardBirthdayChooseFragment.access$100(this.this$0, new CardBirthdayChooseFragment.1.1(this));
  }
  
  public void onRefreshComplete()
  {
    CardBirthdayChooseFragment.access$202(this.this$0, false);
    CardBirthdayChooseFragment.access$300(this.this$0, new CardBirthdayChooseFragment.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment.1
 * JD-Core Version:    0.7.0.1
 */