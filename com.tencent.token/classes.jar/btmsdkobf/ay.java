package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ay
  extends JceStruct
{
  public String dr = "";
  
  public final JceStruct newInit()
  {
    return new ay();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.dr = paramJceInputStream.readString(0, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dr, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ay
 * JD-Core Version:    0.7.0.1
 */