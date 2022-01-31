package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class stCleanResp
  extends JceStruct
{
  static ArrayList bJ = new ArrayList();
  static byte[] bK;
  public byte[] vecChild = null;
  public ArrayList vecRoot = null;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), "");
    bJ.add(localHashMap);
    bK = (byte[])new byte[1];
    ((byte[])bK)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new stCleanResp();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecRoot = ((ArrayList)paramJceInputStream.read(bJ, 0, true));
    this.vecChild = ((byte[])paramJceInputStream.read(bK, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecRoot, 0);
    if (this.vecChild != null) {
      paramJceOutputStream.write(this.vecChild, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.stCleanResp
 * JD-Core Version:    0.7.0.1
 */