package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import ayyl;
import ayyn;
import ayyw;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(ayyw paramayyw, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    ayyn localayyn1 = null;
    ayyn localayyn2 = ayyw.a(this.this$0);
    ayyw.a(this.this$0, null);
    if ((ayyw.b(this.this$0) == null) || (ayyw.b(this.this$0).getFilterType() != this.dBx))
    {
      localayyn1 = ayyw.b(this.this$0);
      ayyw.b(this.this$0, (ayyn)ayyl.a(this.dBx));
      ayyw.b(this.this$0).init();
      ayyw.b(this.this$0).onOutputSizeChanged(this.cFz, this.cFA);
    }
    ayyw.b(this.this$0).d(false, 0.0F);
    ayyw.a(this.this$0, 0.0F);
    if (localayyn2 != null) {
      localayyn2.destroy();
    }
    if (localayyn1 != null) {
      localayyn1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */