package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class aw
  extends JceStruct
{
  public String guid = "";
  
  public JceStruct newInit()
  {
    return new aw();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.guid = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.guid, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.aw
 * JD-Core Version:    0.7.0.1
 */