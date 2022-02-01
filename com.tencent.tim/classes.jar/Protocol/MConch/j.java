package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class j
  extends JceStruct
{
  public String bD = "";
  public String bE = "";
  public int bF = 0;
  public int bG = 0;
  public int bgColor = 0;
  public int type = 0;
  
  public JceStruct newInit()
  {
    return new j();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bD = paramJceInputStream.readString(0, false);
    this.bE = paramJceInputStream.readString(1, false);
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.bF = paramJceInputStream.read(this.bF, 3, false);
    this.bG = paramJceInputStream.read(this.bG, 4, false);
    this.bgColor = paramJceInputStream.read(this.bgColor, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bD != null) {
      paramJceOutputStream.write(this.bD, 0);
    }
    if (this.bE != null) {
      paramJceOutputStream.write(this.bE, 1);
    }
    if (this.type != 0) {
      paramJceOutputStream.write(this.type, 2);
    }
    if (this.bF != 0) {
      paramJceOutputStream.write(this.bF, 3);
    }
    if (this.bG != 0) {
      paramJceOutputStream.write(this.bG, 4);
    }
    if (this.bgColor != 0) {
      paramJceOutputStream.write(this.bgColor, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Protocol.MConch.j
 * JD-Core Version:    0.7.0.1
 */