package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class z
  extends JceStruct
{
  public int cn = 0;
  
  public JceStruct newInit()
  {
    return new z();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cn = paramJceInputStream.read(this.cn, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cn, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.z
 * JD-Core Version:    0.7.0.1
 */