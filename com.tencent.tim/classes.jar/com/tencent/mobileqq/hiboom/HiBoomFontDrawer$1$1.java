package com.tencent.mobileqq.hiboom;

import ahxo.a;
import ahxp;
import com.Vas.ColorFont.FreeTypeLib;
import com.tencent.qphone.base.util.QLog;
import i;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

class HiBoomFontDrawer$1$1
  implements Runnable
{
  HiBoomFontDrawer$1$1(HiBoomFontDrawer.1 param1) {}
  
  public void run()
  {
    if (!i.a().v.get())
    {
      i.a().a().Z();
      i.a().v.set(true);
    }
    if (this.a.this$0.dbM == -1)
    {
      String str = this.a.this$0.a.getFontPath() + this.a.this$0.mFontId + File.separator + this.a.this$0.mFontId + ".fz4";
      this.a.this$0.dbM = i.a().b(this.a.this$0.mFontId, str);
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.FontDrawer", 2, "initColorFont: fontid=" + this.a.this$0.mFontId + " result=" + this.a.this$0.dbM);
      }
      this.a.this$0.cX.set(true);
      this.a.this$0.cY.set(false);
      if (this.a.this$0.cX.get()) {
        ahxp.a(this.a.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.1.1
 * JD-Core Version:    0.7.0.1
 */