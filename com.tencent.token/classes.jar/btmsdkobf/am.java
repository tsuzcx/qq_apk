package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class am
  extends JceStruct
{
  public String sessionId = "";
  
  public JceStruct newInit()
  {
    return new am();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sessionId = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sessionId != null) {
      paramJceOutputStream.write(this.sessionId, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.am
 * JD-Core Version:    0.7.0.1
 */