package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class m
  extends JceStruct
{
  static ArrayList<String> aU = new ArrayList();
  static Map<String, String> aV;
  public int aO = 0;
  public ArrayList<String> aP = null;
  public int aQ = 0;
  public boolean aR = false;
  public int aS = 0;
  public Map<String, String> aT = null;
  
  static
  {
    aU.add("");
    aV = new HashMap();
    aV.put("", "");
  }
  
  public JceStruct newInit()
  {
    return new m();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aO = paramJceInputStream.read(this.aO, 0, true);
    this.aP = ((ArrayList)paramJceInputStream.read(aU, 1, true));
    this.aQ = paramJceInputStream.read(this.aQ, 2, true);
    this.aR = paramJceInputStream.read(this.aR, 3, false);
    this.aS = paramJceInputStream.read(this.aS, 4, false);
    this.aT = ((Map)paramJceInputStream.read(aV, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.aO, 0);
    paramJceOutputStream.write(this.aP, 1);
    paramJceOutputStream.write(this.aQ, 2);
    if (this.aR) {
      paramJceOutputStream.write(this.aR, 3);
    }
    paramJceOutputStream.write(this.aS, 4);
    if (this.aT != null) {
      paramJceOutputStream.write(this.aT, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.m
 * JD-Core Version:    0.7.0.1
 */