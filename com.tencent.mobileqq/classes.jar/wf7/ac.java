package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ac
  extends JceStruct
{
  public String co = "";
  
  public JceStruct newInit()
  {
    return new ac();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.co = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.co, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.ac
 * JD-Core Version:    0.7.0.1
 */