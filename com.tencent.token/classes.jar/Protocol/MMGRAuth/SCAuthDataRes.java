package Protocol.MMGRAuth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SCAuthDataRes
  extends JceStruct
{
  public int ret = 0;
  
  public JceStruct newInit()
  {
    return new SCAuthDataRes();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MMGRAuth.SCAuthDataRes
 * JD-Core Version:    0.7.0.1
 */