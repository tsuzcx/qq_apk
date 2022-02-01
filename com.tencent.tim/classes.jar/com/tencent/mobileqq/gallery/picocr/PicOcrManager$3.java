package com.tencent.mobileqq.gallery.picocr;

import ahqt;
import ahqt.a;
import ahqw;
import ahqy;
import ahqz;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PicOcrManager$3
  implements Runnable
{
  public PicOcrManager$3(ahqt paramahqt, ahqt.a parama, ahqw paramahqw) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.c.bLq)) || (this.c.aIG))
    {
      this.c.bLq = ahqz.calcMD5(this.c.imagePath);
      this.c.aIG = false;
    }
    if (!ahqt.a(this.this$0).isEmpty())
    {
      ahqy localahqy = this.this$0.a(this.c.bLq);
      if (localahqy != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicOcrManager", 2, "requestOcr cacheRsp:" + localahqy.toString());
        }
        this.a.a(localahqy);
        return;
      }
    }
    ahqt.a(this.this$0, this.a, this.c);
    if (this.c.anV())
    {
      this.this$0.a(this.a, this.c);
      this.a.dpr();
      return;
    }
    this.a.onUpdate(100, false, new ahqy());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.3
 * JD-Core Version:    0.7.0.1
 */