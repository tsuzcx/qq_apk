package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class BatchGetFacadeReq
  extends JceStruct
{
  static Map<Long, GetFacadeReqExt> cache_ext;
  static ArrayList<Long> cache_uins = new ArrayList();
  public Map<Long, GetFacadeReqExt> ext;
  public long loginUin;
  public int needElementInfo;
  public String qua = "";
  public ArrayList<Long> uins;
  
  static
  {
    cache_uins.add(Long.valueOf(0L));
    cache_ext = new HashMap();
    GetFacadeReqExt localGetFacadeReqExt = new GetFacadeReqExt();
    cache_ext.put(Long.valueOf(0L), localGetFacadeReqExt);
  }
  
  public BatchGetFacadeReq() {}
  
  public BatchGetFacadeReq(ArrayList<Long> paramArrayList, String paramString, int paramInt, Map<Long, GetFacadeReqExt> paramMap, long paramLong)
  {
    this.uins = paramArrayList;
    this.qua = paramString;
    this.needElementInfo = paramInt;
    this.ext = paramMap;
    this.loginUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uins = ((ArrayList)paramJceInputStream.read(cache_uins, 0, false));
    this.qua = paramJceInputStream.readString(1, false);
    this.needElementInfo = paramJceInputStream.read(this.needElementInfo, 2, false);
    this.ext = ((Map)paramJceInputStream.read(cache_ext, 3, false));
    this.loginUin = paramJceInputStream.read(this.loginUin, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.uins != null) {
      paramJceOutputStream.write(this.uins, 0);
    }
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 1);
    }
    paramJceOutputStream.write(this.needElementInfo, 2);
    if (this.ext != null) {
      paramJceOutputStream.write(this.ext, 3);
    }
    paramJceOutputStream.write(this.loginUin, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     FACADE_DIY.BatchGetFacadeReq
 * JD-Core Version:    0.7.0.1
 */