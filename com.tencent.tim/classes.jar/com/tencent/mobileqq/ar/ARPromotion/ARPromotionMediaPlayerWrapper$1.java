package com.tencent.mobileqq.ar.ARPromotion;

import adbk;
import adbk.a;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ARPromotionMediaPlayerWrapper$1
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$1(adbk paramadbk) {}
  
  public void run()
  {
    try
    {
      if (adbk.a(this.this$0)) {
        return;
      }
      if (adbk.a(this.this$0) != null)
      {
        adbk.a(this.this$0).updateTexImage();
        adbk.a(this.this$0).getTransformMatrix(adbk.a(this.this$0));
        adbk.a(this.this$0);
        adbk.a(this.this$0);
        Matrix.setIdentityM(adbk.b(this.this$0), 0);
        adbk.a(this.this$0).bind();
        adbk.a(this.this$0).drawTexture(36197, adbk.a(this.this$0), adbk.a(this.this$0), adbk.b(this.this$0));
        adbk.a(this.this$0).unbind();
        if ((adbk.b(this.this$0) == 2L) && (adbk.a(this.this$0) != null))
        {
          adbk.a(this.this$0).aK(adbk.b(this.this$0), 0, adbk.a(this.this$0).getTexId());
          QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.drawFrame hardWare");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("ARWorldCupMediaPlayerWrapper", 1, "mUpdateHardTextureRunnable fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */