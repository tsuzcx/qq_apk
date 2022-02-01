package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import ayyl;
import ayyn;
import ayyw;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(ayyw paramayyw, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    ayyn localayyn2 = null;
    ayyn localayyn1;
    if ((ayyw.a(this.this$0) == null) || (ayyw.a(this.this$0).getFilterType() != this.dBy))
    {
      localayyn1 = ayyw.a(this.this$0);
      ayyw.a(this.this$0, (ayyn)ayyl.a(this.dBy));
      ayyw.a(this.this$0).init();
      ayyw.a(this.this$0).onOutputSizeChanged(this.cFz, this.cFA);
    }
    for (;;)
    {
      if ((ayyw.b(this.this$0) == null) || (ayyw.b(this.this$0).getFilterType() != this.dBz))
      {
        localayyn2 = ayyw.b(this.this$0);
        ayyw.b(this.this$0, (ayyn)ayyl.a(this.dBz));
        ayyw.b(this.this$0).init();
        ayyw.b(this.this$0).onOutputSizeChanged(this.cFz, this.cFA);
      }
      if ((this.dBA == 90) || (this.dBA == 270))
      {
        ayyw.a(this.this$0).OJ(false);
        ayyw.b(this.this$0).OJ(false);
      }
      for (;;)
      {
        ayyw.a(this.this$0, this.zq);
        ayyw.a(this.this$0).d(true, this.zq + 0.1F);
        ayyw.b(this.this$0).d(false, this.zq - 0.1F);
        if (localayyn1 != null) {
          localayyn1.destroy();
        }
        if (localayyn2 != null) {
          localayyn2.destroy();
        }
        return;
        ayyw.a(this.this$0).OJ(true);
        ayyw.b(this.this$0).OJ(true);
      }
      localayyn1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */