package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CardBirthdayPreviewFragment$4
  implements View.OnClickListener
{
  CardBirthdayPreviewFragment$4(CardBirthdayPreviewFragment paramCardBirthdayPreviewFragment) {}
  
  public void onClick(View paramView)
  {
    CardPreviewFragment localCardPreviewFragment = new CardPreviewFragment(0, null);
    this.this$0.startFragment(localCardPreviewFragment);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayPreviewFragment.4
 * JD-Core Version:    0.7.0.1
 */