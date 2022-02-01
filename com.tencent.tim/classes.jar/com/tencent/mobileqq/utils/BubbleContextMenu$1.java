package com.tencent.mobileqq.utils;

import android.content.Context;
import android.widget.TextView;
import com.tencent.widget.BubblePopupWindow;

public final class BubbleContextMenu$1
  extends TextView
{
  public BubbleContextMenu$1(Context paramContext, BubblePopupWindow paramBubblePopupWindow)
  {
    super(paramContext);
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    this.b.dismiss();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BubbleContextMenu.1
 * JD-Core Version:    0.7.0.1
 */