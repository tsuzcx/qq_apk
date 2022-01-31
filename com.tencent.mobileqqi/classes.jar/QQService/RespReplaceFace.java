package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespReplaceFace
  extends JceStruct
{
  static RespHead cache_stHeader;
  public RespHead stHeader = null;
  public int uFaceTimeStamp = 0;
  
  public RespReplaceFace() {}
  
  public RespReplaceFace(RespHead paramRespHead, int paramInt)
  {
    this.stHeader = paramRespHead;
    this.uFaceTimeStamp = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.uFaceTimeStamp = paramJceInputStream.read(this.uFaceTimeStamp, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.uFaceTimeStamp, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespReplaceFace
 * JD-Core Version:    0.7.0.1
 */