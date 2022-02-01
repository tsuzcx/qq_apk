package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class q
  extends JceStruct
  implements Cloneable
{
  static Map<Integer, String> bO = new HashMap();
  public Map<Integer, String> bN = null;
  
  static
  {
    bO.put(Integer.valueOf(0), "");
  }
  
  public q() {}
  
  public q(Map<Integer, String> paramMap)
  {
    this.bN = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bN = ((Map)paramJceInputStream.read(bO, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bN, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.q
 * JD-Core Version:    0.7.0.1
 */