package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stCleanFile
  extends JceStruct
{
  static ArrayList<stCleanResp> bI = new ArrayList();
  public ArrayList<stCleanResp> vecResp = null;
  
  static
  {
    stCleanResp localstCleanResp = new stCleanResp();
    bI.add(localstCleanResp);
  }
  
  public JceStruct newInit()
  {
    return new stCleanFile();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecResp = ((ArrayList)paramJceInputStream.read(bI, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecResp, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.stCleanFile
 * JD-Core Version:    0.7.0.1
 */