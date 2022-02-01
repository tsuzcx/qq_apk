package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_addfriend_type_rsp
  extends JceStruct
{
  public String errorstring = "";
  public int ret;
  
  public mobile_sub_addfriend_type_rsp() {}
  
  public mobile_sub_addfriend_type_rsp(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.errorstring = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errorstring = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errorstring != null) {
      paramJceOutputStream.write(this.errorstring, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_addfriend_type_rsp
 * JD-Core Version:    0.7.0.1
 */