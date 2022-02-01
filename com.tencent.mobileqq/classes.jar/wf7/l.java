package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class l
  extends JceStruct
{
  public int aO = 0;
  
  public JceStruct newInit()
  {
    return new l();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aO = paramJceInputStream.read(this.aO, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.aO, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.l
 * JD-Core Version:    0.7.0.1
 */