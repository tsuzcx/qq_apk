package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.view.CardAvatarChooseView;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class CardPopChooseFragment$10
  implements SyncPhotoWatcher
{
  CardPopChooseFragment$10(CardPopChooseFragment paramCardPopChooseFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError) {}
  
  public void onSuccess(List<String> paramList)
  {
    int i = 0;
    while (i < CardPopChooseFragment.access$1800(this.this$0).size())
    {
      String str = (String)((CardAvatarChooseView)CardPopChooseFragment.access$1800(this.this$0).get(i)).getTag();
      CardAvatarChooseView localCardAvatarChooseView = (CardAvatarChooseView)CardPopChooseFragment.access$1800(this.this$0).get(i);
      boolean bool = paramList.contains(str);
      QMLog.log(5, CardPopChooseFragment.access$1900(this.this$0), "syncPhotoWatcher success: " + str + ", " + bool);
      if (bool) {
        CardPopChooseFragment.access$2000(this.this$0, new CardPopChooseFragment.10.1(this, str, localCardAvatarChooseView));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.10
 * JD-Core Version:    0.7.0.1
 */