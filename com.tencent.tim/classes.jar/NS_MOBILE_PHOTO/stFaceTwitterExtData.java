package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFaceTwitterExtData
  extends JceStruct
{
  public long owneruin;
  public String tid = "";
  
  public stFaceTwitterExtData() {}
  
  public stFaceTwitterExtData(String paramString, long paramLong)
  {
    this.tid = paramString;
    this.owneruin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tid = paramJceInputStream.readString(0, true);
    this.owneruin = paramJceInputStream.read(this.owneruin, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tid, 0);
    paramJceOutputStream.write(this.owneruin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.stFaceTwitterExtData
 * JD-Core Version:    0.7.0.1
 */