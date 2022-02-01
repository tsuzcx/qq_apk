package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ad
  extends JceStruct
{
  public long bY = 0L;
  
  public JceStruct newInit()
  {
    return new ad();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bY = paramJceInputStream.read(this.bY, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bY != 0L) {
      paramJceOutputStream.write(this.bY, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ad
 * JD-Core Version:    0.7.0.1
 */