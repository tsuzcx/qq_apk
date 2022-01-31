package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqUnsetBusiInfo
  extends JceStruct
{
  static ReqHead cache_stHeader;
  public long lUIN = 0L;
  public ReqHead stHeader = null;
  
  public ReqUnsetBusiInfo() {}
  
  public ReqUnsetBusiInfo(ReqHead paramReqHead, long paramLong)
  {
    this.stHeader = paramReqHead;
    this.lUIN = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lUIN = paramJceInputStream.read(this.lUIN, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lUIN, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqUnsetBusiInfo
 * JD-Core Version:    0.7.0.1
 */