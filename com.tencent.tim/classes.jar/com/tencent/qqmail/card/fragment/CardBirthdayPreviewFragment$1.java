package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CardBirthdayPreviewFragment$1
  implements View.OnClickListener
{
  CardBirthdayPreviewFragment$1(CardBirthdayPreviewFragment paramCardBirthdayPreviewFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */