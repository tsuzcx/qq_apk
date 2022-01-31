package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetUserTailRsp
  extends JceStruct
{
  public String strTailName = "";
  public String strTailNoIcon = "";
  
  public SetUserTailRsp() {}
  
  public SetUserTailRsp(String paramString1, String paramString2)
  {
    this.strTailName = paramString1;
    this.strTailNoIcon = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strTailName = paramJceInputStream.readString(0, true);
    this.strTailNoIcon = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strTailName, 0);
    if (this.strTailNoIcon != null) {
      paramJceOutputStream.write(this.strTailNoIcon, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.SetUserTailRsp
 * JD-Core Version:    0.7.0.1
 */