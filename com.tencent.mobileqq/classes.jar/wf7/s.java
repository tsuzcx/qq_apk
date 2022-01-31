package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s
  extends JceStruct
{
  public String aZ = "";
  
  public JceStruct newInit()
  {
    return new s();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aZ = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.aZ != null) {
      paramJceOutputStream.write(this.aZ, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.s
 * JD-Core Version:    0.7.0.1
 */