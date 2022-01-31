package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespItem
  extends JceStruct
{
  static int cache_eServiceID;
  static byte[] cache_vecUpdate;
  public byte cResult = 0;
  public int eServiceID = 0;
  public byte[] vecUpdate = null;
  
  public RespItem() {}
  
  public RespItem(byte paramByte, int paramInt, byte[] paramArrayOfByte)
  {
    this.cResult = paramByte;
    this.eServiceID = paramInt;
    this.vecUpdate = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cResult = paramJceInputStream.read(this.cResult, 0, true);
    this.eServiceID = paramJceInputStream.read(this.eServiceID, 1, true);
    if (cache_vecUpdate == null)
    {
      cache_vecUpdate = (byte[])new byte[1];
      ((byte[])cache_vecUpdate)[0] = 0;
    }
    this.vecUpdate = ((byte[])paramJceInputStream.read(cache_vecUpdate, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cResult, 0);
    paramJceOutputStream.write(this.eServiceID, 1);
    if (this.vecUpdate != null) {
      paramJceOutputStream.write(this.vecUpdate, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     KQQ.RespItem
 * JD-Core Version:    0.7.0.1
 */