package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.watcher.LoadQQHotFriendWatcher;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class CardPopChooseFragment$16
  implements LoadQQHotFriendWatcher
{
  CardPopChooseFragment$16(CardPopChooseFragment paramCardPopChooseFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    CardPopChooseFragment.access$3500(this.this$0, new CardPopChooseFragment.16.2(this));
  }
  
  public void onSuccess(int paramInt, List<MailContact> paramList)
  {
    CardPopChooseFragment.access$502(this.this$0, paramList);
    CardPopChooseFragment.access$602(this.this$0, true);
    CardPopChooseFragment.access$3400(this.this$0, new CardPopChooseFragment.16.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.16
 * JD-Core Version:    0.7.0.1
 */