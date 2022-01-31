package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CommControl
  extends JceStruct
{
  static ProductVersion dX = new ProductVersion();
  static ArrayList dY = new ArrayList();
  public ArrayList buildNoList = null;
  public int cmdId = 0;
  public int count = 0;
  public String lc = "";
  public int time = 0;
  public ProductVersion version = null;
  public int versionCode = 0;
  
  static
  {
    dY.add(Integer.valueOf(0));
  }
  
  public JceStruct newInit()
  {
    return new CommControl();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmdId = paramJceInputStream.read(this.cmdId, 0, false);
    this.version = ((ProductVersion)paramJceInputStream.read(dX, 1, false));
    this.versionCode = paramJceInputStream.read(this.versionCode, 2, false);
    this.lc = paramJceInputStream.readString(3, false);
    this.buildNoList = ((ArrayList)paramJceInputStream.read(dY, 4, false));
    this.time = paramJceInputStream.read(this.time, 5, false);
    this.count = paramJceInputStream.read(this.count, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cmdId != 0) {
      paramJceOutputStream.write(this.cmdId, 0);
    }
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 1);
    }
    if (this.versionCode != 0) {
      paramJceOutputStream.write(this.versionCode, 2);
    }
    if (this.lc != null) {
      paramJceOutputStream.write(this.lc, 3);
    }
    if (this.buildNoList != null) {
      paramJceOutputStream.write(this.buildNoList, 4);
    }
    if (this.time != 0) {
      paramJceOutputStream.write(this.time, 5);
    }
    if (this.count != 0) {
      paramJceOutputStream.write(this.count, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CommControl
 * JD-Core Version:    0.7.0.1
 */