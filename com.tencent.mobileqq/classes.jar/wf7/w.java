package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class w
  extends JceStruct
{
  public long bY = 0L;
  
  public JceStruct newInit()
  {
    return new w();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bY = paramJceInputStream.read(this.bY, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    long l = this.bY;
    if (l != 0L) {
      paramJceOutputStream.write(l, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.w
 * JD-Core Version:    0.7.0.1
 */