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
    int i = this.C;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    String str = this.ah;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.ai, 2);
    i = this.aj;
    if (i != 0) {
      paramJceOutputStream.write(i, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.e
 * JD-Core Version:    0.7.0.1
 */