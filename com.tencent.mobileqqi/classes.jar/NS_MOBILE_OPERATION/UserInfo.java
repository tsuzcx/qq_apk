package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserInfo
  extends JceStruct
{
  static int cache_iYellowType;
  public int iYellowType = 0;
  public long uin = 0L;
  
  public UserInfo() {}
  
  public UserInfo(long paramLong, int paramInt)
  {
    this.uin = paramLong;
    this.iYellowType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.iYellowType = paramJceInputStream.read(this.iYellowType, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.iYellowType, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.UserInfo
 * JD-Core Version:    0.7.0.1
 */