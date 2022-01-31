package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VedioInfo
  extends JceStruct
{
  public String detailurl = "";
  public String img = "";
  public String playurl = "";
  public int pub_route = 0;
  public String title = "";
  public String video_id = "";
  public int who = 0;
  
  public VedioInfo() {}
  
  public VedioInfo(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2)
  {
    this.playurl = paramString1;
    this.img = paramString2;
    this.title = paramString3;
    this.who = paramInt1;
    this.detailurl = paramString4;
    this.video_id = paramString5;
    this.pub_route = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.playurl = paramJceInputStream.readString(0, false);
    this.img = paramJceInputStream.readString(1, false);
    this.title = paramJceInputStream.readString(2, false);
    this.who = paramJceInputStream.read(this.who, 3, false);
    this.detailurl = paramJceInputStream.readString(4, false);
    this.video_id = paramJceInputStream.readString(5, false);
    this.pub_route = paramJceInputStream.read(this.pub_route, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.playurl != null) {
      paramJceOutputStream.write(this.playurl, 0);
    }
    if (this.img != null) {
      paramJceOutputStream.write(this.img, 1);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 2);
    }
    paramJceOutputStream.write(this.who, 3);
    if (this.detailurl != null) {
      paramJceOutputStream.write(this.detailurl, 4);
    }
    if (this.video_id != null) {
      paramJceOutputStream.write(this.video_id, 5);
    }
    paramJceOutputStream.write(this.pub_route, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.VedioInfo
 * JD-Core Version:    0.7.0.1
 */