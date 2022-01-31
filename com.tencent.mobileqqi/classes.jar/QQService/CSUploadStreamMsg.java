package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CSUploadStreamMsg
  extends JceStruct
{
  static StreamData cache_stStreamData;
  static StreamInfo cache_stStreamInfo;
  public int iSeq = 0;
  public int shMsgSeq = 0;
  public short shVersion = 0;
  public StreamData stStreamData = null;
  public StreamInfo stStreamInfo = null;
  
  public CSUploadStreamMsg() {}
  
  public CSUploadStreamMsg(short paramShort, int paramInt1, StreamInfo paramStreamInfo, StreamData paramStreamData, int paramInt2)
  {
    this.shVersion = paramShort;
    this.iSeq = paramInt1;
    this.stStreamInfo = paramStreamInfo;
    this.stStreamData = paramStreamData;
    this.shMsgSeq = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    if (cache_stStreamInfo == null) {
      cache_stStreamInfo = new StreamInfo();
    }
    this.stStreamInfo = ((StreamInfo)paramJceInputStream.read(cache_stStreamInfo, 2, true));
    if (cache_stStreamData == null) {
      cache_stStreamData = new StreamData();
    }
    this.stStreamData = ((StreamData)paramJceInputStream.read(cache_stStreamData, 3, true));
    this.shMsgSeq = paramJceInputStream.read(this.shMsgSeq, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.stStreamInfo, 2);
    paramJceOutputStream.write(this.stStreamData, 3);
    paramJceOutputStream.write(this.shMsgSeq, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.CSUploadStreamMsg
 * JD-Core Version:    0.7.0.1
 */