package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MaterialFile
  extends JceStruct
{
  public int iFileId;
  public int iFileType;
  public int iHeight;
  public int iSize;
  public int iWidth;
  public String strMd5 = "";
  public String strName = "";
  public String strUrl = "";
  
  public MaterialFile() {}
  
  public MaterialFile(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.iFileId = paramInt1;
    this.strName = paramString1;
    this.strUrl = paramString2;
    this.strMd5 = paramString3;
    this.iSize = paramInt2;
    this.iFileType = paramInt3;
    this.iWidth = paramInt4;
    this.iHeight = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iFileId = paramJceInputStream.read(this.iFileId, 0, true);
    this.strName = paramJceInputStream.readString(1, false);
    this.strUrl = paramJceInputStream.readString(2, false);
    this.strMd5 = paramJceInputStream.readString(3, false);
    this.iSize = paramJceInputStream.read(this.iSize, 4, false);
    this.iFileType = paramJceInputStream.read(this.iFileType, 5, false);
    this.iWidth = paramJceInputStream.read(this.iWidth, 6, false);
    this.iHeight = paramJceInputStream.read(this.iHeight, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iFileId, 0);
    if (this.strName != null) {
      paramJceOutputStream.write(this.strName, 1);
    }
    if (this.strUrl != null) {
      paramJceOutputStream.write(this.strUrl, 2);
    }
    if (this.strMd5 != null) {
      paramJceOutputStream.write(this.strMd5, 3);
    }
    paramJceOutputStream.write(this.iSize, 4);
    paramJceOutputStream.write(this.iFileType, 5);
    paramJceOutputStream.write(this.iWidth, 6);
    paramJceOutputStream.write(this.iHeight, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.MaterialFile
 * JD-Core Version:    0.7.0.1
 */