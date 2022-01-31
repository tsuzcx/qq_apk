package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcReqGetUserInfo
  extends JceStruct
{
  public long lUin = 0L;
  
  public SvcReqGetUserInfo() {}
  
  public SvcReqGetUserInfo(long paramLong)
  {
    this.lUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcReqGetUserInfo
 * JD-Core Version:    0.7.0.1
 */