package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stAlbumInfo
  extends JceStruct
{
  public String strMid = "";
  public String strName = "";
  public String strPic = "";
  public long uiId;
  
  public stAlbumInfo() {}
  
  public stAlbumInfo(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.uiId = paramLong;
    this.strMid = paramString1;
    this.strName = paramString2;
    this.strPic = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uiId = paramJceInputStream.read(this.uiId, 0, false);
    this.strMid = paramJceInputStream.readString(1, false);
    this.strName = paramJceInputStream.readString(2, false);
    this.strPic = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uiId, 0);
    if (this.strMid != null) {
      paramJceOutputStream.write(this.strMid, 1);
    }
    if (this.strName != null) {
      paramJceOutputStream.write(this.strName, 2);
    }
    if (this.strPic != null) {
      paramJceOutputStream.write(this.strPic, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stAlbumInfo
 * JD-Core Version:    0.7.0.1
 */