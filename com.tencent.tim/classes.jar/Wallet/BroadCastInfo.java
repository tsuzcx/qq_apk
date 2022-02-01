package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BroadCastInfo
  extends JceStruct
{
  static int cache_subchannel = 0;
  public String billno = "";
  public String hbIdiom = "";
  public String hbIdiomLastPY = "";
  public int idiomSeq;
  public long idiomUin;
  public int isFinished;
  public int subchannel;
  
  public BroadCastInfo() {}
  
  public BroadCastInfo(String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3)
  {
    this.hbIdiom = paramString1;
    this.idiomSeq = paramInt1;
    this.billno = paramString2;
    this.idiomUin = paramLong;
    this.isFinished = paramInt2;
    this.hbIdiomLastPY = paramString3;
    this.subchannel = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hbIdiom = paramJceInputStream.readString(0, false);
    this.idiomSeq = paramJceInputStream.read(this.idiomSeq, 1, false);
    this.billno = paramJceInputStream.readString(2, false);
    this.idiomUin = paramJceInputStream.read(this.idiomUin, 3, false);
    this.isFinished = paramJceInputStream.read(this.isFinished, 4, false);
    this.hbIdiomLastPY = paramJceInputStream.readString(5, false);
    this.subchannel = paramJceInputStream.read(this.subchannel, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.hbIdiom != null) {
      paramJceOutputStream.write(this.hbIdiom, 0);
    }
    paramJceOutputStream.write(this.idiomSeq, 1);
    if (this.billno != null) {
      paramJceOutputStream.write(this.billno, 2);
    }
    paramJceOutputStream.write(this.idiomUin, 3);
    paramJceOutputStream.write(this.isFinished, 4);
    if (this.hbIdiomLastPY != null) {
      paramJceOutputStream.write(this.hbIdiomLastPY, 5);
    }
    paramJceOutputStream.write(this.subchannel, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.BroadCastInfo
 * JD-Core Version:    0.7.0.1
 */