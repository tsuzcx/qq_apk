package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RishState
  extends JceStruct
{
  static byte[] cache_vState;
  public long uModifyTime = 0L;
  public byte[] vState = null;
  
  public RishState() {}
  
  public RishState(byte[] paramArrayOfByte, long paramLong)
  {
    this.vState = paramArrayOfByte;
    this.uModifyTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vState == null)
    {
      cache_vState = (byte[])new byte[1];
      ((byte[])cache_vState)[0] = 0;
    }
    this.vState = ((byte[])paramJceInputStream.read(cache_vState, 0, true));
    this.uModifyTime = paramJceInputStream.read(this.uModifyTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vState, 0);
    paramJceOutputStream.write(this.uModifyTime, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     EncounterSvc.RishState
 * JD-Core Version:    0.7.0.1
 */