package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class User
  extends JceStruct
{
  public String nickname = "";
  public String recomReason = "";
  public String uid = "";
  
  public User() {}
  
  public User(String paramString1, String paramString2, String paramString3)
  {
    this.uid = paramString1;
    this.nickname = paramString2;
    this.recomReason = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uid = paramJceInputStream.readString(0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.recomReason = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.uid != null) {
      paramJceOutputStream.write(this.uid, 0);
    }
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 1);
    }
    if (this.recomReason != null) {
      paramJceOutputStream.write(this.recomReason, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.User
 * JD-Core Version:    0.7.0.1
 */