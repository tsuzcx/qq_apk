package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stCategory
  extends JceStruct
{
  public String iconSelectedUrl = "";
  public String iconUrl = "";
  public String id = "";
  public String name = "";
  public int priority = 1;
  
  public stCategory() {}
  
  public stCategory(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.iconUrl = paramString3;
    this.iconSelectedUrl = paramString4;
    this.priority = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, true);
    this.name = paramJceInputStream.readString(1, true);
    this.iconUrl = paramJceInputStream.readString(2, true);
    this.iconSelectedUrl = paramJceInputStream.readString(3, true);
    this.priority = paramJceInputStream.read(this.priority, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.iconUrl, 2);
    paramJceOutputStream.write(this.iconSelectedUrl, 3);
    paramJceOutputStream.write(this.priority, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     WMDBClientInterface.stCategory
 * JD-Core Version:    0.7.0.1
 */