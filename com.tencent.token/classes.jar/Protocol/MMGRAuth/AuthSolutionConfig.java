package Protocol.MMGRAuth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AuthSolutionConfig
  extends JceStruct
{
  static ArrayList<String> a = new ArrayList();
  public ArrayList<String> authSolutionConfigList = null;
  
  static
  {
    a.add("");
  }
  
  public JceStruct newInit()
  {
    return new AuthSolutionConfig();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.authSolutionConfigList = ((ArrayList)paramJceInputStream.read(a, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.authSolutionConfigList != null) {
      paramJceOutputStream.write(this.authSolutionConfigList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MMGRAuth.AuthSolutionConfig
 * JD-Core Version:    0.7.0.1
 */