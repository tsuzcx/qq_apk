package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;

public final class Haw
  extends break
{
  public long Rc = 0L;
  public float x = 0.0F;
  public float y = 0.0F;
  public float z = 0.0F;
  
  public final void a(afk paramafk)
  {
    this.Rc = paramafk.a(this.Rc, 0, true);
    this.x = paramafk.a(this.x, 1, true);
    this.y = paramafk.a(this.y, 2, true);
    this.z = paramafk.a(this.z, 3, true);
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.Rc, 0);
    paramafn.a(this.x, 1);
    paramafn.a(this.y, 2);
    paramafn.a(this.z, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Haw
 * JD-Core Version:    0.7.0.1
 */