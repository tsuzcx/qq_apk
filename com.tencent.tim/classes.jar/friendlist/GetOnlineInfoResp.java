package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetOnlineInfoResp
  extends JceStruct
{
  static int cache_eIconType;
  static int cache_eNetworkType;
  static int cache_result = 0;
  static byte[] cache_vecMusicInfo;
  static byte[] cache_vecPoiInfo;
  public long dwInterval = 30L;
  public long dwStatus = 20L;
  public long dwUin;
  public int eIconType = 0;
  public int eNetworkType = 0;
  public short errorCode;
  public int iBatteryStatus;
  public long iTermType;
  public int result;
  public String strCustomOnlineStatusDesc = "";
  public String strTermDesc = "";
  public long uAbiFlag;
  public long uExtOnlineStatus;
  public byte[] vecMusicInfo;
  public byte[] vecPoiInfo;
  
  static
  {
    cache_eNetworkType = 0;
    cache_eIconType = 0;
    cache_vecMusicInfo = (byte[])new byte[1];
    ((byte[])cache_vecMusicInfo)[0] = 0;
    cache_vecPoiInfo = (byte[])new byte[1];
    ((byte[])cache_vecPoiInfo)[0] = 0;
  }
  
  public GetOnlineInfoResp() {}
  
  public GetOnlineInfoResp(int paramInt1, short paramShort, long paramLong1, long paramLong2, long paramLong3, int paramInt2, int paramInt3, long paramLong4, long paramLong5, String paramString1, String paramString2, long paramLong6, int paramInt4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.result = paramInt1;
    this.errorCode = paramShort;
    this.dwStatus = paramLong1;
    this.iTermType = paramLong2;
    this.uAbiFlag = paramLong3;
    this.eNetworkType = paramInt2;
    this.eIconType = paramInt3;
    this.dwInterval = paramLong4;
    this.dwUin = paramLong5;
    this.strTermDesc = paramString1;
    this.strCustomOnlineStatusDesc = paramString2;
    this.uExtOnlineStatus = paramLong6;
    this.iBatteryStatus = paramInt4;
    this.vecMusicInfo = paramArrayOfByte1;
    this.vecPoiInfo = paramArrayOfByte2;
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
    this.dwUin = paramJceInputStream.read(this.dwUin, 8, false);
    this.strTermDesc = paramJceInputStream.readString(9, false);
    this.strCustomOnlineStatusDesc = paramJceInputStream.readString(10, false);
    this.uExtOnlineStatus = paramJceInputStream.read(this.uExtOnlineStatus, 11, false);
    this.iBatteryStatus = paramJceInputStream.read(this.iBatteryStatus, 12, false);
    this.vecMusicInfo = ((byte[])paramJceInputStream.read(cache_vecMusicInfo, 13, false));
    this.vecPoiInfo = ((byte[])paramJceInputStream.read(cache_vecPoiInfo, 14, false));
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
    paramJceOutputStream.write(this.dwUin, 8);
    if (this.strTermDesc != null) {
      paramJceOutputStream.write(this.strTermDesc, 9);
    }
    if (this.strCustomOnlineStatusDesc != null) {
      paramJceOutputStream.write(this.strCustomOnlineStatusDesc, 10);
    }
    paramJceOutputStream.write(this.uExtOnlineStatus, 11);
    paramJceOutputStream.write(this.iBatteryStatus, 12);
    if (this.vecMusicInfo != null) {
      paramJceOutputStream.write(this.vecMusicInfo, 13);
    }
    if (this.vecPoiInfo != null) {
      paramJceOutputStream.write(this.vecPoiInfo, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     friendlist.GetOnlineInfoResp
 * JD-Core Version:    0.7.0.1
 */