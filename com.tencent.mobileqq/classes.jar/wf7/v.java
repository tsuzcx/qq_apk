package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class v
  extends JceStruct
{
  public String bR = "";
  public int bW = 0;
  public String bX = "";
  
  public JceStruct newInit()
  {
    return new v();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bW = paramJceInputStream.read(this.bW, 0, true);
    this.bX = paramJceInputStream.readString(1, false);
    this.bR = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bW, 0);
    String str = this.bX;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.bR;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.v
 * JD-Core Version:    0.7.0.1
 */