package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AdPlugin
  extends JceStruct
{
  static ArrayList<String> dA;
  static ArrayList<String> dz;
  public ArrayList<String> banIps = null;
  public ArrayList<String> banUrls = null;
  public int behavior1 = 0;
  public int behavior2 = 0;
  public int id = 0;
  public String name = "";
  public int type = 0;
  
  public AdPlugin() {}
  
  public AdPlugin(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, String paramString)
  {
    this.id = paramInt1;
    this.type = paramInt2;
    this.behavior1 = paramInt3;
    this.behavior2 = paramInt4;
    this.banUrls = paramArrayList1;
    this.banIps = paramArrayList2;
    this.name = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.read(this.id, 0, true);
    this.type = paramJceInputStream.read(this.type, 1, true);
    this.behavior1 = paramJceInputStream.read(this.behavior1, 2, true);
    this.behavior2 = paramJceInputStream.read(this.behavior2, 3, true);
    if (dz == null)
    {
      dz = new ArrayList();
      dz.add("");
    }
    this.banUrls = ((ArrayList)paramJceInputStream.read(dz, 4, true));
    if (dA == null)
    {
      dA = new ArrayList();
      dA.add("");
    }
    this.banIps = ((ArrayList)paramJceInputStream.read(dA, 5, true));
    this.name = paramJceInputStream.readString(6, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.type, 1);
    paramJceOutputStream.write(this.behavior1, 2);
    paramJceOutputStream.write(this.behavior2, 3);
    paramJceOutputStream.write(this.banUrls, 4);
    paramJceOutputStream.write(this.banIps, 5);
    paramJceOutputStream.write(this.name, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.AdPlugin
 * JD-Core Version:    0.7.0.1
 */