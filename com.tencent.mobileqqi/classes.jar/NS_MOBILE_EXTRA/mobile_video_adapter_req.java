package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_video_adapter_req
  extends JceStruct
{
  public int iFlash = 0;
  public String strUserAgent = "";
  public String strVideoUrl = "";
  
  public mobile_video_adapter_req() {}
  
  public mobile_video_adapter_req(String paramString1, int paramInt, String paramString2)
  {
    this.strVideoUrl = paramString1;
    this.iFlash = paramInt;
    this.strUserAgent = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strVideoUrl = paramJceInputStream.readString(0, false);
    this.iFlash = paramJceInputStream.read(this.iFlash, 1, false);
    this.strUserAgent = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strVideoUrl != null) {
      paramJceOutputStream.write(this.strVideoUrl, 0);
    }
    paramJceOutputStream.write(this.iFlash, 1);
    if (this.strUserAgent != null) {
      paramJceOutputStream.write(this.strUserAgent, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.mobile_video_adapter_req
 * JD-Core Version:    0.7.0.1
 */