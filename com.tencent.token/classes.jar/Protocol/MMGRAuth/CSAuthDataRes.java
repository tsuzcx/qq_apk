package Protocol.MMGRAuth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CSAuthDataRes
  extends JceStruct
{
  static ArrayList a = new ArrayList();
  public ArrayList resList = null;
  
  static
  {
    AuthDataRes localAuthDataRes = new AuthDataRes();
    a.add(localAuthDataRes);
  }
  
  public JceStruct newInit()
  {
    return new CSAuthDataRes();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.resList = ((ArrayList)paramJceInputStream.read(a, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.resList != null) {
      paramJceOutputStream.write(this.resList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MMGRAuth.CSAuthDataRes
 * JD-Core Version:    0.7.0.1
 */