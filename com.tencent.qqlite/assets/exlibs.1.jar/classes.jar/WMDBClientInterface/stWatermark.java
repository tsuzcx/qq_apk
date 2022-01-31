package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWatermark
  extends JceStruct
{
  public String categoryId = "";
  public String id = "";
  public int mask = 1;
  public int miniSupportVersion = 0;
  public String name = "";
  public String packageUrl4Android = "";
  public String packageUrl4iPhone = "";
  public int priority = 1;
  public String thumbUrl = "";
  public int version = 1;
  
  public stWatermark() {}
  
  public stWatermark(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.categoryId = paramString3;
    this.thumbUrl = paramString4;
    this.packageUrl4Android = paramString5;
    this.packageUrl4iPhone = paramString6;
    this.miniSupportVersion = paramInt1;
    this.mask = paramInt2;
    this.version = paramInt3;
    this.priority = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, true);
    this.name = paramJceInputStream.readString(1, true);
    this.categoryId = paramJceInputStream.readString(2, true);
    this.thumbUrl = paramJceInputStream.readString(3, true);
    this.packageUrl4Android = paramJceInputStream.readString(4, true);
    this.packageUrl4iPhone = paramJceInputStream.readString(5, true);
    this.miniSupportVersion = paramJceInputStream.read(this.miniSupportVersion, 6, true);
    this.mask = paramJceInputStream.read(this.mask, 8, true);
    this.version = paramJceInputStream.read(this.version, 9, true);
    this.priority = paramJceInputStream.read(this.priority, 10, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.categoryId, 2);
    paramJceOutputStream.write(this.thumbUrl, 3);
    paramJceOutputStream.write(this.packageUrl4Android, 4);
    paramJceOutputStream.write(this.packageUrl4iPhone, 5);
    paramJceOutputStream.write(this.miniSupportVersion, 6);
    paramJceOutputStream.write(this.mask, 8);
    paramJceOutputStream.write(this.version, 9);
    paramJceOutputStream.write(this.priority, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     WMDBClientInterface.stWatermark
 * JD-Core Version:    0.7.0.1
 */