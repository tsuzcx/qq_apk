package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import amas;
import amau;
import ambb;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(ambb paramambb, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    amau localamau1 = null;
    amau localamau2 = ambb.a(this.this$0);
    ambb.a(this.this$0, null);
    if ((ambb.b(this.this$0) == null) || (ambb.b(this.this$0).getFilterType() != this.dBx))
    {
      localamau1 = ambb.b(this.this$0);
      ambb.b(this.this$0, (amau)amas.a(this.dBx));
      ambb.b(this.this$0).init();
      ambb.b(this.this$0).onOutputSizeChanged(this.cFz, this.cFA);
    }
    ambb.b(this.this$0).d(false, 0.0F);
    ambb.a(this.this$0, 0.0F);
    if (localamau2 != null) {
      localamau2.destroy();
    }
    if (localamau1 != null) {
      localamau1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */