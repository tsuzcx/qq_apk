package com.tencent.qqmail.card.view.card;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.view.CardHandler;

class MineCard$1
  implements View.OnClickListener
{
  MineCard$1(MineCard paramMineCard, QMCardData paramQMCardData) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mCardHandler != null) {
      this.this$0.mCardHandler.onClickGoThanksFriend(this.val$item);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.card.MineCard.1
 * JD-Core Version:    0.7.0.1
 */