package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWxMiniProg
  extends JceStruct
{
  public String appThumbUrl = "";
  public String appid = "";
  public String hdImageDataURL = "";
  public int miniProgramType;
  public String path = "";
  public String userName = "";
  public int videoCoverHeight;
  public int videoCoverWidth;
  public String videoSource = "";
  public String videoUserName = "";
  public String webpageUrl = "";
  public int withShareTicket;
  
  public stWxMiniProg() {}
  
  public stWxMiniProg(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, int paramInt3, int paramInt4, String paramString8)
  {
    this.webpageUrl = paramString1;
    this.userName = paramString2;
    this.path = paramString3;
    this.hdImageDataURL = paramString4;
    this.withShareTicket = paramInt1;
    this.miniProgramType = paramInt2;
    this.appid = paramString5;
    this.videoUserName = paramString6;
    this.videoSource = paramString7;
    this.videoCoverWidth = paramInt3;
    this.videoCoverHeight = paramInt4;
    this.appThumbUrl = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.webpageUrl = paramJceInputStream.readString(0, false);
    this.userName = paramJceInputStream.readString(1, false);
    this.path = paramJceInputStream.readString(2, false);
    this.hdImageDataURL = paramJceInputStream.readString(3, false);
    this.withShareTicket = paramJceInputStream.read(this.withShareTicket, 4, false);
    this.miniProgramType = paramJceInputStream.read(this.miniProgramType, 5, false);
    this.appid = paramJceInputStream.readString(6, false);
    this.videoUserName = paramJceInputStream.readString(7, false);
    this.videoSource = paramJceInputStream.readString(8, false);
    this.videoCoverWidth = paramJceInputStream.read(this.videoCoverWidth, 9, false);
    this.videoCoverHeight = paramJceInputStream.read(this.videoCoverHeight, 10, false);
    this.appThumbUrl = paramJceInputStream.readString(11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.webpageUrl != null) {
      paramJceOutputStream.write(this.webpageUrl, 0);
    }
    if (this.userName != null) {
      paramJceOutputStream.write(this.userName, 1);
    }
    if (this.path != null) {
      paramJceOutputStream.write(this.path, 2);
    }
    if (this.hdImageDataURL != null) {
      paramJceOutputStream.write(this.hdImageDataURL, 3);
    }
    paramJceOutputStream.write(this.withShareTicket, 4);
    paramJceOutputStream.write(this.miniProgramType, 5);
    if (this.appid != null) {
      paramJceOutputStream.write(this.appid, 6);
    }
    if (this.videoUserName != null) {
      paramJceOutputStream.write(this.videoUserName, 7);
    }
    if (this.videoSource != null) {
      paramJceOutputStream.write(this.videoSource, 8);
    }
    paramJceOutputStream.write(this.videoCoverWidth, 9);
    paramJceOutputStream.write(this.videoCoverHeight, 10);
    if (this.appThumbUrl != null) {
      paramJceOutputStream.write(this.appThumbUrl, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stWxMiniProg
 * JD-Core Version:    0.7.0.1
 */