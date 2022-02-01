package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.watcher.BatchLoadCardListWatch;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class CardPreviewFragment$3
  implements BatchLoadCardListWatch
{
  CardPreviewFragment$3(CardPreviewFragment paramCardPreviewFragment) {}
  
  public void onBefore()
  {
    CardPreviewFragment.access$1100(this.this$0, new CardPreviewFragment.3.1(this));
  }
  
  public void onError(ArrayList<String> paramArrayList, QMNetworkError paramQMNetworkError)
  {
    CardPreviewFragment.access$1800(this.this$0, new CardPreviewFragment.3.3(this));
  }
  
  public void onSuccess(ArrayList<String> paramArrayList)
  {
    CardPreviewFragment.access$1700(this.this$0, new CardPreviewFragment.3.2(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */