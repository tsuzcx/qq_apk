package btmsdkobf;

import android.os.Process;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;

public class dd
  implements dc
{
  private static boolean gU = false;
  private db lU;
  private da lV;
  protected long t;
  
  public dd(long paramLong)
  {
    this.t = paramLong;
  }
  
  private da ce()
  {
    if ((cx.bD()) && (!cx.iS)) {
      throw new RuntimeException("getSharkProcessProxy too early");
    }
    try
    {
      if (this.lV == null) {
        this.lV = da.bW();
      }
      return this.lV;
    }
    finally {}
  }
  
  private db cf()
  {
    if ((cx.bD()) && (!cx.iS)) {
      throw new RuntimeException("getSharkProtocolQueue too early");
    }
    try
    {
      if (this.lU == null) {
        this.lU = db.bZ();
      }
      return this.lU;
    }
    finally {}
  }
  
  public WeakReference<cw> a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, JceStruct paramJceStruct1, byte[] paramArrayOfByte, JceStruct paramJceStruct2, int paramInt5, cj paramcj, ck paramck, long paramLong3, long paramLong4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append(" sendShark() from pid: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ipcSeqNo: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" callerIdent: ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" cmdId: ");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(" flag: ");
    localStringBuilder.append(paramInt5);
    localStringBuilder.append(" callBackTimeout: ");
    localStringBuilder.append(paramLong3);
    eh.e("SharkProcessProxy", localStringBuilder.toString());
    if (cx.ax()) {
      return cf().a(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramInt4, paramJceStruct1, paramArrayOfByte, paramJceStruct2, paramInt5, paramcj, paramck, paramLong3, paramLong4);
    }
    if ((cx.ay()) && ((!cx.az()) || ((paramInt5 & 0x1000) != 0)))
    {
      if (((paramInt5 & 0x800) == 0) && ((paramInt5 & 0x200) == 0)) {
        throw new IllegalArgumentException("semi-send process can only use http channel!");
      }
      return cf().a(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramInt4, paramJceStruct1, paramArrayOfByte, paramJceStruct2, paramInt5, paramcj, paramck, paramLong3, paramLong4);
    }
    ce().a(paramInt1, this.t, paramInt3, paramLong1, paramInt4, paramJceStruct1, paramJceStruct2, paramInt5, paramcj, paramLong3, paramLong4);
    return null;
  }
  
  public WeakReference<cw> a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, cj paramcj)
  {
    return b(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramcj, 0L);
  }
  
  public WeakReference<cw> a(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, cj paramcj, long paramLong1, long paramLong2)
  {
    return a(Process.myPid(), 0, 0, 0L, this.t, paramInt1, paramJceStruct1, null, paramJceStruct2, paramInt2, paramcj, null, paramLong1, paramLong2);
  }
  
  public void a(int paramInt1, JceStruct paramJceStruct, int paramInt2, cm paramcm)
  {
    a(0L, paramInt1, paramJceStruct, paramInt2, paramcm, false);
  }
  
  public void a(long paramLong, int paramInt1, JceStruct paramJceStruct, int paramInt2, cm paramcm, boolean paramBoolean)
  {
    if (cx.ax())
    {
      localStringBuilder = new StringBuilder("sending process registerSharkPush() from cmdId: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" flag: ");
      localStringBuilder.append(paramInt2);
      eh.e("SharkProcessProxy", localStringBuilder.toString());
      if (!paramBoolean) {
        paramLong = this.t;
      }
      cf().a(paramLong, paramInt1, paramJceStruct, paramInt2, paramcm, paramBoolean);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("other process registerSharkPush() from cmdId: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" flag: ");
    localStringBuilder.append(paramInt2);
    eh.e("SharkProcessProxy", localStringBuilder.toString());
    ce().a(this.t, paramInt1, paramJceStruct, paramInt2, paramcm);
  }
  
  public void av()
  {
    if (cx.ax()) {
      cf().av();
    }
  }
  
  public WeakReference<cw> b(int paramInt1, JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt2, cj paramcj, long paramLong)
  {
    return a(paramInt1, paramJceStruct1, paramJceStruct2, paramInt2, paramcj, paramLong, 0L);
  }
  
  public void bM()
  {
    if (cx.ax()) {
      cf().bM();
    }
  }
  
  public cm e(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append(" unregisterSharkPush() from cmdId: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" flag: ");
    localStringBuilder.append(paramInt2);
    eh.e("SharkProcessProxy", localStringBuilder.toString());
    if (cx.ax()) {
      return cf().e(paramInt1, paramInt2);
    }
    return ce().e(paramInt1, paramInt2);
  }
  
  public String getGuid()
  {
    return cf().getGuid();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dd
 * JD-Core Version:    0.7.0.1
 */