package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetFiltPhotoListReq
  extends JceStruct
{
  public String albumid = "";
  public String attach_info = "";
  public long batchid;
  public long filt_richflag;
  public long uin;
  
  public GetFiltPhotoListReq() {}
  
  public GetFiltPhotoListReq(long paramLong1, String paramString1, long paramLong2, long paramLong3, String paramString2)
  {
    this.uin = paramLong1;
    this.albumid = paramString1;
    this.batchid = paramLong2;
    this.filt_richflag = paramLong3;
    this.attach_info = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.albumid = paramJceInputStream.readString(1, false);
    this.batchid = paramJceInputStream.read(this.batchid, 2, false);
    this.filt_richflag = paramJceInputStream.read(this.filt_richflag, 3, false);
    this.attach_info = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 1);
    }
    paramJceOutputStream.write(this.batchid, 2);
    paramJceOutputStream.write(this.filt_richflag, 3);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.GetFiltPhotoListReq
 * JD-Core Version:    0.7.0.1
 */