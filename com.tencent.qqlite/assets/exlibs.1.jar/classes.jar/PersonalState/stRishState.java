package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stRishState
  extends JceStruct
{
  static byte[] cache_vState;
  public long uModifyTime = 0L;
  public byte[] vState = null;
  
  public stRishState() {}
  
  public stRishState(byte[] paramArrayOfByte, long paramLong)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     PersonalState.stRishState
 * JD-Core Version:    0.7.0.1
 */