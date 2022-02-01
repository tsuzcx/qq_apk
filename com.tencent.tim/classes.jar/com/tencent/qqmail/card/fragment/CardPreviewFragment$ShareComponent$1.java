package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.watcher.SaveCardWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class CardPreviewFragment$ShareComponent$1
  implements SaveCardWatcher
{
  CardPreviewFragment$ShareComponent$1(CardPreviewFragment.ShareComponent paramShareComponent) {}
  
  public void onBefore() {}
  
  public void onError(QMNetworkError paramQMNetworkError, int paramInt)
  {
    QMLog.log(4, "CardPreviewFragment", "cardPreview h5url: error: " + paramInt, paramQMNetworkError);
    if (CardPreviewFragment.ShareComponent.access$2600(this.this$1) == paramInt) {
      CardPreviewFragment.access$3200(this.this$1.this$0, new CardPreviewFragment.ShareComponent.1.2(this, paramQMNetworkError));
    }
  }
  
  public void onSuccess(String paramString1, String paramString2, int paramInt)
  {
    QMLog.log(4, "CardPreviewFragment", "cardPreview h5url: " + paramString1 + ", key: " + paramInt + ", " + CardPreviewFragment.ShareComponent.access$2600(this.this$1));
    if (CardPreviewFragment.ShareComponent.access$2600(this.this$1) == paramInt) {
      CardPreviewFragment.access$3000(this.this$1.this$0, new CardPreviewFragment.ShareComponent.1.1(this, paramString1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPreviewFragment.ShareComponent.1
 * JD-Core Version:    0.7.0.1
 */