package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_delugc_rsp
  extends JceStruct
{
  public String msg = "";
  public int ret = 0;
  public String verifyurl = "";
  
  public operation_delugc_rsp() {}
  
  public operation_delugc_rsp(int paramInt, String paramString1, String paramString2)
  {
    this.ret = paramInt;
    this.msg = paramString1;
    this.verifyurl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.verifyurl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.verifyurl != null) {
      paramJceOutputStream.write(this.verifyurl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_delugc_rsp
 * JD-Core Version:    0.7.0.1
 */