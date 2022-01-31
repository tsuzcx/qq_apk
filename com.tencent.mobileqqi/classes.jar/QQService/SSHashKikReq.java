package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SSHashKikReq
  extends JceStruct
{
  public int appid = 0;
  public long uin = 0L;
  
  public SSHashKikReq() {}
  
  public SSHashKikReq(long paramLong, int paramInt)
  {
    this.uin = paramLong;
    this.appid = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.appid = paramJceInputStream.read(this.appid, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.appid, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SSHashKikReq
 * JD-Core Version:    0.7.0.1
 */