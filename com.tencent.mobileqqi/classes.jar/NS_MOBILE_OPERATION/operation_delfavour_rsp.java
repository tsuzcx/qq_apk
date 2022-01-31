package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_delfavour_rsp
  extends JceStruct
{
  public String error_msg = "";
  public int ret = 0;
  
  public operation_delfavour_rsp() {}
  
  public operation_delfavour_rsp(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.error_msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.error_msg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.error_msg != null) {
      paramJceOutputStream.write(this.error_msg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_delfavour_rsp
 * JD-Core Version:    0.7.0.1
 */