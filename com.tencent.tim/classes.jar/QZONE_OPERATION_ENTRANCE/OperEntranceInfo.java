package QZONE_OPERATION_ENTRANCE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class OperEntranceInfo
  extends JceStruct
{
  static Map<Integer, EntranceRes> cache_resTable = new HashMap();
  private static final long serialVersionUID = 0L;
  public Map<Integer, EntranceRes> resTable;
  
  static
  {
    EntranceRes localEntranceRes = new EntranceRes();
    cache_resTable.put(Integer.valueOf(0), localEntranceRes);
  }
  
  public OperEntranceInfo() {}
  
  public OperEntranceInfo(Map<Integer, EntranceRes> paramMap)
  {
    this.resTable = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.resTable = ((Map)paramJceInputStream.read(cache_resTable, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.resTable != null) {
      paramJceOutputStream.write(this.resTable, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QZONE_OPERATION_ENTRANCE.OperEntranceInfo
 * JD-Core Version:    0.7.0.1
 */