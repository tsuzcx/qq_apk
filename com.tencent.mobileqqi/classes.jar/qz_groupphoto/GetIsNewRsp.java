package qz_groupphoto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class GetIsNewRsp
  extends JceStruct
{
  static Map cache_map_newhot;
  public boolean is_new = true;
  public Map map_newhot = null;
  public long new_cnt = 0L;
  public long uin = 0L;
  
  public GetIsNewRsp() {}
  
  public GetIsNewRsp(long paramLong1, Map paramMap, boolean paramBoolean, long paramLong2)
  {
    this.uin = paramLong1;
    this.map_newhot = paramMap;
    this.is_new = paramBoolean;
    this.new_cnt = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    if (cache_map_newhot == null)
    {
      cache_map_newhot = new HashMap();
      IsNew localIsNew = new IsNew();
      cache_map_newhot.put(Long.valueOf(0L), localIsNew);
    }
    this.map_newhot = ((Map)paramJceInputStream.read(cache_map_newhot, 1, false));
    this.is_new = paramJceInputStream.read(this.is_new, 2, false);
    this.new_cnt = paramJceInputStream.read(this.new_cnt, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.map_newhot != null) {
      paramJceOutputStream.write(this.map_newhot, 1);
    }
    paramJceOutputStream.write(this.is_new, 2);
    paramJceOutputStream.write(this.new_cnt, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     qz_groupphoto.GetIsNewRsp
 * JD-Core Version:    0.7.0.1
 */