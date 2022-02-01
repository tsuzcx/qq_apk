package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_openid_user
  extends JceStruct
{
  public String logo = "";
  public String nickname = "";
  public String openid = "";
  
  public s_openid_user() {}
  
  public s_openid_user(String paramString1, String paramString2, String paramString3)
  {
    this.openid = paramString1;
    this.nickname = paramString2;
    this.logo = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.openid = paramJceInputStream.readString(0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.logo = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.openid != null) {
      paramJceOutputStream.write(this.openid, 0);
    }
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 1);
    }
    if (this.logo != null) {
      paramJceOutputStream.write(this.logo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_openid_user
 * JD-Core Version:    0.7.0.1
 */