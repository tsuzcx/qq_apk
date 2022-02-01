package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DelFriendResp
  extends JceStruct
{
  static int cache_result;
  public long deluin;
  public short errorCode;
  public int result;
  public long uin;
  
  public DelFriendResp() {}
  
  public DelFriendResp(long paramLong1, long paramLong2, int paramInt, short paramShort)
  {
    this.uin = paramLong1;
    this.deluin = paramLong2;
    this.result = paramInt;
    this.errorCode = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.deluin = paramJceInputStream.read(this.deluin, 1, true);
    this.result = paramJceInputStream.read(this.result, 2, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.deluin, 1);
    paramJceOutputStream.write(this.result, 2);
    paramJceOutputStream.write(this.errorCode, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     friendlist.DelFriendResp
 * JD-Core Version:    0.7.0.1
 */