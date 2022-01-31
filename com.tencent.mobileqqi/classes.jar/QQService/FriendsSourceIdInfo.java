package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FriendsSourceIdInfo
  extends JceStruct
{
  public String strContent = "";
  public short wSourceId = 0;
  public short wSourceSubId = 0;
  
  public FriendsSourceIdInfo() {}
  
  public FriendsSourceIdInfo(short paramShort1, short paramShort2, String paramString)
  {
    this.wSourceId = paramShort1;
    this.wSourceSubId = paramShort2;
    this.strContent = paramString;
  }
  
  public String className()
  {
    return "QQService.FriendsSourceIdInfo";
  }
  
  public String fullClassName()
  {
    return "QQService.FriendsSourceIdInfo";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.wSourceId = paramJceInputStream.read(this.wSourceId, 0, true);
    this.wSourceSubId = paramJceInputStream.read(this.wSourceSubId, 1, true);
    this.strContent = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wSourceId, 0);
    paramJceOutputStream.write(this.wSourceSubId, 1);
    if (this.strContent != null) {
      paramJceOutputStream.write(this.strContent, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.FriendsSourceIdInfo
 * JD-Core Version:    0.7.0.1
 */