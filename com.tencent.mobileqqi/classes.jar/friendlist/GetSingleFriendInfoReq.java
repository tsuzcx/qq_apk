package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetSingleFriendInfoReq
  extends JceStruct
{
  public long frienduin = 0L;
  public byte ifReflush = 0;
  public long uin = 0L;
  
  public GetSingleFriendInfoReq() {}
  
  public GetSingleFriendInfoReq(byte paramByte, long paramLong1, long paramLong2)
  {
    this.ifReflush = paramByte;
    this.uin = paramLong1;
    this.frienduin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ifReflush = paramJceInputStream.read(this.ifReflush, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.frienduin = paramJceInputStream.read(this.frienduin, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ifReflush, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.frienduin, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.GetSingleFriendInfoReq
 * JD-Core Version:    0.7.0.1
 */