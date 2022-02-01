package SWEET_NEW_BASE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class sweet_rsp_comm
  extends JceStruct
{
  public String errmsg = "";
  public int retcode;
  
  public sweet_rsp_comm() {}
  
  public sweet_rsp_comm(int paramInt, String paramString)
  {
    this.retcode = paramInt;
    this.errmsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retcode = paramJceInputStream.read(this.retcode, 0, true);
    this.errmsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retcode, 0);
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SWEET_NEW_BASE.sweet_rsp_comm
 * JD-Core Version:    0.7.0.1
 */