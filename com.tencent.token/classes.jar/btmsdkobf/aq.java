package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class aq
  extends JceStruct
{
  public String cS = "";
  public String cT = "";
  public int cZ = 0;
  public String da = "";
  
  public JceStruct newInit()
  {
    return new aq();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cZ = paramJceInputStream.read(this.cZ, 0, true);
    this.da = paramJceInputStream.readString(1, false);
    this.cS = paramJceInputStream.readString(2, false);
    this.cT = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cZ, 0);
    if (this.da != null) {
      paramJceOutputStream.write(this.da, 1);
    }
    if (this.cS != null) {
      paramJceOutputStream.write(this.cS, 2);
    }
    if (this.cT != null) {
      paramJceOutputStream.write(this.cT, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.aq
 * JD-Core Version:    0.7.0.1
 */