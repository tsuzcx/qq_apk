package com.etrump.mixlayout;

import aqnl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import ku;

public class FontManager$10
  implements Runnable
{
  public FontManager$10(ku paramku, String paramString, int paramInt) {}
  
  public void run()
  {
    if (ku.a(this.this$0).containsKey(this.val$uin))
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)ku.a(this.this$0).get(this.val$uin);
      if (localConcurrentHashMap.containsKey(Integer.valueOf(this.iI)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "updateDiyConfig uin = " + this.val$uin + " fontId = " + this.iI);
        }
        localConcurrentHashMap.remove(Integer.valueOf(this.iI));
        aqnl.H(this.this$0.mApp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.10
 * JD-Core Version:    0.7.0.1
 */