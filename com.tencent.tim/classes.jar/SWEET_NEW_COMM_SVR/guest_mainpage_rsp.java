package SWEET_NEW_COMM_SVR;

import SWEET_NEW_BASE.sweet_rsp_comm;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class guest_mainpage_rsp
  extends JceStruct
{
  static sweet_rsp_comm cache_rsp_comm = new sweet_rsp_comm();
  public String jump_url = "";
  public sweet_rsp_comm rsp_comm;
  
  public guest_mainpage_rsp() {}
  
  public guest_mainpage_rsp(sweet_rsp_comm paramsweet_rsp_comm, String paramString)
  {
    this.rsp_comm = paramsweet_rsp_comm;
    this.jump_url = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rsp_comm = ((sweet_rsp_comm)paramJceInputStream.read(cache_rsp_comm, 0, true));
    this.jump_url = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.rsp_comm, 0);
    if (this.jump_url != null) {
      paramJceOutputStream.write(this.jump_url, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SWEET_NEW_COMM_SVR.guest_mainpage_rsp
 * JD-Core Version:    0.7.0.1
 */