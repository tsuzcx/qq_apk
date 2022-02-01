package com.tencent.mobileqq.utils.dialogutils;

import android.content.Context;
import android.widget.TextView;
import com.tencent.widget.BubblePopupWindow;

class QQCustomMenuNoIconLayout$2
  extends TextView
{
  QQCustomMenuNoIconLayout$2(QQCustomMenuNoIconLayout paramQQCustomMenuNoIconLayout, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    this.a.popup.dismiss();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout.2
 * JD-Core Version:    0.7.0.1
 */