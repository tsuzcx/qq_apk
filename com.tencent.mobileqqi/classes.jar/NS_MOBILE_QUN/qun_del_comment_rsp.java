package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class qun_del_comment_rsp
  extends JceStruct
{
  public int iRet = 0;
  public String strErrMsg = "";
  
  public qun_del_comment_rsp() {}
  
  public qun_del_comment_rsp(int paramInt, String paramString)
  {
    this.iRet = paramInt;
    this.strErrMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, true);
    this.strErrMsg = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    paramJceOutputStream.write(this.strErrMsg, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_del_comment_rsp
 * JD-Core Version:    0.7.0.1
 */