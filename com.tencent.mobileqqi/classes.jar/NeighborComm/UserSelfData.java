package NeighborComm;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserSelfData
  extends JceStruct
{
  static byte[] cache_strCookie;
  public int iLat = 900000000;
  public int iLon = 900000000;
  public long lNextGrid = 0L;
  public long lNextMid = 0L;
  public long lOriginGrid = 0L;
  public int lTime = 0;
  public byte[] strCookie = null;
  public String strProvince = "";
  
  public UserSelfData() {}
  
  public UserSelfData(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, String paramString, byte[] paramArrayOfByte)
  {
    this.lTime = paramInt1;
    this.iLat = paramInt2;
    this.iLon = paramInt3;
    this.lOriginGrid = paramLong1;
    this.lNextGrid = paramLong2;
    this.lNextMid = paramLong3;
    this.strProvince = paramString;
    this.strCookie = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lTime = paramJceInputStream.read(this.lTime, 0, true);
    this.iLat = paramJceInputStream.read(this.iLat, 1, true);
    this.iLon = paramJceInputStream.read(this.iLon, 2, true);
    this.lOriginGrid = paramJceInputStream.read(this.lOriginGrid, 3, false);
    this.lNextGrid = paramJceInputStream.read(this.lNextGrid, 4, false);
    this.lNextMid = paramJceInputStream.read(this.lNextMid, 5, false);
    this.strProvince = paramJceInputStream.readString(6, false);
    if (cache_strCookie == null)
    {
      cache_strCookie = (byte[])new byte[1];
      ((byte[])cache_strCookie)[0] = 0;
    }
    this.strCookie = ((byte[])paramJceInputStream.read(cache_strCookie, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lTime, 0);
    paramJceOutputStream.write(this.iLat, 1);
    paramJceOutputStream.write(this.iLon, 2);
    paramJceOutputStream.write(this.lOriginGrid, 3);
    paramJceOutputStream.write(this.lNextGrid, 4);
    paramJceOutputStream.write(this.lNextMid, 5);
    if (this.strProvince != null) {
      paramJceOutputStream.write(this.strProvince, 6);
    }
    if (this.strCookie != null) {
      paramJceOutputStream.write(this.strCookie, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborComm.UserSelfData
 * JD-Core Version:    0.7.0.1
 */