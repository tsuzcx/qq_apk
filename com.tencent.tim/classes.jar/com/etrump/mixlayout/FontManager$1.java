package com.etrump.mixlayout;

import aqnl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import i;
import java.util.concurrent.atomic.AtomicBoolean;
import ku;

public class FontManager$1
  implements Runnable
{
  public FontManager$1(ku paramku) {}
  
  public void run()
  {
    switch (aqnl.af(aqnl.getSoDir(), "libFounderColorFont_818.so"))
    {
    default: 
      return;
    case 1: 
      ((VasQuickUpdateManager)this.this$0.mApp.getManager(184)).downloadItem(1004L, "libColorFont_818", "FontManager_initFZEngine");
      return;
    }
    i.a().p.set(true);
    aqnl.H(this.this$0.mApp);
    ku.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.1
 * JD-Core Version:    0.7.0.1
 */