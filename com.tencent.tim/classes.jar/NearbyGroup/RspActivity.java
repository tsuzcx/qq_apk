package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RspActivity
  extends JceStruct
{
  static byte[] cache_strRspAct;
  public short shShowPos = 2;
  public byte[] strRspAct;
  
  public RspActivity() {}
  
  public RspActivity(short paramShort, byte[] paramArrayOfByte)
  {
    this.shShowPos = paramShort;
    this.strRspAct = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shShowPos = paramJceInputStream.read(this.shShowPos, 0, true);
    if (cache_strRspAct == null)
    {
      cache_strRspAct = (byte[])new byte[1];
      ((byte[])cache_strRspAct)[0] = 0;
    }
    this.strRspAct = ((byte[])paramJceInputStream.read(cache_strRspAct, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shShowPos, 0);
    paramJceOutputStream.write(this.strRspAct, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NearbyGroup.RspActivity
 * JD-Core Version:    0.7.0.1
 */