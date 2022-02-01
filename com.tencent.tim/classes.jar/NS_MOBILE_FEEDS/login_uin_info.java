package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class login_uin_info
  extends JceStruct
{
  public int highFiveNotifyStatus;
  public String nickname = "";
  
  public login_uin_info() {}
  
  public login_uin_info(String paramString, int paramInt)
  {
    this.nickname = paramString;
    this.highFiveNotifyStatus = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nickname = paramJceInputStream.readString(0, false);
    this.highFiveNotifyStatus = paramJceInputStream.read(this.highFiveNotifyStatus, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 0);
    }
    paramJceOutputStream.write(this.highFiveNotifyStatus, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.login_uin_info
 * JD-Core Version:    0.7.0.1
 */