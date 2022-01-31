package GameCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GameLogoUrl
  extends JceStruct
{
  public String sAppid = "";
  public String sGameName = "";
  public String sLogoMd5 = "";
  public String sLogoName = "";
  
  public GameLogoUrl() {}
  
  public GameLogoUrl(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.sLogoMd5 = paramString1;
    this.sLogoName = paramString2;
    this.sAppid = paramString3;
    this.sGameName = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sLogoMd5 = paramJceInputStream.readString(0, true);
    this.sLogoName = paramJceInputStream.readString(1, true);
    this.sAppid = paramJceInputStream.readString(2, false);
    this.sGameName = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sLogoMd5, 0);
    paramJceOutputStream.write(this.sLogoName, 1);
    if (this.sAppid != null) {
      paramJceOutputStream.write(this.sAppid, 2);
    }
    if (this.sGameName != null) {
      paramJceOutputStream.write(this.sGameName, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     GameCenter.GameLogoUrl
 * JD-Core Version:    0.7.0.1
 */