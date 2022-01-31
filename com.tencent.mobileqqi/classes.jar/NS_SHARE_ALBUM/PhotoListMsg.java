package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PhotoListMsg
  extends JceStruct
{
  public String msg = "";
  public long time = 0L;
  
  public PhotoListMsg() {}
  
  public PhotoListMsg(String paramString, long paramLong)
  {
    this.msg = paramString;
    this.time = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.msg = paramJceInputStream.readString(0, false);
    this.time = paramJceInputStream.read(this.time, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 0);
    }
    paramJceOutputStream.write(this.time, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.PhotoListMsg
 * JD-Core Version:    0.7.0.1
 */