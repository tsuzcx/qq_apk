package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class CardPreviewFragment$10
  implements View.OnClickListener
{
  CardPreviewFragment$10(CardPreviewFragment paramCardPreviewFragment) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_Card_QQ_Share");
    CardPreviewFragment.access$2100(this.this$0).share(ShareLinkToExternal.SharedType.SHARE_TO_QQ_FRIEND);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPreviewFragment.10
 * JD-Core Version:    0.7.0.1
 */