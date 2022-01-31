package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class stChildInfo
  extends JceStruct
{
  static ArrayList bH = new ArrayList();
  public ArrayList vecChild = null;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), "");
    bH.add(localHashMap);
  }
  
  public JceStruct newInit()
  {
    return new stChildInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecChild = ((ArrayList)paramJceInputStream.read(bH, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecChild, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.stChildInfo
 * JD-Core Version:    0.7.0.1
 */