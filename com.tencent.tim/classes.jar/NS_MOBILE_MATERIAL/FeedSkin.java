package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FeedSkin
  extends JceStruct
{
  public int iFrameRate;
  public int iItemId = -1;
  public int iType;
  public String strAndBgUrl = "";
  public String strBgColor = "";
  public String strFrameZip = "";
  public String strGradientColorBegin = "";
  public String strGradientColorEnd = "";
  public String strIosBgUrl = "";
  
  public FeedSkin() {}
  
  public FeedSkin(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3)
  {
    this.iItemId = paramInt1;
    this.iType = paramInt2;
    this.strBgColor = paramString1;
    this.strGradientColorBegin = paramString2;
    this.strGradientColorEnd = paramString3;
    this.strAndBgUrl = paramString4;
    this.strIosBgUrl = paramString5;
    this.strFrameZip = paramString6;
    this.iFrameRate = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, false);
    this.iType = paramJceInputStream.read(this.iType, 1, false);
    this.strBgColor = paramJceInputStream.readString(2, false);
    this.strGradientColorBegin = paramJceInputStream.readString(3, false);
    this.strGradientColorEnd = paramJceInputStream.readString(4, false);
    this.strAndBgUrl = paramJceInputStream.readString(5, false);
    this.strIosBgUrl = paramJceInputStream.readString(6, false);
    this.strFrameZip = paramJceInputStream.readString(7, false);
    this.iFrameRate = paramJceInputStream.read(this.iFrameRate, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    paramJceOutputStream.write(this.iType, 1);
    if (this.strBgColor != null) {
      paramJceOutputStream.write(this.strBgColor, 2);
    }
    if (this.strGradientColorBegin != null) {
      paramJceOutputStream.write(this.strGradientColorBegin, 3);
    }
    if (this.strGradientColorEnd != null) {
      paramJceOutputStream.write(this.strGradientColorEnd, 4);
    }
    if (this.strAndBgUrl != null) {
      paramJceOutputStream.write(this.strAndBgUrl, 5);
    }
    if (this.strIosBgUrl != null) {
      paramJceOutputStream.write(this.strIosBgUrl, 6);
    }
    if (this.strFrameZip != null) {
      paramJceOutputStream.write(this.strFrameZip, 7);
    }
    paramJceOutputStream.write(this.iFrameRate, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.FeedSkin
 * JD-Core Version:    0.7.0.1
 */