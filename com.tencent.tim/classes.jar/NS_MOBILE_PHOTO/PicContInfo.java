package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PicContInfo
  extends JceStruct
{
  public String md5 = "";
  public long size;
  
  public PicContInfo() {}
  
  public PicContInfo(String paramString, long paramLong)
  {
    this.md5 = paramString;
    this.size = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.md5 = paramJceInputStream.readString(0, false);
    this.size = paramJceInputStream.read(this.size, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.md5 != null) {
      paramJceOutputStream.write(this.md5, 0);
    }
    paramJceOutputStream.write(this.size, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PicContInfo
 * JD-Core Version:    0.7.0.1
 */