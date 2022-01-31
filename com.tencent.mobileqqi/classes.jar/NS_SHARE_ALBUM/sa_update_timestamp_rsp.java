package NS_SHARE_ALBUM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sa_update_timestamp_rsp
  extends JceStruct
{
  public String errmsg = "";
  public int ret = 0;
  
  public sa_update_timestamp_rsp() {}
  
  public sa_update_timestamp_rsp(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.errmsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_SHARE_ALBUM.sa_update_timestamp_rsp
 * JD-Core Version:    0.7.0.1
 */