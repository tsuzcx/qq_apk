package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.view.CardHandler;
import com.tencent.qqmail.protocol.DataCollector;

class CardGalleryFragment$1
  implements CardHandler
{
  CardGalleryFragment$1(CardGalleryFragment paramCardGalleryFragment) {}
  
  public void onClickGoPreview(QMCardData paramQMCardData)
  {
    DataCollector.logEvent("Event_Card_Preview");
    paramQMCardData = new CardPreviewFragment(CardGalleryFragment.access$000(this.this$0), paramQMCardData);
    this.this$0.startFragment(paramQMCardData);
  }
  
  public void onClickGoThanksFriend(QMCardData paramQMCardData)
  {
    paramQMCardData = new CardThanksListFragment(paramQMCardData);
    this.this$0.startFragment(paramQMCardData);
  }
  
  public void onLoadMoreInvoke() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment.1
 * JD-Core Version:    0.7.0.1
 */