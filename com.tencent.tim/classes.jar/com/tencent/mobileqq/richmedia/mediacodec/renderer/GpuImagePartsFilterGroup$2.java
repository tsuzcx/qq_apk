package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import amas;
import amau;
import ambb;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(ambb paramambb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    amau localamau2 = null;
    amau localamau1;
    if ((ambb.a(this.this$0) == null) || (ambb.a(this.this$0).getFilterType() != this.dBy))
    {
      localamau1 = ambb.a(this.this$0);
      ambb.a(this.this$0, (amau)amas.a(this.dBy));
      ambb.a(this.this$0).init();
      ambb.a(this.this$0).onOutputSizeChanged(this.cFz, this.cFA);
    }
    for (;;)
    {
      if ((ambb.b(this.this$0) == null) || (ambb.b(this.this$0).getFilterType() != this.dBz))
      {
        localamau2 = ambb.b(this.this$0);
        ambb.b(this.this$0, (amau)amas.a(this.dBz));
        ambb.b(this.this$0).init();
        ambb.b(this.this$0).onOutputSizeChanged(this.cFz, this.cFA);
      }
      if ((this.dBA == 90) || (this.dBA == 270))
      {
        ambb.a(this.this$0).OJ(false);
        ambb.b(this.this$0).OJ(false);
      }
      for (;;)
      {
        ambb.a(this.this$0, this.zq);
        ambb.a(this.this$0).d(true, 0.1F * 2.0F + this.zq);
        ambb.b(this.this$0).d(false, this.zq);
        if (localamau1 != null) {
          localamau1.destroy();
        }
        if (localamau2 != null) {
          localamau2.destroy();
        }
        return;
        ambb.a(this.this$0).OJ(true);
        ambb.b(this.this$0).OJ(true);
      }
      localamau1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */