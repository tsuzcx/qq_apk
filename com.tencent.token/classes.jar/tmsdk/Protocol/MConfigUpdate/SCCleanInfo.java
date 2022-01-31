package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SCCleanInfo
  extends JceStruct
{
  static ArrayList bz = new ArrayList();
  public ArrayList vecClean = null;
  
  static
  {
    stCleanResp localstCleanResp = new stCleanResp();
    bz.add(localstCleanResp);
  }
  
  public JceStruct newInit()
  {
    return new SCCleanInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecClean = ((ArrayList)paramJceInputStream.read(bz, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecClean, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.SCCleanInfo
 * JD-Core Version:    0.7.0.1
 */