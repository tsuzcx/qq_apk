package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class JoinShareAlbumReq
  extends JceStruct
{
  static AllowJoinShareAlbum cache_allow_data = new AllowJoinShareAlbum();
  static ApplyJoinShareAlbum cache_apply_data;
  static int cache_mode = 0;
  public AllowJoinShareAlbum allow_data;
  public ApplyJoinShareAlbum apply_data;
  public int mode = 0;
  public long op_uin;
  
  static
  {
    cache_apply_data = new ApplyJoinShareAlbum();
  }
  
  public JoinShareAlbumReq() {}
  
  public JoinShareAlbumReq(long paramLong, int paramInt, ApplyJoinShareAlbum paramApplyJoinShareAlbum, AllowJoinShareAlbum paramAllowJoinShareAlbum)
  {
    this.op_uin = paramLong;
    this.mode = paramInt;
    this.apply_data = paramApplyJoinShareAlbum;
    this.allow_data = paramAllowJoinShareAlbum;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.op_uin = paramJceInputStream.read(this.op_uin, 0, false);
    this.mode = paramJceInputStream.read(this.mode, 1, false);
    this.apply_data = ((ApplyJoinShareAlbum)paramJceInputStream.read(cache_apply_data, 2, false));
    this.allow_data = ((AllowJoinShareAlbum)paramJceInputStream.read(cache_allow_data, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.op_uin, 0);
    paramJceOutputStream.write(this.mode, 1);
    if (this.apply_data != null) {
      paramJceOutputStream.write(this.apply_data, 2);
    }
    if (this.allow_data != null) {
      paramJceOutputStream.write(this.allow_data, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.JoinShareAlbumReq
 * JD-Core Version:    0.7.0.1
 */