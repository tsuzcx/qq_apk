package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PengYouInfo
  extends JceStruct
{
  public String strPYFaceUrl = "";
  public String strPYName = "";
  
  public PengYouInfo() {}
  
  public PengYouInfo(String paramString1, String paramString2)
  {
    this.strPYName = paramString1;
    this.strPYFaceUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPYName = paramJceInputStream.readString(0, true);
    this.strPYFaceUrl = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPYName, 0);
    paramJceOutputStream.write(this.strPYFaceUrl, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     EncounterSvc.PengYouInfo
 * JD-Core Version:    0.7.0.1
 */