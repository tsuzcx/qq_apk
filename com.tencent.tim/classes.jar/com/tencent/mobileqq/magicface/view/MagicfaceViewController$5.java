package com.tencent.mobileqq.magicface.view;

import aiyr;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import aqho;
import com.tencent.mobileqq.activity.BaseChatPie;

public class MagicfaceViewController$5
  implements Runnable
{
  public MagicfaceViewController$5(aiyr paramaiyr) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.gu.getLayoutParams();
    localLayoutParams.rightMargin = ((int)aqho.convertDpToPixel(this.this$0.c.a(), 10.0F));
    this.this$0.gu.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.5
 * JD-Core Version:    0.7.0.1
 */