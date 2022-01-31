package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DCacheUserDayInfo
  extends JceStruct
{
  static DCacheUserData cache_stUserData;
  static byte[] cache_strNodeList;
  public DCacheUserData stUserData = null;
  public byte[] strNodeList = null;
  
  public DCacheUserDayInfo() {}
  
  public DCacheUserDayInfo(DCacheUserData paramDCacheUserData, byte[] paramArrayOfByte)
  {
    this.stUserData = paramDCacheUserData;
    this.strNodeList = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stUserData == null) {
      cache_stUserData = new DCacheUserData();
    }
    this.stUserData = ((DCacheUserData)paramJceInputStream.read(cache_stUserData, 0, true));
    if (cache_strNodeList == null)
    {
      cache_strNodeList = (byte[])new byte[1];
      ((byte[])cache_strNodeList)[0] = 0;
    }
    this.strNodeList = ((byte[])paramJceInputStream.read(cache_strNodeList, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUserData, 0);
    paramJceOutputStream.write(this.strNodeList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.DCacheUserDayInfo
 * JD-Core Version:    0.7.0.1
 */