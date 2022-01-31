package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespVote
  extends JceStruct
{
  static RespHead cache_stHeader;
  public long lMID = 0L;
  public RespHead stHeader = null;
  
  public RespVote() {}
  
  public RespVote(RespHead paramRespHead, long paramLong)
  {
    this.stHeader = paramRespHead;
    this.lMID = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lMID = paramJceInputStream.read(this.lMID, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lMID, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.RespVote
 * JD-Core Version:    0.7.0.1
 */