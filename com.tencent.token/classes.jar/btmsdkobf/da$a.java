package btmsdkobf;

import com.qq.taf.jce.JceStruct;

public class da$a
{
  public int kC;
  public int kD;
  public long kE;
  public int kF;
  public long kG;
  public JceStruct kH;
  public JceStruct kI;
  public int kJ;
  public cj kK;
  public long kL = -1L;
  public long kM = -1L;
  public long kN = System.currentTimeMillis();
  public int km;
  
  da$a(da paramda, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt5, cj paramcj, long paramLong3, long paramLong4)
  {
    this.km = paramInt1;
    this.kC = paramInt2;
    this.kD = paramInt3;
    this.kE = paramLong1;
    this.kF = paramInt4;
    this.kG = paramLong2;
    this.kH = paramJceStruct1;
    this.kI = paramJceStruct2;
    this.kJ = paramInt5;
    this.kK = paramcj;
    this.kL = paramLong3;
    this.kM = paramLong4;
  }
  
  public boolean bP()
  {
    long l2 = Math.abs(System.currentTimeMillis() - this.kN);
    long l1;
    if (this.kL > 0L)
    {
      l1 = this.kL;
      if (l2 < l1) {
        break label193;
      }
    }
    label193:
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cmdId|").append(this.kF);
        localStringBuilder.append("|mIpcSeqNo|").append(this.kC);
        localStringBuilder.append("|mPushSeqNo|").append(this.kD);
        localStringBuilder.append("|mPushId|").append(this.kE);
        localStringBuilder.append("|mCallerIdent|").append(this.kG);
        localStringBuilder.append("|mTimeout|").append(this.kL);
        localStringBuilder.append("|time(s)|").append(l2 / 1000L);
        eh.h("ocean", "[ocean][time_out]SharkProcessProxy.SharkProxyTask.isTimeOut(), " + localStringBuilder.toString());
      }
      return bool;
      l1 = 35000L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.da.a
 * JD-Core Version:    0.7.0.1
 */