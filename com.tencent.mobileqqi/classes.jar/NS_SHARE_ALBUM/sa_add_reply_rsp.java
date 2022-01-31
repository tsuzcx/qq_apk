package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sa_add_reply_rsp
  extends JceStruct
{
  public String replyid = "";
  public String verifyurl = "";
  
  public sa_add_reply_rsp() {}
  
  public sa_add_reply_rsp(String paramString1, String paramString2)
  {
    this.verifyurl = paramString1;
    this.replyid = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.verifyurl = paramJceInputStream.readString(0, false);
    this.replyid = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.verifyurl != null) {
      paramJceOutputStream.write(this.verifyurl, 0);
    }
    if (this.replyid != null) {
      paramJceOutputStream.write(this.replyid, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_add_reply_rsp
 * JD-Core Version:    0.7.0.1
 */