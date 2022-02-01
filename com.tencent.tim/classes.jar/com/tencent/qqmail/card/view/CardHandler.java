package com.tencent.qqmail.card.view;

import com.tencent.qqmail.card.model.QMCardData;

public abstract interface CardHandler
{
  public abstract void onClickGoPreview(QMCardData paramQMCardData);
  
  public abstract void onClickGoThanksFriend(QMCardData paramQMCardData);
  
  public abstract void onLoadMoreInvoke();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardHandler
 * JD-Core Version:    0.7.0.1
 */