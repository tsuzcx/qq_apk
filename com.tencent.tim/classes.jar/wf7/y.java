package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

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
    if (this.bZ != 0) {
      paramJceOutputStream.write(this.bZ, 0);
    }
    if (this.ca != 0) {
      paramJceOutputStream.write(this.ca, 1);
    }
    if (this.ci != 1) {
      paramJceOutputStream.write(this.ci, 2);
    }
    if (this.cj != null) {
      paramJceOutputStream.write(this.cj, 3);
    }
    if (this.ck != null) {
      paramJceOutputStream.write(this.ck, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.y
 * JD-Core Version:    0.7.0.1
 */