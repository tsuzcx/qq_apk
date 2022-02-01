package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetFontDataReq
  extends JceStruct
{
  public String Content = "";
  public String FontName = "";
  
  public GetFontDataReq() {}
  
  public GetFontDataReq(String paramString1, String paramString2)
  {
    this.FontName = paramString1;
    this.Content = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.FontName = paramJceInputStream.readString(0, false);
    this.Content = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.FontName != null) {
      paramJceOutputStream.write(this.FontName, 0);
    }
    if (this.Content != null) {
      paramJceOutputStream.write(this.Content, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataReq
 * JD-Core Version:    0.7.0.1
 */