package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class j
  extends JceStruct
{
  static ArrayList<Integer> aM = new ArrayList();
  static ArrayList<String> aN;
  public int aG = 0;
  public int aH = 0;
  public ArrayList<Integer> aI = null;
  public ArrayList<String> aJ = null;
  public int aK = 0;
  public int aL = 0;
  public int count = 1;
  
  static
  {
    aM.add(Integer.valueOf(0));
    aN = new ArrayList();
    aN.add("");
  }
  
  public JceStruct newInit()
  {
    return new j();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aG = paramJceInputStream.read(this.aG, 0, true);
    this.aH = paramJceInputStream.read(this.aH, 1, true);
    this.count = paramJceInputStream.read(this.count, 2, false);
    this.aI = ((ArrayList)paramJceInputStream.read(aM, 3, false));
    this.aJ = ((ArrayList)paramJceInputStream.read(aN, 4, false));
    this.aK = paramJceInputStream.read(this.aK, 5, false);
    this.aL = paramJceInputStream.read(this.aL, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.aG, 0);
    paramJceOutputStream.write(this.aH, 1);
    int i = this.count;
    if (i != 1) {
      paramJceOutputStream.write(i, 2);
    }
    ArrayList localArrayList = this.aI;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 3);
    }
    localArrayList = this.aJ;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 4);
    }
    i = this.aK;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
    i = this.aL;
    if (i != 0) {
      paramJceOutputStream.write(i, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.j
 * JD-Core Version:    0.7.0.1
 */