package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetTroopRemarkReq
  extends JceStruct
{
  public long GroupCode = 0L;
  public long GroupUin = 0L;
  public long NextUin = 0L;
  public long Seq = 0L;
  public long uin = 0L;
  
  public GetTroopRemarkReq() {}
  
  public GetTroopRemarkReq(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.uin = paramLong1;
    this.GroupCode = paramLong2;
    this.GroupUin = paramLong3;
    this.Seq = paramLong4;
    this.NextUin = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 2, true);
    this.Seq = paramJceInputStream.read(this.Seq, 3, true);
    this.NextUin = paramJceInputStream.read(this.NextUin, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.GroupUin, 2);
    paramJceOutputStream.write(this.Seq, 3);
    paramJceOutputStream.write(this.NextUin, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.GetTroopRemarkReq
 * JD-Core Version:    0.7.0.1
 */