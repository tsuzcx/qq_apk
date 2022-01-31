package btmsdkobf;

import com.qq.taf.jce.JceStruct;

class hh
{
  public int a;
  public int b;
  public long c;
  public int d;
  public JceStruct e;
  public byte[] f;
  public JceStruct g;
  public byte[] h;
  public int i;
  public cj j;
  public ck k;
  public int l;
  public int m;
  public int n;
  public cw o;
  public long p = -1L;
  public long q = 0L;
  public long r;
  public long s = System.currentTimeMillis();
  
  hh(db paramdb, int paramInt1, int paramInt2, long paramLong, int paramInt3, JceStruct paramJceStruct1, byte[] paramArrayOfByte, JceStruct paramJceStruct2, int paramInt4, cj paramcj, ck paramck)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramLong;
    this.d = paramInt3;
    this.e = paramJceStruct1;
    this.f = paramArrayOfByte;
    this.g = paramJceStruct2;
    this.i = paramInt4;
    this.j = paramcj;
    this.k = paramck;
    this.o = new cw();
  }
  
  public boolean a()
  {
    long l2 = Math.abs(System.currentTimeMillis() - this.s);
    long l1;
    if (this.p > 0L)
    {
      l1 = this.p;
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
        localStringBuilder.append("cmdId|").append(this.d);
        localStringBuilder.append("|mIpcSeqNo|").append(this.b);
        localStringBuilder.append("|mSeqNo|").append(this.l);
        localStringBuilder.append("|pushId|").append(this.r);
        localStringBuilder.append("|mCallerIdent|").append(this.c);
        localStringBuilder.append("|callBackTimeout|").append(this.p);
        localStringBuilder.append("|time(s)|").append(l2 / 1000L);
        eh.h("ocean", "[ocean][time_out]SharkProtocolQueue.SharkSendTask.isTimeOut(), " + localStringBuilder.toString());
      }
      return bool;
      l1 = 30000L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.hh
 * JD-Core Version:    0.7.0.1
 */