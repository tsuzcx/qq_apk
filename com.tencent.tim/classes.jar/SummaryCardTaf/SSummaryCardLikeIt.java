package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SSummaryCardLikeIt
  extends JceStruct
{
  static int cache_cmd;
  public int cmd = 3;
  public long label;
  public long likeuin;
  public long platform;
  public long uin;
  public String version = "4.7.0";
  
  public SSummaryCardLikeIt() {}
  
  public SSummaryCardLikeIt(int paramInt, long paramLong1, long paramLong2, String paramString, long paramLong3, long paramLong4)
  {
    this.cmd = paramInt;
    this.uin = paramLong1;
    this.likeuin = paramLong2;
    this.version = paramString;
    this.platform = paramLong3;
    this.label = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmd = paramJceInputStream.read(this.cmd, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.likeuin = paramJceInputStream.read(this.likeuin, 2, true);
    this.version = paramJceInputStream.readString(3, false);
    this.platform = paramJceInputStream.read(this.platform, 4, false);
    this.label = paramJceInputStream.read(this.label, 5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmd, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.likeuin, 2);
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 3);
    }
    paramJceOutputStream.write(this.platform, 4);
    paramJceOutputStream.write(this.label, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCardTaf.SSummaryCardLikeIt
 * JD-Core Version:    0.7.0.1
 */