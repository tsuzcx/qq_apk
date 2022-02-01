package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class v
  extends JceStruct
{
  static s aA = new s();
  static ArrayList<Integer> aU = new ArrayList();
  static ArrayList<t> aV;
  public int aM = 0;
  public ArrayList<Integer> aN = null;
  public ArrayList<t> aO = null;
  public int aP = 0;
  public boolean aQ = true;
  public boolean aR = true;
  public int aS = 120;
  public int aT = 10;
  public int ay = 0;
  public s az = null;
  
  static
  {
    aU.add(Integer.valueOf(0));
    aV = new ArrayList();
    t localt = new t();
    aV.add(localt);
  }
  
  public JceStruct newInit()
  {
    return new v();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ay = paramJceInputStream.read(this.ay, 0, true);
    this.aM = paramJceInputStream.read(this.aM, 1, false);
    this.aN = ((ArrayList)paramJceInputStream.read(aU, 2, false));
    this.aO = ((ArrayList)paramJceInputStream.read(aV, 3, false));
    this.aP = paramJceInputStream.read(this.aP, 4, false);
    this.aQ = paramJceInputStream.read(this.aQ, 5, false);
    this.aR = paramJceInputStream.read(this.aR, 6, false);
    this.aS = paramJceInputStream.read(this.aS, 7, false);
    this.aT = paramJceInputStream.read(this.aT, 8, false);
    this.az = ((s)paramJceInputStream.read(aA, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ay, 0);
    if (this.aM != 0) {
      paramJceOutputStream.write(this.aM, 1);
    }
    if (this.aN != null) {
      paramJceOutputStream.write(this.aN, 2);
    }
    if (this.aO != null) {
      paramJceOutputStream.write(this.aO, 3);
    }
    if (this.aP != 0) {
      paramJceOutputStream.write(this.aP, 4);
    }
    paramJceOutputStream.write(this.aQ, 5);
    paramJceOutputStream.write(this.aR, 6);
    if (this.aS != 120) {
      paramJceOutputStream.write(this.aS, 7);
    }
    if (this.aT != 10) {
      paramJceOutputStream.write(this.aT, 8);
    }
    if (this.az != null) {
      paramJceOutputStream.write(this.az, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.v
 * JD-Core Version:    0.7.0.1
 */