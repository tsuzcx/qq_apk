package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LastLoginInfo
  extends JceStruct
{
  public long dwClient = 0L;
  public long dwFriendUin = 0L;
  public long dwLastLoginType = 0L;
  
  public LastLoginInfo() {}
  
  public LastLoginInfo(long paramLong1, long paramLong2, long paramLong3)
  {
    this.dwFriendUin = paramLong1;
    this.dwLastLoginType = paramLong2;
    this.dwClient = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwFriendUin = paramJceInputStream.read(this.dwFriendUin, 0, false);
    this.dwLastLoginType = paramJceInputStream.read(this.dwLastLoginType, 1, false);
    this.dwClient = paramJceInputStream.read(this.dwClient, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwFriendUin, 0);
    paramJceOutputStream.write(this.dwLastLoginType, 1);
    paramJceOutputStream.write(this.dwClient, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.LastLoginInfo
 * JD-Core Version:    0.7.0.1
 */