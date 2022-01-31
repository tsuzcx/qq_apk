package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class t
  extends JceStruct
{
  public String bR = "";
  
  public JceStruct newInit()
  {
    return new t();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bR = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bR, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.t
 * JD-Core Version:    0.7.0.1
 */