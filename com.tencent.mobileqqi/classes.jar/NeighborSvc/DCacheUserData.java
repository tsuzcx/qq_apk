package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DCacheUserData
  extends JceStruct
{
  static int cache_eBusiType;
  public int eBusiType = BusinessType.BusinessType_MQQ.value();
  public long uEvilFlagCacheTime = 0L;
  public long uUserState = 3L;
  
  public DCacheUserData() {}
  
  public DCacheUserData(long paramLong1, int paramInt, long paramLong2)
  {
    this.uUserState = paramLong1;
    this.eBusiType = paramInt;
    this.uEvilFlagCacheTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uUserState = paramJceInputStream.read(this.uUserState, 0, true);
    this.eBusiType = paramJceInputStream.read(this.eBusiType, 1, false);
    this.uEvilFlagCacheTime = paramJceInputStream.read(this.uEvilFlagCacheTime, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uUserState, 0);
    paramJceOutputStream.write(this.eBusiType, 1);
    paramJceOutputStream.write(this.uEvilFlagCacheTime, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NeighborSvc.DCacheUserData
 * JD-Core Version:    0.7.0.1
 */