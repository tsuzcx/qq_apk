package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_likeman
  extends JceStruct
{
  static s_user cache_user;
  public String refer = "";
  public s_user user = null;
  
  public s_likeman() {}
  
  public s_likeman(s_user params_user, String paramString)
  {
    this.user = params_user;
    this.refer = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_user == null) {
      cache_user = new s_user();
    }
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, false));
    this.refer = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 0);
    }
    if (this.refer != null) {
      paramJceOutputStream.write(this.refer, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_likeman
 * JD-Core Version:    0.7.0.1
 */