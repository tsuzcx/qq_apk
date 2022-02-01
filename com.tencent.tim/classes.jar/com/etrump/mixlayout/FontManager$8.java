package com.etrump.mixlayout;

import acff;
import aqgm;
import com.tencent.qphone.base.util.QLog;
import ku;

public class FontManager$8
  implements Runnable
{
  public void run()
  {
    if (this.a.a(this.val$uin) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> extensionInfo is null.");
      }
      aqgm.UC(this.val$uin);
      aqgm.ez(this.this$0.mApp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.8
 * JD-Core Version:    0.7.0.1
 */