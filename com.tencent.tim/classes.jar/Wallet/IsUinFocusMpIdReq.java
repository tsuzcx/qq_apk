package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IsUinFocusMpIdReq
  extends JceStruct
{
  public String appid = "";
  public String uin = "";
  
  public IsUinFocusMpIdReq() {}
  
  public IsUinFocusMpIdReq(String paramString1, String paramString2)
  {
    this.uin = paramString1;
    this.appid = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(0, false);
    this.appid = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.uin != null) {
      paramJceOutputStream.write(this.uin, 0);
    }
    if (this.appid != null) {
      paramJceOutputStream.write(this.appid, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Wallet.IsUinFocusMpIdReq
 * JD-Core Version:    0.7.0.1
 */