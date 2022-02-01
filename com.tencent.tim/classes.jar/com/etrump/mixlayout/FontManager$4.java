package com.etrump.mixlayout;

import acff;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import ku;

public class FontManager$4
  implements Runnable
{
  public FontManager$4(ku paramku, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((acff)this.this$0.mApp.getManager(51)).a(this.val$uin);
    ku.a(this.this$0.mApp, this.val$uin, localExtensionInfo, this.iI, this.iK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.4
 * JD-Core Version:    0.7.0.1
 */