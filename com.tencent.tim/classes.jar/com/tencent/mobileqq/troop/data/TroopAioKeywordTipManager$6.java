package com.tencent.mobileqq.troop.data;

import apad;
import apan;
import java.util.List;

public class TroopAioKeywordTipManager$6
  implements Runnable
{
  public TroopAioKeywordTipManager$6(apan paramapan, String paramString1, String paramString2, Integer paramInteger) {}
  
  public void run()
  {
    String str = apan.a(this.this$0, this.val$uin, this.val$keyword, this.ar);
    synchronized (this.this$0.Hx)
    {
      if (!this.this$0.Hx.contains(str)) {
        this.this$0.Hx.add(str);
      }
      apad.aR(this.this$0.mApp, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.6
 * JD-Core Version:    0.7.0.1
 */