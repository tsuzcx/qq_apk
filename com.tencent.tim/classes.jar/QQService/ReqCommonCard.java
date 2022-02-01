package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqCommonCard
  extends JceStruct
{
  static ReqHead cache_stHeader;
  public ReqHead stHeader;
  public int uFaceTimeStamp = -1;
  
  public ReqCommonCard() {}
  
  public ReqCommonCard(ReqHead paramReqHead, int paramInt)
  {
    this.stHeader = paramReqHead;
    this.uFaceTimeStamp = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.uFaceTimeStamp = paramJceInputStream.read(this.uFaceTimeStamp, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.uFaceTimeStamp, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.ReqCommonCard
 * JD-Core Version:    0.7.0.1
 */