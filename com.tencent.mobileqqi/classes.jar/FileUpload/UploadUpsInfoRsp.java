package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UploadUpsInfoRsp
  extends JceStruct
{
  static byte[] cache_vBusiNessData;
  public int iHight = 0;
  public int iPhotoType = 0;
  public int iType = 0;
  public int iWidth = 0;
  public String sUrl = "";
  public byte[] vBusiNessData = null;
  
  public UploadUpsInfoRsp() {}
  
  public UploadUpsInfoRsp(int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iType = paramInt1;
    this.vBusiNessData = paramArrayOfByte;
    this.sUrl = paramString;
    this.iWidth = paramInt2;
    this.iHight = paramInt3;
    this.iPhotoType = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iType = paramJceInputStream.read(this.iType, 0, true);
    if (cache_vBusiNessData == null)
    {
      cache_vBusiNessData = new byte[1];
      cache_vBusiNessData[0] = 0;
    }
    this.vBusiNessData = paramJceInputStream.read(cache_vBusiNessData, 1, false);
    this.sUrl = paramJceInputStream.readString(2, false);
    this.iWidth = paramJceInputStream.read(this.iWidth, 3, false);
    this.iHight = paramJceInputStream.read(this.iHight, 4, false);
    this.iPhotoType = paramJceInputStream.read(this.iPhotoType, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iType, 0);
    if (this.vBusiNessData != null) {
      paramJceOutputStream.write(this.vBusiNessData, 1);
    }
    if (this.sUrl != null) {
      paramJceOutputStream.write(this.sUrl, 2);
    }
    paramJceOutputStream.write(this.iWidth, 3);
    paramJceOutputStream.write(this.iHight, 4);
    paramJceOutputStream.write(this.iPhotoType, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     FileUpload.UploadUpsInfoRsp
 * JD-Core Version:    0.7.0.1
 */