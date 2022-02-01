package com.tencent.mobileqq.activity;

import auru;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import jqc;
import wfs;

public class VipProfileCardDiyActivity$4$1
  implements Runnable
{
  public VipProfileCardDiyActivity$4$1(wfs paramwfs, Card paramCard) {}
  
  public void run()
  {
    if (this.a.this$0.a((int)this.c.lCurrentStyleId, (int)this.c.lCurrentBgId, this.c.backgroundUrl, (int)this.c.backgroundColor, this.c.templateRet)) {
      this.a.this$0.a.sendEmptyMessage(0);
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C2", "", 1, 0, 0, jqc.hS(), "0", String.valueOf(this.a.this$0.bMM));
      return;
      this.a.this$0.a.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.4.1
 * JD-Core Version:    0.7.0.1
 */