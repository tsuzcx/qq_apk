package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class e
  extends JceStruct
{
  public int C = 0;
  public String ah = "";
  public int ai = 0;
  public int aj = 0;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.C = paramJceInputStream.read(this.C, 0, false);
    this.ah = paramJceInputStream.readString(1, false);
    this.ai = paramJceInputStream.read(this.ai, 2, false);
    this.aj = paramJceInputStream.read(this.aj, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.C != 0) {
      paramJceOutputStream.write(this.C, 0);
    }
    if (this.ah != null) {
      paramJceOutputStream.write(this.ah, 1);
    }
    paramJceOutputStream.write(this.ai, 2);
    if (this.aj != 0) {
      paramJceOutputStream.write(this.aj, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.e
 * JD-Core Version:    0.7.0.1
 */