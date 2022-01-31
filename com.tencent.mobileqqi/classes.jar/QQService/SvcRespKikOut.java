package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRespKikOut
  extends JceStruct
{
  public long appid = 0L;
  public long lUin = 0L;
  public byte result = 0;
  
  public SvcRespKikOut() {}
  
  public SvcRespKikOut(long paramLong1, long paramLong2, byte paramByte)
  {
    this.lUin = paramLong1;
    this.appid = paramLong2;
    this.result = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.appid = paramJceInputStream.read(this.appid, 1, true);
    this.result = paramJceInputStream.read(this.result, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.result, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcRespKikOut
 * JD-Core Version:    0.7.0.1
 */