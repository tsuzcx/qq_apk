package qz_groupphoto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IsNew
  extends JceStruct
{
  public long gid_time = 0L;
  public boolean is_new = true;
  public long new_cnt = 0L;
  public long uin_time = 0L;
  
  public IsNew() {}
  
  public IsNew(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    this.is_new = paramBoolean;
    this.new_cnt = paramLong1;
    this.uin_time = paramLong2;
    this.gid_time = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.is_new = paramJceInputStream.read(this.is_new, 0, true);
    this.new_cnt = paramJceInputStream.read(this.new_cnt, 1, true);
    this.uin_time = paramJceInputStream.read(this.uin_time, 2, false);
    this.gid_time = paramJceInputStream.read(this.gid_time, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.is_new, 0);
    paramJceOutputStream.write(this.new_cnt, 1);
    paramJceOutputStream.write(this.uin_time, 2);
    paramJceOutputStream.write(this.gid_time, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     qz_groupphoto.IsNew
 * JD-Core Version:    0.7.0.1
 */