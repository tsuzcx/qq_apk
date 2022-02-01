package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ak
  extends JceStruct
  implements Comparable<ak>
{
  public int ai = 0;
  public int cB = 0;
  public String cL = "";
  public String cM = "";
  public String cN = "";
  public String cO = "";
  public int cP = 0;
  public String cQ = "";
  public int cR = 0;
  public int cS = 0;
  public int cT = 0;
  public int cU = 0;
  public int cV = 0;
  public int cW = 0;
  public String cX = "";
  public int category = 0;
  public String name = "";
  public String version = "";
  
  public int a(ak paramak)
  {
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = JceUtil.compareTo(this.cL, paramak.cL);
    arrayOfInt[1] = JceUtil.compareTo(this.cM, paramak.cM);
    arrayOfInt[2] = JceUtil.compareTo(this.version, paramak.version);
    arrayOfInt[3] = JceUtil.compareTo(this.cN, paramak.cN);
    int i = 0;
    while (i < arrayOfInt.length)
    {
      if (arrayOfInt[i] != 0) {
        return arrayOfInt[i];
      }
      i += 1;
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cL = paramJceInputStream.readString(0, true);
    this.cM = paramJceInputStream.readString(1, true);
    this.version = paramJceInputStream.readString(2, true);
    this.cN = paramJceInputStream.readString(3, false);
    this.cO = paramJceInputStream.readString(4, false);
    this.cP = paramJceInputStream.read(this.cP, 5, false);
    this.name = paramJceInputStream.readString(6, false);
    this.cB = paramJceInputStream.read(this.cB, 7, false);
    this.cQ = paramJceInputStream.readString(8, false);
    this.cR = paramJceInputStream.read(this.cR, 9, false);
    this.cS = paramJceInputStream.read(this.cS, 10, false);
    this.category = paramJceInputStream.read(this.category, 11, false);
    this.cT = paramJceInputStream.read(this.cT, 12, false);
    this.ai = paramJceInputStream.read(this.ai, 13, false);
    this.cU = paramJceInputStream.read(this.cU, 14, false);
    this.cV = paramJceInputStream.read(this.cV, 15, false);
    this.cW = paramJceInputStream.read(this.cW, 16, false);
    this.cX = paramJceInputStream.readString(17, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cL, 0);
    paramJceOutputStream.write(this.cM, 1);
    paramJceOutputStream.write(this.version, 2);
    String str = this.cN;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.cO;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.cP, 5);
    str = this.name;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    paramJceOutputStream.write(this.cB, 7);
    str = this.cQ;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    paramJceOutputStream.write(this.cR, 9);
    paramJceOutputStream.write(this.cS, 10);
    paramJceOutputStream.write(this.category, 11);
    paramJceOutputStream.write(this.cT, 12);
    paramJceOutputStream.write(this.ai, 13);
    paramJceOutputStream.write(this.cU, 14);
    paramJceOutputStream.write(this.cV, 15);
    paramJceOutputStream.write(this.cW, 16);
    str = this.cX;
    if (str != null) {
      paramJceOutputStream.write(str, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.ak
 * JD-Core Version:    0.7.0.1
 */