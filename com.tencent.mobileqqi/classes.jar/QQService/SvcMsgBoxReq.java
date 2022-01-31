package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcMsgBoxReq
  extends JceStruct
{
  public byte cConnType = 0;
  public int iStatus = 11;
  public long lUin = 0L;
  
  public SvcMsgBoxReq() {}
  
  public SvcMsgBoxReq(long paramLong, byte paramByte, int paramInt)
  {
    this.lUin = paramLong;
    this.cConnType = paramByte;
    this.iStatus = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cConnType = paramJceInputStream.read(this.cConnType, 1, true);
    this.iStatus = paramJceInputStream.read(this.iStatus, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cConnType, 1);
    paramJceOutputStream.write(this.iStatus, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcMsgBoxReq
 * JD-Core Version:    0.7.0.1
 */