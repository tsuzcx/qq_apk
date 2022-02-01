package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class aa
  extends JceStruct
{
  public String aX = "";
  
  public JceStruct newInit()
  {
    return new aa();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.aX = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.aX, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.aa
 * JD-Core Version:    0.7.0.1
 */