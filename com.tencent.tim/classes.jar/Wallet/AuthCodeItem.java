package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AuthCodeItem
  extends JceStruct
{
  public long appid;
  public String authCode = "";
  public long expireTime;
  public String urlDomain = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.expireTime = paramJceInputStream.read(this.expireTime, 1, false);
    this.urlDomain = paramJceInputStream.readString(2, false);
    this.authCode = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.expireTime, 1);
    if (this.urlDomain != null) {
      paramJceOutputStream.write(this.urlDomain, 2);
    }
    if (this.authCode != null) {
      paramJceOutputStream.write(this.authCode, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.AuthCodeItem
 * JD-Core Version:    0.7.0.1
 */