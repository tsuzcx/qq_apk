package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class o
  extends JceStruct
{
  static ArrayList<Integer> av;
  static ArrayList<String> aw;
  public int ar = 0;
  public ArrayList<Integer> as = null;
  public ArrayList<String> at = null;
  public int au = 0;
  public int count = 1;
  public int pluginId = 0;
  public int timestamp = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.ar = paramJceInputStream.read(this.ar, 0, true);
    this.timestamp = paramJceInputStream.read(this.timestamp, 1, true);
    this.count = paramJceInputStream.read(this.count, 2, false);
    if (av == null)
    {
      av = new ArrayList();
      av.add(Integer.valueOf(0));
    }
    this.as = ((ArrayList)paramJceInputStream.read(av, 3, false));
    if (aw == null)
    {
      aw = new ArrayList();
      aw.add("");
    }
    this.at = ((ArrayList)paramJceInputStream.read(aw, 4, false));
    this.pluginId = paramJceInputStream.read(this.pluginId, 5, false);
    this.au = paramJceInputStream.read(this.au, 6, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ar, 0);
    paramJceOutputStream.write(this.timestamp, 1);
    int i = this.count;
    if (i != 1) {
      paramJceOutputStream.write(i, 2);
    }
    ArrayList localArrayList = this.as;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 3);
    }
    localArrayList = this.at;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 4);
    }
    i = this.pluginId;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
    i = this.au;
    if (i != 0) {
      paramJceOutputStream.write(i, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.o
 * JD-Core Version:    0.7.0.1
 */