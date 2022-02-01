package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ao
  extends JceStruct
{
  public String cS = "";
  public String cT = "";
  
  public final JceStruct newInit()
  {
    return new ao();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.cS = paramJceInputStream.readString(0, true);
    this.cT = paramJceInputStream.readString(1, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cS, 0);
    String str = this.cT;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ao
 * JD-Core Version:    0.7.0.1
 */