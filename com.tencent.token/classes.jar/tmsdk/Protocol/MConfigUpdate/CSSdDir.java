package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CSSdDir
  extends JceStruct
{
  static ArrayList bw = new ArrayList();
  public ArrayList vecSdDir = null;
  
  static
  {
    bw.add("");
  }
  
  public JceStruct newInit()
  {
    return new CSSdDir();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecSdDir = ((ArrayList)paramJceInputStream.read(bw, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecSdDir, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.CSSdDir
 * JD-Core Version:    0.7.0.1
 */