package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_click_button_rsp
  extends JceStruct
{
  public int iRet;
  public String strButtonText = "";
  public String strJumpUrl = "";
  public String strToastText = "";
  
  public operation_click_button_rsp() {}
  
  public operation_click_button_rsp(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.iRet = paramInt;
    this.strButtonText = paramString1;
    this.strJumpUrl = paramString2;
    this.strToastText = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, false);
    this.strButtonText = paramJceInputStream.readString(1, false);
    this.strJumpUrl = paramJceInputStream.readString(2, false);
    this.strToastText = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    if (this.strButtonText != null) {
      paramJceOutputStream.write(this.strButtonText, 1);
    }
    if (this.strJumpUrl != null) {
      paramJceOutputStream.write(this.strJumpUrl, 2);
    }
    if (this.strToastText != null) {
      paramJceOutputStream.write(this.strToastText, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.operation_click_button_rsp
 * JD-Core Version:    0.7.0.1
 */