package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PhotoInformation
  extends JceStruct
{
  public int iHight;
  public int iPhotoType;
  public int iWidth;
  public String sUrl = "";
  
  public PhotoInformation() {}
  
  public PhotoInformation(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.sUrl = paramString;
    this.iWidth = paramInt1;
    this.iHight = paramInt2;
    this.iPhotoType = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sUrl = paramJceInputStream.readString(0, false);
    this.iWidth = paramJceInputStream.read(this.iWidth, 1, false);
    this.iHight = paramJceInputStream.read(this.iHight, 2, false);
    this.iPhotoType = paramJceInputStream.read(this.iPhotoType, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sUrl != null) {
      paramJceOutputStream.write(this.sUrl, 0);
    }
    paramJceOutputStream.write(this.iWidth, 1);
    paramJceOutputStream.write(this.iHight, 2);
    paramJceOutputStream.write(this.iPhotoType, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.PhotoInformation
 * JD-Core Version:    0.7.0.1
 */