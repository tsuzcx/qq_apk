package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ap
  extends JceStruct
{
  static an cY = new an();
  public an cU = null;
  public String cV = "";
  public String cW = "";
  public String cX = "";
  
  public final JceStruct newInit()
  {
    return new ap();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.cU = ((an)paramJceInputStream.read(cY, 0, true));
    this.cV = paramJceInputStream.readString(1, true);
    this.cW = paramJceInputStream.readString(2, false);
    this.cX = paramJceInputStream.readString(3, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cU, 0);
    paramJceOutputStream.write(this.cV, 1);
    String str = this.cW;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.cX;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ap
 * JD-Core Version:    0.7.0.1
 */