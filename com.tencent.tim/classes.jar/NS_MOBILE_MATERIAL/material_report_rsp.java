package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class material_report_rsp
  extends JceStruct
{
  public int iCode;
  public String strErrMsg = "";
  
  public material_report_rsp() {}
  
  public material_report_rsp(int paramInt, String paramString)
  {
    this.iCode = paramInt;
    this.strErrMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, true);
    this.strErrMsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    if (this.strErrMsg != null) {
      paramJceOutputStream.write(this.strErrMsg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_report_rsp
 * JD-Core Version:    0.7.0.1
 */