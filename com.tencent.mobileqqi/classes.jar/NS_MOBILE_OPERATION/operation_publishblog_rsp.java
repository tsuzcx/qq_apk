package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_publishblog_rsp
  extends JceStruct
{
  public String bid = "";
  public String msg = "";
  public int ret = 0;
  public String verifyurl = "";
  
  public operation_publishblog_rsp() {}
  
  public operation_publishblog_rsp(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.ret = paramInt;
    this.verifyurl = paramString1;
    this.bid = paramString2;
    this.msg = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.verifyurl = paramJceInputStream.readString(1, false);
    this.bid = paramJceInputStream.readString(2, false);
    this.msg = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.verifyurl != null) {
      paramJceOutputStream.write(this.verifyurl, 1);
    }
    if (this.bid != null) {
      paramJceOutputStream.write(this.bid, 2);
    }
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_publishblog_rsp
 * JD-Core Version:    0.7.0.1
 */