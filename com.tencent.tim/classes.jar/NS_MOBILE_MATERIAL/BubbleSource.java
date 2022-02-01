package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BubbleSource
  extends JceStruct
{
  public String strAndUrl1 = "";
  public String strAndUrl2 = "";
  public String strIosUrl1 = "";
  public String strIosUrl2 = "";
  public String strTextColor1 = "";
  public String strTextColor2 = "";
  
  public BubbleSource() {}
  
  public BubbleSource(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.strTextColor1 = paramString1;
    this.strTextColor2 = paramString2;
    this.strAndUrl1 = paramString3;
    this.strAndUrl2 = paramString4;
    this.strIosUrl1 = paramString5;
    this.strIosUrl2 = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strTextColor1 = paramJceInputStream.readString(0, false);
    this.strTextColor2 = paramJceInputStream.readString(1, false);
    this.strAndUrl1 = paramJceInputStream.readString(2, false);
    this.strAndUrl2 = paramJceInputStream.readString(3, false);
    this.strIosUrl1 = paramJceInputStream.readString(4, false);
    this.strIosUrl2 = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strTextColor1 != null) {
      paramJceOutputStream.write(this.strTextColor1, 0);
    }
    if (this.strTextColor2 != null) {
      paramJceOutputStream.write(this.strTextColor2, 1);
    }
    if (this.strAndUrl1 != null) {
      paramJceOutputStream.write(this.strAndUrl1, 2);
    }
    if (this.strAndUrl2 != null) {
      paramJceOutputStream.write(this.strAndUrl2, 3);
    }
    if (this.strIosUrl1 != null) {
      paramJceOutputStream.write(this.strIosUrl1, 4);
    }
    if (this.strIosUrl2 != null) {
      paramJceOutputStream.write(this.strIosUrl2, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.BubbleSource
 * JD-Core Version:    0.7.0.1
 */