package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SSummaryCardQueryReq
  extends JceStruct
{
  static int cache_cmd;
  static int cache_src;
  public int cmd = 1;
  public long platform = 0L;
  public long queryuin = 0L;
  public int src = 0;
  public long uin = 0L;
  public String version = "4.7.0";
  
  public SSummaryCardQueryReq() {}
  
  public SSummaryCardQueryReq(int paramInt1, long paramLong1, long paramLong2, String paramString, int paramInt2, long paramLong3)
  {
    this.cmd = paramInt1;
    this.uin = paramLong1;
    this.queryuin = paramLong2;
    this.version = paramString;
    this.src = paramInt2;
    this.platform = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmd = paramJceInputStream.read(this.cmd, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.queryuin = paramJceInputStream.read(this.queryuin, 2, true);
    this.version = paramJceInputStream.readString(3, false);
    this.src = paramJceInputStream.read(this.src, 4, false);
    this.platform = paramJceInputStream.read(this.platform, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmd, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.queryuin, 2);
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 3);
    }
    paramJceOutputStream.write(this.src, 4);
    paramJceOutputStream.write(this.platform, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SummaryCardTaf.SSummaryCardQueryReq
 * JD-Core Version:    0.7.0.1
 */