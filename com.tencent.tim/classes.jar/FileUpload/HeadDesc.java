package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class HeadDesc
  extends JceStruct
{
  public long portrait_type = 0L;
  public long skip_auth = 0L;
  public long uc_platform_qzone_subid = 0L;
  public String uid = "";
  
  public HeadDesc() {}
  
  public HeadDesc(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    this.portrait_type = paramLong1;
    this.uc_platform_qzone_subid = paramLong2;
    this.uid = paramString;
    this.skip_auth = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.portrait_type = paramJceInputStream.read(this.portrait_type, 0, true);
    this.uc_platform_qzone_subid = paramJceInputStream.read(this.uc_platform_qzone_subid, 1, true);
    this.uid = paramJceInputStream.readString(2, false);
    this.skip_auth = paramJceInputStream.read(this.skip_auth, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.portrait_type, 0);
    paramJceOutputStream.write(this.uc_platform_qzone_subid, 1);
    if (this.uid != null) {
      paramJceOutputStream.write(this.uid, 2);
    }
    paramJceOutputStream.write(this.skip_auth, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     FileUpload.HeadDesc
 * JD-Core Version:    0.7.0.1
 */