package wf7;

import com.qq.taf.jce.JceStruct;

public class en$a
{
  public int gV;
  public int nL;
  public int ob;
  public int oc;
  public long od;
  public long oe;
  public JceStruct of;
  public JceStruct og;
  public int oh;
  public dq oi;
  public long oj = -1L;
  public long ok = -1L;
  public long ol = System.currentTimeMillis();
  
  en$a(en paramen, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt5, dq paramdq, long paramLong3, long paramLong4)
  {
    this.nL = paramInt1;
    this.ob = paramInt2;
    this.oc = paramInt3;
    this.od = paramLong1;
    this.gV = paramInt4;
    this.oe = paramLong2;
    this.of = paramJceStruct1;
    this.og = paramJceStruct2;
    this.oh = paramInt5;
    this.oi = paramdq;
    this.oj = paramLong3;
    this.ok = paramLong4;
  }
  
  public boolean cW()
  {
    long l2 = Math.abs(System.currentTimeMillis() - this.ol);
    long l1 = this.oj;
    if (l1 <= 0L) {
      l1 = 185000L;
    }
    return l2 >= l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.en.a
 * JD-Core Version:    0.7.0.1
 */