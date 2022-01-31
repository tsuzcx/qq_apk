package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b
  extends JceStruct
{
  public int n = 0;
  
  public JceStruct newInit()
  {
    return new b();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.n = paramJceInputStream.read(this.n, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.n, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.b
 * JD-Core Version:    0.7.0.1
 */