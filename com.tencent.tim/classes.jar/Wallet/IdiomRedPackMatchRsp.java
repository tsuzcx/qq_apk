package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IdiomRedPackMatchRsp
  extends JceStruct
{
  static int cache_subchannel = 0;
  public String billno = "";
  public int fromType;
  public long grabUin;
  public String groupid = "";
  public String hbIdiom = "";
  public String hbIdiomLastPY = "";
  public int idiomSeq;
  public int isFinished;
  public long makeUin;
  public int status;
  public String strErr = "";
  public int subchannel;
  public int timeInterval;
  
  public IdiomRedPackMatchRsp() {}
  
  public IdiomRedPackMatchRsp(long paramLong1, String paramString1, long paramLong2, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, String paramString4, int paramInt5, String paramString5, int paramInt6)
  {
    this.grabUin = paramLong1;
    this.billno = paramString1;
    this.makeUin = paramLong2;
    this.status = paramInt1;
    this.timeInterval = paramInt2;
    this.strErr = paramString2;
    this.hbIdiom = paramString3;
    this.idiomSeq = paramInt3;
    this.fromType = paramInt4;
    this.groupid = paramString4;
    this.isFinished = paramInt5;
    this.hbIdiomLastPY = paramString5;
    this.subchannel = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.grabUin = paramJceInputStream.read(this.grabUin, 0, false);
    this.billno = paramJceInputStream.readString(1, false);
    this.makeUin = paramJceInputStream.read(this.makeUin, 2, false);
    this.status = paramJceInputStream.read(this.status, 3, false);
    this.timeInterval = paramJceInputStream.read(this.timeInterval, 4, false);
    this.strErr = paramJceInputStream.readString(5, false);
    this.hbIdiom = paramJceInputStream.readString(6, false);
    this.idiomSeq = paramJceInputStream.read(this.idiomSeq, 7, false);
    this.fromType = paramJceInputStream.read(this.fromType, 8, false);
    this.groupid = paramJceInputStream.readString(9, false);
    this.isFinished = paramJceInputStream.read(this.isFinished, 10, false);
    this.hbIdiomLastPY = paramJceInputStream.readString(11, false);
    this.subchannel = paramJceInputStream.read(this.subchannel, 12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.grabUin, 0);
    if (this.billno != null) {
      paramJceOutputStream.write(this.billno, 1);
    }
    paramJceOutputStream.write(this.makeUin, 2);
    paramJceOutputStream.write(this.status, 3);
    paramJceOutputStream.write(this.timeInterval, 4);
    if (this.strErr != null) {
      paramJceOutputStream.write(this.strErr, 5);
    }
    if (this.hbIdiom != null) {
      paramJceOutputStream.write(this.hbIdiom, 6);
    }
    paramJceOutputStream.write(this.idiomSeq, 7);
    paramJceOutputStream.write(this.fromType, 8);
    if (this.groupid != null) {
      paramJceOutputStream.write(this.groupid, 9);
    }
    paramJceOutputStream.write(this.isFinished, 10);
    if (this.hbIdiomLastPY != null) {
      paramJceOutputStream.write(this.hbIdiomLastPY, 11);
    }
    paramJceOutputStream.write(this.subchannel, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.IdiomRedPackMatchRsp
 * JD-Core Version:    0.7.0.1
 */