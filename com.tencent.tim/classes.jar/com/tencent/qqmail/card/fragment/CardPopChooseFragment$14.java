package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.watcher.BatchLoadCardListWatch;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class CardPopChooseFragment$14
  implements BatchLoadCardListWatch
{
  CardPopChooseFragment$14(CardPopChooseFragment paramCardPopChooseFragment) {}
  
  public void onBefore()
  {
    CardPopChooseFragment.access$2300(this.this$0, new CardPopChooseFragment.14.1(this));
  }
  
  public void onError(ArrayList<String> paramArrayList, QMNetworkError paramQMNetworkError)
  {
    CardPopChooseFragment.access$2900(this.this$0, new CardPopChooseFragment.14.3(this));
  }
  
  public void onSuccess(ArrayList<String> paramArrayList)
  {
    CardPopChooseFragment.access$2700(this.this$0, new CardPopChooseFragment.14.2(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.14
 * JD-Core Version:    0.7.0.1
 */