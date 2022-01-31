package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetUserTailReq
  extends JceStruct
{
  public int iDiyTag = 0;
  public String strDiyMemo = "";
  public String strIdentifySqua = "";
  
  public SetUserTailReq() {}
  
  public SetUserTailReq(String paramString1, String paramString2, int paramInt)
  {
    this.strIdentifySqua = paramString1;
    this.strDiyMemo = paramString2;
    this.iDiyTag = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strIdentifySqua = paramJceInputStream.readString(0, false);
    this.strDiyMemo = paramJceInputStream.readString(1, false);
    this.iDiyTag = paramJceInputStream.read(this.iDiyTag, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strIdentifySqua != null) {
      paramJceOutputStream.write(this.strIdentifySqua, 0);
    }
    if (this.strDiyMemo != null) {
      paramJceOutputStream.write(this.strDiyMemo, 1);
    }
    paramJceOutputStream.write(this.iDiyTag, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_EXTRA.SetUserTailReq
 * JD-Core Version:    0.7.0.1
 */