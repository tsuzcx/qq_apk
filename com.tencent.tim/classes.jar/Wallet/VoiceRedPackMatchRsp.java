package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VoiceRedPackMatchRsp
  extends JceStruct
{
  public String billno = "";
  public String degree = "";
  public long grabUin;
  public long makeUin;
  public int status;
  public String strErr = "";
  public int timeInterval;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.grabUin = paramJceInputStream.read(this.grabUin, 0, false);
    this.billno = paramJceInputStream.readString(1, false);
    this.makeUin = paramJceInputStream.read(this.makeUin, 2, false);
    this.status = paramJceInputStream.read(this.status, 3, false);
    this.timeInterval = paramJceInputStream.read(this.timeInterval, 4, false);
    this.strErr = paramJceInputStream.readString(5, false);
    this.degree = paramJceInputStream.readString(6, false);
  }
  
  public String toString()
  {
    return "VoiceRedPackMatchRsp{grabUin=" + this.grabUin + ", billno='" + this.billno + '\'' + ", makeUin=" + this.makeUin + ", status=" + this.status + ", timeInterval=" + this.timeInterval + ", strErr='" + this.strErr + '\'' + ", degree='" + this.degree + '\'' + '}';
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
    if (this.degree != null) {
      paramJceOutputStream.write(this.degree, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.VoiceRedPackMatchRsp
 * JD-Core Version:    0.7.0.1
 */