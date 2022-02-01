package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class CardPreviewFragment$6
  implements View.OnClickListener
{
  CardPreviewFragment$6(CardPreviewFragment paramCardPreviewFragment) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_Card_Edit");
    CardPreviewFragment.access$1500(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPreviewFragment.6
 * JD-Core Version:    0.7.0.1
 */