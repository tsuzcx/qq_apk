package com.tencent.qidian.controller;

import ashz;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import java.util.Map;

public class QidianPubAccountBigDataHandler$2
  implements Runnable
{
  public QidianPubAccountBigDataHandler$2(ashz paramashz, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.this$0.my(this.qL);
    PubAccountNavigationMenu localPubAccountNavigationMenu = (PubAccountNavigationMenu)this.this$0.pd.get(Long.valueOf(this.qL));
    if (localPubAccountNavigationMenu == null)
    {
      localPubAccountNavigationMenu = new PubAccountNavigationMenu();
      localPubAccountNavigationMenu.version = 0;
      localPubAccountNavigationMenu.puin = this.qL;
      localPubAccountNavigationMenu.xml = "";
    }
    for (;;)
    {
      ashz.a(this.this$0, this.qL, localPubAccountNavigationMenu, this.axi);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianPubAccountBigDataHandler.2
 * JD-Core Version:    0.7.0.1
 */