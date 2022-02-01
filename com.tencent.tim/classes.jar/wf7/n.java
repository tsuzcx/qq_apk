package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class n
  extends JceStruct
{
  public int aS = 2;
  public int aW = 0;
  public String aX = "";
  public String aY = "";
  public String aZ = "";
  public int ba = 0;
  public int bb = 0;
  public long bc = 0L;
  public int bd = 0;
  public String be = "";
  
  public JceStruct newInit()
  {
    return new n();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aS = paramJceInputStream.read(this.aS, 0, true);
    this.aW = paramJceInputStream.read(this.aW, 1, true);
    this.aX = paramJceInputStream.readString(2, false);
    this.aY = paramJceInputStream.readString(3, false);
    this.aZ = paramJceInputStream.readString(4, false);
    this.ba = paramJceInputStream.read(this.ba, 5, false);
    this.bb = paramJceInputStream.read(this.bb, 6, false);
    this.bc = paramJceInputStream.read(this.bc, 7, false);
    this.bd = paramJceInputStream.read(this.bd, 8, false);
    this.be = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.aS, 0);
    paramJceOutputStream.write(this.aW, 1);
    if (this.aX != null) {
      paramJceOutputStream.write(this.aX, 2);
    }
    if (this.aY != null) {
      paramJceOutputStream.write(this.aY, 3);
    }
    if (this.aZ != null) {
      paramJceOutputStream.write(this.aZ, 4);
    }
    if (this.ba != 0) {
      paramJceOutputStream.write(this.ba, 5);
    }
    if (this.bb != 0) {
      paramJceOutputStream.write(this.bb, 6);
    }
    if (this.bc != 0L) {
      paramJceOutputStream.write(this.bc, 7);
    }
    if (this.bd != 0) {
      paramJceOutputStream.write(this.bd, 8);
    }
    if (this.be != null) {
      paramJceOutputStream.write(this.be, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.n
 * JD-Core Version:    0.7.0.1
 */