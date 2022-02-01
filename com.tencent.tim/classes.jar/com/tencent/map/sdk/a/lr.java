package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.model.MaskLayer;
import com.tencent.tencentmap.mapsdk.maps.model.MaskLayerOptions;

public final class lr
  implements kz
{
  public pn a;
  public kr b;
  private MaskLayerOptions c;
  private mt d;
  private ko e;
  
  private void e()
  {
    if (this.b.a()) {
      this.b.a(true);
    }
    this.b.b(true);
  }
  
  public final MaskLayerOptions a()
  {
    return this.c;
  }
  
  public final void a(long paramLong)
  {
    if (this.d != null)
    {
      this.d.a(paramLong);
      e();
    }
  }
  
  public final void a(MaskLayerOptions paramMaskLayerOptions)
  {
    this.c = paramMaskLayerOptions;
    b();
    ko localko = this.e;
    if (this.d != null) {
      this.d.a(0L);
    }
    if ((this.a != null) && (paramMaskLayerOptions != null))
    {
      this.c = paramMaskLayerOptions;
      this.e = localko;
      this.d = new mt(this.a, paramMaskLayerOptions);
      if (!this.d.a())
      {
        this.d.b();
        this.d = null;
      }
    }
    else
    {
      return;
    }
    if ((paramMaskLayerOptions == null) || (this.b == null)) {}
    for (;;)
    {
      new MaskLayer(paramMaskLayerOptions, localko);
      return;
      if ((paramMaskLayerOptions.getColor() >> 24 & 0xFF) >= 51)
      {
        if (this.b.a()) {
          this.b.a(false);
        }
        this.b.b(false);
      }
      else
      {
        if (this.b.a()) {
          this.b.a(true);
        }
        this.b.b(true);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    mt localmt;
    if (this.d != null)
    {
      localmt = this.d;
      localmt.a = paramBoolean;
      if (paramBoolean) {
        localmt.a();
      }
    }
    else
    {
      return;
    }
    localmt.c();
  }
  
  public final void b()
  {
    if (this.d != null)
    {
      this.d.a(0L);
      e();
    }
  }
  
  public final int c()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.getZIndex();
  }
  
  public final boolean d()
  {
    if (this.d == null) {
      return false;
    }
    return this.d.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.lr
 * JD-Core Version:    0.7.0.1
 */