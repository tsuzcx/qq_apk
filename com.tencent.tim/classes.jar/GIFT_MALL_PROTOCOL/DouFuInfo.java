package GIFT_MALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DouFuInfo
  extends JceStruct
{
  public String background = "";
  public String birthday = "";
  public String blessing = "";
  public String doufu_link = "";
  public String icon = "";
  public long uin;
  
  public DouFuInfo() {}
  
  public DouFuInfo(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.birthday = paramString1;
    this.uin = paramLong;
    this.icon = paramString2;
    this.blessing = paramString3;
    this.doufu_link = paramString4;
    this.background = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.birthday = paramJceInputStream.readString(0, false);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.icon = paramJceInputStream.readString(2, false);
    this.blessing = paramJceInputStream.readString(3, false);
    this.doufu_link = paramJceInputStream.readString(4, false);
    this.background = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.birthday != null) {
      paramJceOutputStream.write(this.birthday, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
    if (this.icon != null) {
      paramJceOutputStream.write(this.icon, 2);
    }
    if (this.blessing != null) {
      paramJceOutputStream.write(this.blessing, 3);
    }
    if (this.doufu_link != null) {
      paramJceOutputStream.write(this.doufu_link, 4);
    }
    if (this.background != null) {
      paramJceOutputStream.write(this.background, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     GIFT_MALL_PROTOCOL.DouFuInfo
 * JD-Core Version:    0.7.0.1
 */