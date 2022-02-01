package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class u
  extends JceStruct
{
  static ArrayList<String> aK = new ArrayList();
  static Map<String, String> aL;
  public ArrayList<String> aG = null;
  public int aH = 0;
  public boolean aI = false;
  public Map<String, String> aJ = null;
  public int apn = 0;
  public int ay = 0;
  
  static
  {
    aK.add("");
    aL = new HashMap();
    aL.put("", "");
  }
  
  public JceStruct newInit()
  {
    return new u();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ay = paramJceInputStream.read(this.ay, 0, true);
    this.aG = ((ArrayList)paramJceInputStream.read(aK, 1, true));
    this.aH = paramJceInputStream.read(this.aH, 2, true);
    this.aI = paramJceInputStream.read(this.aI, 3, false);
    this.apn = paramJceInputStream.read(this.apn, 4, false);
    this.aJ = ((Map)paramJceInputStream.read(aL, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ay, 0);
    paramJceOutputStream.write(this.aG, 1);
    paramJceOutputStream.write(this.aH, 2);
    boolean bool = this.aI;
    if (bool) {
      paramJceOutputStream.write(bool, 3);
    }
    paramJceOutputStream.write(this.apn, 4);
    Map localMap = this.aJ;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.u
 * JD-Core Version:    0.7.0.1
 */