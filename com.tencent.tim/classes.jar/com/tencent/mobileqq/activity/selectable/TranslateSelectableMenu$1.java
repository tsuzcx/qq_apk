package com.tencent.mobileqq.activity.selectable;

import aawl;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import wja;

public class TranslateSelectableMenu$1
  implements Runnable
{
  public TranslateSelectableMenu$1(aawl paramaawl, ContainerView paramContainerView) {}
  
  public void run()
  {
    this.c.e.setLineSpacing(wja.dp2px(6.0F, this.c.getResources()), 1.0F);
    this.c.e.setTextSize(1, 24.0F);
    this.c.e.setGravity(8388611);
    int i = wja.dp2px(16.0F, this.c.getResources());
    int j = wja.dp2px(12.0F, this.c.getResources());
    this.c.e.setPadding(j, i, j, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu.1
 * JD-Core Version:    0.7.0.1
 */