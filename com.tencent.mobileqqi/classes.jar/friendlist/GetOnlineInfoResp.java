package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetOnlineInfoResp
  extends JceStruct
{
  static int cache_eIconType;
  static int cache_eNetworkType;
  static int cache_result;
  public long dwInterval = 0L;
  public long dwStatus = 20L;
  public int eIconType = 0;
  public int eNetworkType = 0;
  public short errorCode = 0;
  public long iTermType = 0L;
  public int result = 0;
  public long uAbiFlag = 0L;
  
  public GetOnlineInfoResp() {}
  
  public GetOnlineInfoResp(int paramInt1, short paramShort, long paramLong1, long paramLong2, long paramLong3, int paramInt2, int paramInt3, long paramLong4)
  {
    this.result = paramInt1;
    this.errorCode = paramShort;
    this.dwStatus = paramLong1;
    this.iTermType = paramLong2;
    this.uAbiFlag = paramLong3;
    this.eNetworkType = paramInt2;
    this.eIconType = paramInt3;
    this.dwInterval = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 1, true);
    this.dwStatus = paramJceInputStream.read(this.dwStatus, 2, false);
    this.iTermType = paramJceInputStream.read(this.iTermType, 3, false);
    this.uAbiFlag = paramJceInputStream.read(this.uAbiFlag, 4, false);
    this.eNetworkType = paramJceInputStream.read(this.eNetworkType, 5, false);
    this.eIconType = paramJceInputStream.read(this.eIconType, 6, false);
    this.dwInterval = paramJceInputStream.read(this.dwInterval, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.errorCode, 1);
    paramJceOutputStream.write(this.dwStatus, 2);
    paramJceOutputStream.write(this.iTermType, 3);
    paramJceOutputStream.write(this.uAbiFlag, 4);
    paramJceOutputStream.write(this.eNetworkType, 5);
    paramJceOutputStream.write(this.eIconType, 6);
    paramJceOutputStream.write(this.dwInterval, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.GetOnlineInfoResp
 * JD-Core Version:    0.7.0.1
 */