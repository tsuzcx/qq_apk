package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

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
    int i = this.aM;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    Object localObject = this.aN;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.aO;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    i = this.aP;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
    paramJceOutputStream.write(this.aQ, 5);
    paramJceOutputStream.write(this.aR, 6);
    i = this.aS;
    if (i != 120) {
      paramJceOutputStream.write(i, 7);
    }
    i = this.aT;
    if (i != 10) {
      paramJceOutputStream.write(i, 8);
    }
    localObject = this.az;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.v
 * JD-Core Version:    0.7.0.1
 */