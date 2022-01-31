package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class InfoItem
  extends JceStruct
{
  static byte[] cache_vecValue;
  public byte cOperType = 0;
  public byte cResult = 0;
  public long qwServiceId = 0L;
  public long qwTimeStamp = 0L;
  public byte[] vecValue = null;
  
  public InfoItem() {}
  
  public InfoItem(byte paramByte1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, byte paramByte2)
  {
    this.cOperType = paramByte1;
    this.qwServiceId = paramLong1;
    this.qwTimeStamp = paramLong2;
    this.vecValue = paramArrayOfByte;
    this.cResult = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cOperType = paramJceInputStream.read(this.cOperType, 0, true);
    this.qwServiceId = paramJceInputStream.read(this.qwServiceId, 1, true);
    this.qwTimeStamp = paramJceInputStream.read(this.qwTimeStamp, 2, true);
    if (cache_vecValue == null)
    {
      cache_vecValue = (byte[])new byte[1];
      ((byte[])cache_vecValue)[0] = 0;
    }
    this.vecValue = ((byte[])paramJceInputStream.read(cache_vecValue, 3, false));
    this.cResult = paramJceInputStream.read(this.cResult, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cOperType, 0);
    paramJceOutputStream.write(this.qwServiceId, 1);
    paramJceOutputStream.write(this.qwTimeStamp, 2);
    if (this.vecValue != null) {
      paramJceOutputStream.write(this.vecValue, 3);
    }
    paramJceOutputStream.write(this.cResult, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.InfoItem
 * JD-Core Version:    0.7.0.1
 */