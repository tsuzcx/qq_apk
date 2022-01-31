package qz_groupphoto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetIsNewReq
  extends JceStruct
{
  static int cache_type;
  static ArrayList cache_vec_gid;
  public int type = 0;
  public long uin = 0L;
  public ArrayList vec_gid = null;
  
  public GetIsNewReq() {}
  
  public GetIsNewReq(long paramLong, ArrayList paramArrayList, int paramInt)
  {
    this.uin = paramLong;
    this.vec_gid = paramArrayList;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    if (cache_vec_gid == null)
    {
      cache_vec_gid = new ArrayList();
      cache_vec_gid.add(Long.valueOf(0L));
    }
    this.vec_gid = ((ArrayList)paramJceInputStream.read(cache_vec_gid, 1, false));
    this.type = paramJceInputStream.read(this.type, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.vec_gid != null) {
      paramJceOutputStream.write(this.vec_gid, 1);
    }
    paramJceOutputStream.write(this.type, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     qz_groupphoto.GetIsNewReq
 * JD-Core Version:    0.7.0.1
 */