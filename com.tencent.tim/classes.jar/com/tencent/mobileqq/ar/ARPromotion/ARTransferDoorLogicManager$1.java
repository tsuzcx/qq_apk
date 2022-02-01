package com.tencent.mobileqq.ar.ARPromotion;

import adbn;
import adii;
import adii.b;
import adku;
import android.graphics.PointF;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ARTransferDoorLogicManager$1
  implements Runnable
{
  public ARTransferDoorLogicManager$1(adbn paramadbn, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    int i = 0;
    if (i < 2)
    {
      if (adbn.a(this.this$0).a.cGz <= adbn.a(this.this$0).a.cGx - 1) {
        break label106;
      }
      adbn.a(this.this$0, true);
    }
    label106:
    while (adbn.a(this.this$0) == true)
    {
      if ((!adbn.a(this.this$0)) && (this.this$0.gl != null) && (this.this$0.gl.get() != null)) {
        ((adku)this.this$0.gl.get()).g(this, adbn.a(this.this$0));
      }
      return;
    }
    Object localObject = adbn.a(this.this$0).a.d[adbn.a(this.this$0).a.cGz];
    localObject = ARLocalGestureCircleRecog.a(this.cBW, this.cBX, this.cBY, this.cBZ, (PointF)localObject);
    int j = (int)((PointF)localObject).x;
    int k = (int)((PointF)localObject).y;
    int m = adbn.a(this.this$0).a.kw[adbn.a(this.this$0).a.cGz];
    localObject = this.this$0;
    if (adbn.a(this.this$0).a.cGz == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((adbn)localObject).a(new int[] { j }, new int[] { k }, new int[] { m }, bool);
      localObject = adbn.a(this.this$0).a;
      ((adii.b)localObject).cGz += 1;
      QLog.i(adbn.TAG, 1, "DrawCircle. mDrawCirclePuase = " + adbn.a(this.this$0) + ", genIdx = " + adbn.a(this.this$0).a.cGz);
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.1
 * JD-Core Version:    0.7.0.1
 */