package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ao
  extends JceStruct
{
  public String cS = "";
  public String cT = "";
  
  public JceStruct newInit()
  {
    return new ao();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cS = paramJceInputStream.readString(0, true);
    this.cT = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cS, 0);
    if (this.cT != null) {
      paramJceOutputStream.write(this.cT, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ao
 * JD-Core Version:    0.7.0.1
 */