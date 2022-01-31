package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DelFriendReq
  extends JceStruct
{
  public byte delType = 0;
  public long deluin = 0L;
  public long uin = 0L;
  
  public DelFriendReq() {}
  
  public DelFriendReq(long paramLong1, long paramLong2, byte paramByte)
  {
    this.uin = paramLong1;
    this.deluin = paramLong2;
    this.delType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.deluin = paramJceInputStream.read(this.deluin, 1, true);
    this.delType = paramJceInputStream.read(this.delType, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.deluin, 1);
    paramJceOutputStream.write(this.delType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.DelFriendReq
 * JD-Core Version:    0.7.0.1
 */