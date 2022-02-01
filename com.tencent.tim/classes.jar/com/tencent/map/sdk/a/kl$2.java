package com.tencent.map.sdk.a;

public final class kl$2
  extends nv
{
  public kl$2(kl paramkl, double[] paramArrayOfDouble, long paramLong, float paramFloat1, float paramFloat2, double paramDouble1, double paramDouble2)
  {
    super(102, paramArrayOfDouble, false);
  }
  
  public final boolean b()
  {
    long l = System.currentTimeMillis() - this.a;
    double d1 = ns.a(l, this.b);
    double d2 = ns.a(l, this.c);
    double[] arrayOfDouble = this.j;
    arrayOfDouble[2] += Math.abs(d1);
    arrayOfDouble = this.j;
    arrayOfDouble[3] += Math.abs(d2);
    int i;
    int j;
    if (this.j[2] >= Math.abs(this.d))
    {
      i = 1;
      if (this.j[3] < Math.abs(this.e)) {
        break label174;
      }
      j = 1;
      label108:
      if (i == 0) {
        break label180;
      }
      this.j[0] = (this.f - this.h.h());
      label132:
      if (j == 0) {
        break label190;
      }
      this.j[1] = (this.g - this.h.i());
    }
    for (;;)
    {
      if ((i == 0) || (j == 0)) {
        break label200;
      }
      return true;
      i = 0;
      break;
      label174:
      j = 0;
      break label108;
      label180:
      this.j[0] = d1;
      break label132;
      label190:
      this.j[1] = d2;
    }
    label200:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.kl.2
 * JD-Core Version:    0.7.0.1
 */