package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class k
  extends JceStruct
{
  static ArrayList<Integer> aM = new ArrayList();
  static ArrayList<String> aN;
  public int aG = 0;
  public int aH = 0;
  public ArrayList<Integer> aI = null;
  public ArrayList<String> aJ = null;
  public int count = 1;
  
  static
  {
    aM.add(Integer.valueOf(0));
    aN = new ArrayList();
    aN.add("");
  }
  
  public JceStruct newInit()
  {
    return new k();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aG = paramJceInputStream.read(this.aG, 0, true);
    this.aH = paramJceInputStream.read(this.aH, 1, true);
    this.count = paramJceInputStream.read(this.count, 2, false);
    this.aI = ((ArrayList)paramJceInputStream.read(aM, 3, false));
    this.aJ = ((ArrayList)paramJceInputStream.read(aN, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.aG, 0);
    paramJceOutputStream.write(this.aH, 1);
    if (this.count != 1) {
      paramJceOutputStream.write(this.count, 2);
    }
    if (this.aI != null) {
      paramJceOutputStream.write(this.aI, 3);
    }
    if (this.aJ != null) {
      paramJceOutputStream.write(this.aJ, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.k
 * JD-Core Version:    0.7.0.1
 */