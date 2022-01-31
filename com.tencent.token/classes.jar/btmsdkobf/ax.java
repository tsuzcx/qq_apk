package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ax
  extends JceStruct
{
  public String dr = "";
  
  public JceStruct newInit()
  {
    return new ax();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dr = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dr, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ax
 * JD-Core Version:    0.7.0.1
 */