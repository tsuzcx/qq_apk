package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespSetBusiInfo
  extends JceStruct
{
  static RespHead cache_stHeader;
  public RespHead stHeader = null;
  
  public RespSetBusiInfo() {}
  
  public RespSetBusiInfo(RespHead paramRespHead)
  {
    this.stHeader = paramRespHead;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespSetBusiInfo
 * JD-Core Version:    0.7.0.1
 */