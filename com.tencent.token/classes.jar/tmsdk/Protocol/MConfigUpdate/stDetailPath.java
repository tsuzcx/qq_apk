package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stDetailPath
  extends JceStruct
{
  static ArrayList<String> bL = new ArrayList();
  public int delDays = 0;
  public String desc = "";
  public int importance = 0;
  public ArrayList<String> path = null;
  
  static
  {
    bL.add("");
  }
  
  public JceStruct newInit()
  {
    return new stDetailPath();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.path = ((ArrayList)paramJceInputStream.read(bL, 0, true));
    this.desc = paramJceInputStream.readString(1, false);
    this.importance = paramJceInputStream.read(this.importance, 2, false);
    this.delDays = paramJceInputStream.read(this.delDays, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.path, 0);
    String str = this.desc;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    int i = this.importance;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    i = this.delDays;
    if (i != 0) {
      paramJceOutputStream.write(i, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.stDetailPath
 * JD-Core Version:    0.7.0.1
 */