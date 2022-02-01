package wf7;

import com.qq.taf.jce.JceStruct;

class eo$c
{
  public long bY;
  public int cc;
  public int gV;
  public long nG = System.currentTimeMillis();
  public int nL;
  public byte[] oM;
  public byte[] oN;
  public dr oO;
  public int oP;
  public int oQ;
  public dz oR;
  public long oS = -1L;
  public long oT = 0L;
  public int ob;
  public long oe;
  public JceStruct of;
  public JceStruct og;
  public int oh;
  public dq oi;
  
  eo$c(eo parameo, int paramInt1, int paramInt2, long paramLong, int paramInt3, JceStruct paramJceStruct1, byte[] paramArrayOfByte, JceStruct paramJceStruct2, int paramInt4, dq paramdq, dr paramdr)
  {
    this.nL = paramInt1;
    this.ob = paramInt2;
    this.oe = paramLong;
    this.gV = paramInt3;
    this.of = paramJceStruct1;
    this.oM = paramArrayOfByte;
    this.og = paramJceStruct2;
    this.oh = paramInt4;
    this.oi = paramdq;
    this.oO = paramdr;
    this.oR = new dz();
  }
  
  public boolean cW()
  {
    long l2 = Math.abs(System.currentTimeMillis() - this.nG);
    long l1;
    if (this.oS > 0L)
    {
      l1 = this.oS;
      if (l2 < l1) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {}
      return bool;
      l1 = 180000L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.eo.c
 * JD-Core Version:    0.7.0.1
 */