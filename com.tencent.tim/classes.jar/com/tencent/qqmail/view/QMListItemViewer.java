package com.tencent.qqmail.view;

import android.widget.Checkable;

public abstract interface QMListItemViewer
  extends Checkable
{
  public abstract void setItemToEditMode();
  
  public abstract void setItemToNormalMode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMListItemViewer
 * JD-Core Version:    0.7.0.1
 */