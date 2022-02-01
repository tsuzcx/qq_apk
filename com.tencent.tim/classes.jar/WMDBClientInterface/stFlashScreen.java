package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFlashScreen
  extends JceStruct
{
  public String bgtime = "";
  public String edtime = "";
  public String furl = "";
  public String id = "";
  
  public stFlashScreen() {}
  
  public stFlashScreen(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.id = paramString1;
    this.furl = paramString2;
    this.bgtime = paramString3;
    this.edtime = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, true);
    this.furl = paramJceInputStream.readString(1, true);
    this.bgtime = paramJceInputStream.readString(2, true);
    this.edtime = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.furl, 1);
    paramJceOutputStream.write(this.bgtime, 2);
    paramJceOutputStream.write(this.edtime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     WMDBClientInterface.stFlashScreen
 * JD-Core Version:    0.7.0.1
 */