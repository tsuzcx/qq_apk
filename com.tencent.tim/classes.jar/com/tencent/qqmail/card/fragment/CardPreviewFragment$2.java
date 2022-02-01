package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class CardPreviewFragment$2
  implements SyncPhotoWatcher
{
  CardPreviewFragment$2(CardPreviewFragment paramCardPreviewFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(5, "CardPreviewFragment", "syncPhotoWatcher error", paramQMNetworkError);
  }
  
  public void onSuccess(List<String> paramList)
  {
    String str = CardPreviewFragment.access$800(this.this$0).getDefaultAccount().getEmail();
    boolean bool = paramList.contains(str);
    QMLog.log(5, "CardPreviewFragment", "syncPhotoWatcher succ: " + str + ", " + bool);
    if (bool)
    {
      paramList = QMSettingManager.sharedInstance().getAccountIconLocal(str, 3);
      if (paramList != null) {
        CardPreviewFragment.access$900(this.this$0, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */