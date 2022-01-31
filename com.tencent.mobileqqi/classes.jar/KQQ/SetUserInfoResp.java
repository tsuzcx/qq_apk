package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetUserInfoResp
  extends JceStruct
{
  public long dwToUin = 0L;
  public byte result = 0;
  
  public SetUserInfoResp() {}
  
  public SetUserInfoResp(long paramLong, byte paramByte)
  {
    this.dwToUin = paramLong;
    this.result = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwToUin = paramJceInputStream.read(this.dwToUin, 0, true);
    this.result = paramJceInputStream.read(this.result, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwToUin, 0);
    paramJceOutputStream.write(this.result, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     KQQ.SetUserInfoResp
 * JD-Core Version:    0.7.0.1
 */