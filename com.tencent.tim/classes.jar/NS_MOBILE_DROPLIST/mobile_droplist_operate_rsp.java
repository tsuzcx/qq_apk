package NS_MOBILE_DROPLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_droplist_operate_rsp
  extends JceStruct
{
  public int retCode;
  public String retMsg = "";
  
  public mobile_droplist_operate_rsp() {}
  
  public mobile_droplist_operate_rsp(int paramInt, String paramString)
  {
    this.retCode = paramInt;
    this.retMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retCode = paramJceInputStream.read(this.retCode, 0, false);
    this.retMsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retCode, 0);
    if (this.retMsg != null) {
      paramJceOutputStream.write(this.retMsg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_DROPLIST.mobile_droplist_operate_rsp
 * JD-Core Version:    0.7.0.1
 */