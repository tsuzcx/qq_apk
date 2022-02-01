package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class CommControl
  extends JceStruct
{
  static ProductVersion dX = new ProductVersion();
  static ArrayList<Integer> dY = new ArrayList();
  public ArrayList<Integer> buildNoList = null;
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
    int i = this.cmdId;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    Object localObject = this.version;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    i = this.versionCode;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    localObject = this.lc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.buildNoList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    i = this.time;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
    i = this.count;
    if (i != 0) {
      paramJceOutputStream.write(i, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CommControl
 * JD-Core Version:    0.7.0.1
 */