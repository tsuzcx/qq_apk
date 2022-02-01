package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class y
  extends JceStruct
{
  static n cl = new n();
  static ArrayList<x> cm = new ArrayList();
  public int bZ = 0;
  public int ca = 0;
  public int ci = 1;
  public n cj = null;
  public ArrayList<x> ck = null;
  
  static
  {
    x localx = new x();
    cm.add(localx);
  }
  
  public JceStruct newInit()
  {
    return new y();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bZ = paramJceInputStream.read(this.bZ, 0, false);
    this.ca = paramJceInputStream.read(this.ca, 1, false);
    this.ci = paramJceInputStream.read(this.ci, 2, false);
    this.cj = ((n)paramJceInputStream.read(cl, 3, false));
    this.ck = ((ArrayList)paramJceInputStream.read(cm, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.bZ;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    i = this.ca;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    i = this.ci;
    if (i != 1) {
      paramJceOutputStream.write(i, 2);
    }
    Object localObject = this.cj;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.ck;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.y
 * JD-Core Version:    0.7.0.1
 */