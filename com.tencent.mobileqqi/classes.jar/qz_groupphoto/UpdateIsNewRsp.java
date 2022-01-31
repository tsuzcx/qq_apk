package qz_groupphoto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UpdateIsNewRsp
  extends JceStruct
{
  static ArrayList cache_fail_gid;
  public ArrayList fail_gid = null;
  public int res = 0;
  
  public UpdateIsNewRsp() {}
  
  public UpdateIsNewRsp(int paramInt, ArrayList paramArrayList)
  {
    this.res = paramInt;
    this.fail_gid = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.res = paramJceInputStream.read(this.res, 0, true);
    if (cache_fail_gid == null)
    {
      cache_fail_gid = new ArrayList();
      cache_fail_gid.add(Long.valueOf(0L));
    }
    this.fail_gid = ((ArrayList)paramJceInputStream.read(cache_fail_gid, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.res, 0);
    if (this.fail_gid != null) {
      paramJceOutputStream.write(this.fail_gid, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     qz_groupphoto.UpdateIsNewRsp
 * JD-Core Version:    0.7.0.1
 */