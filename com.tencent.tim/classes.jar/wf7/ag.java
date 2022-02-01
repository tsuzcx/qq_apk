package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ag
  extends JceStruct
{
  static ai cw = new ai();
  static al cx = new al();
  static ah cy = new ah();
  public ai ct = null;
  public al cu = null;
  public ah cv = null;
  
  public JceStruct newInit()
  {
    return new ag();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ct = ((ai)paramJceInputStream.read(cw, 0, false));
    this.cu = ((al)paramJceInputStream.read(cx, 1, false));
    this.cv = ((ah)paramJceInputStream.read(cy, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.ct != null) {
      paramJceOutputStream.write(this.ct, 0);
    }
    if (this.cu != null) {
      paramJceOutputStream.write(this.cu, 1);
    }
    if (this.cv != null) {
      paramJceOutputStream.write(this.cv, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ag
 * JD-Core Version:    0.7.0.1
 */