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
  
  public final JceStruct newInit()
  {
    return new aq();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.cZ = paramJceInputStream.read(this.cZ, 0, true);
    this.da = paramJceInputStream.readString(1, false);
    this.cS = paramJceInputStream.readString(2, false);
    this.cT = paramJceInputStream.readString(3, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cZ, 0);
    String str = this.da;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.cS;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.cT;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.aq
 * JD-Core Version:    0.7.0.1
 */