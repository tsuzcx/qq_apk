package com.tencent.mobileqq.ar.ARPromotion;

import adbk;
import adbk.a;
import addo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class ARPromotionMediaPlayerWrapper$2
  implements Runnable
{
  public void run()
  {
    if (adbk.a(this.this$0)) {}
    for (;;)
    {
      return;
      try
      {
        adbk.a(this.this$0);
        adbk.a(this.this$0);
        if ((adbk.a(this.this$0) != null) && (adbk.a(this.this$0) != null))
        {
          adbk.a(this.this$0).bind();
          adbk.a(this.this$0, this.cY, this.cZ, this.da);
          if (!adbk.a(this.this$0).adI())
          {
            adbk.a(this.this$0).cQF();
            addo localaddo = adbk.a(this.this$0);
            adbk.a(this.this$0);
            localaddo.d(addo.bO);
          }
          adbk.a(this.this$0).a(adbk.a(this.this$0)[0], adbk.a(this.this$0)[1], adbk.a(this.this$0)[2], this.val$width, this.val$height);
          adbk.a(this.this$0).drawFrame();
          adbk.a(this.this$0).unbind();
          if ((adbk.b(this.this$0) == 2L) && (adbk.a(this.this$0) != null))
          {
            adbk.a(this.this$0).aK(adbk.b(this.this$0), 0, adbk.a(this.this$0).getTexId());
            QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupGlobalSceneRenderable ARWorldCupMediaPlayerWrapper.drawFrame softWare");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.i("ARWorldCupMediaPlayerWrapper", 1, "drawSoftFrame render error happen");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.2
 * JD-Core Version:    0.7.0.1
 */