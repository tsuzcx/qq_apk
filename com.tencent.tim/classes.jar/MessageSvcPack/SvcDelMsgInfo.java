package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcDelMsgInfo
  extends JceStruct
{
  public long lFromUin;
  public long lMsgUid;
  public short shMsgSeq;
  public int shMsgType;
  public int uMsgTime;
  
  public SvcDelMsgInfo() {}
  
  public SvcDelMsgInfo(long paramLong1, int paramInt1, short paramShort, long paramLong2, int paramInt2)
  {
    this.lFromUin = paramLong1;
    this.uMsgTime = paramInt1;
    this.shMsgSeq = paramShort;
    this.lMsgUid = paramLong2;
    this.shMsgType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUin = paramJceInputStream.read(this.lFromUin, 0, true);
    this.uMsgTime = paramJceInputStream.read(this.uMsgTime, 1, true);
    this.shMsgSeq = paramJceInputStream.read(this.shMsgSeq, 2, true);
    this.lMsgUid = paramJceInputStream.read(this.lMsgUid, 3, false);
    this.shMsgType = paramJceInputStream.read(this.shMsgType, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUin, 0);
    paramJceOutputStream.write(this.uMsgTime, 1);
    paramJceOutputStream.write(this.shMsgSeq, 2);
    paramJceOutputStream.write(this.lMsgUid, 3);
    paramJceOutputStream.write(this.shMsgType, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcDelMsgInfo
 * JD-Core Version:    0.7.0.1
 */