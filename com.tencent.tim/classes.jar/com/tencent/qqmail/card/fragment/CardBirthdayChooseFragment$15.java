package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.watcher.BatchLoadCardListWatch;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class CardBirthdayChooseFragment$15
  implements BatchLoadCardListWatch
{
  CardBirthdayChooseFragment$15(CardBirthdayChooseFragment paramCardBirthdayChooseFragment) {}
  
  public void onBefore()
  {
    CardBirthdayChooseFragment.access$2400(this.this$0, new CardBirthdayChooseFragment.15.1(this));
  }
  
  public void onError(ArrayList<String> paramArrayList, QMNetworkError paramQMNetworkError)
  {
    CardBirthdayChooseFragment.access$2900(this.this$0, new CardBirthdayChooseFragment.15.3(this));
  }
  
  public void onSuccess(ArrayList<String> paramArrayList)
  {
    CardBirthdayChooseFragment.access$2800(this.this$0, new CardBirthdayChooseFragment.15.2(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment.15
 * JD-Core Version:    0.7.0.1
 */