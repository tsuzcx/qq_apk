package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class C2CMsgReadedNotify
  extends JceStruct
{
  public long lBindedUin;
  public long lFlag;
  public long lLastReadTime;
  public long lLastReadTime_qms;
  public long lPeerUin;
  public String strPhoneNum = "";
  public long uAioType;
  public long uint64_to_tiny_id;
  
  public C2CMsgReadedNotify() {}
  
  public C2CMsgReadedNotify(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    this.lPeerUin = paramLong1;
    this.lLastReadTime = paramLong2;
    this.lFlag = paramLong3;
    this.strPhoneNum = paramString;
    this.lBindedUin = paramLong4;
    this.lLastReadTime_qms = paramLong5;
    this.uAioType = paramLong6;
    this.uint64_to_tiny_id = paramLong7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lPeerUin = paramJceInputStream.read(this.lPeerUin, 0, false);
    this.lLastReadTime = paramJceInputStream.read(this.lLastReadTime, 1, false);
    this.lFlag = paramJceInputStream.read(this.lFlag, 2, false);
    this.strPhoneNum = paramJceInputStream.readString(3, false);
    this.lBindedUin = paramJceInputStream.read(this.lBindedUin, 4, false);
    this.lLastReadTime_qms = paramJceInputStream.read(this.lLastReadTime_qms, 5, false);
    this.uAioType = paramJceInputStream.read(this.uAioType, 6, false);
    this.uint64_to_tiny_id = paramJceInputStream.read(this.uint64_to_tiny_id, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lPeerUin, 0);
    paramJceOutputStream.write(this.lLastReadTime, 1);
    paramJceOutputStream.write(this.lFlag, 2);
    if (this.strPhoneNum != null) {
      paramJceOutputStream.write(this.strPhoneNum, 3);
    }
    paramJceOutputStream.write(this.lBindedUin, 4);
    paramJceOutputStream.write(this.lLastReadTime_qms, 5);
    paramJceOutputStream.write(this.uAioType, 6);
    paramJceOutputStream.write(this.uint64_to_tiny_id, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     PushNotifyPack.C2CMsgReadedNotify
 * JD-Core Version:    0.7.0.1
 */