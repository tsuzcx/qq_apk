package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RspHeader
  extends JceStruct
{
  static int cache_eResult;
  static int cache_eUinType;
  public int eResult;
  public int eUinType;
  public short shVersion = 2;
  public String strCookie = "";
  public String strErrMsg = "";
  public String strUin = "";
  
  public RspHeader() {}
  
  public RspHeader(short paramShort, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    this.shVersion = paramShort;
    this.eUinType = paramInt1;
    this.strUin = paramString1;
    this.strCookie = paramString2;
    this.eResult = paramInt2;
    this.strErrMsg = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.eUinType = paramJceInputStream.read(this.eUinType, 1, true);
    this.strUin = paramJceInputStream.readString(2, true);
    this.strCookie = paramJceInputStream.readString(3, true);
    this.eResult = paramJceInputStream.read(this.eResult, 4, true);
    this.strErrMsg = paramJceInputStream.readString(5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.eUinType, 1);
    paramJceOutputStream.write(this.strUin, 2);
    paramJceOutputStream.write(this.strCookie, 3);
    paramJceOutputStream.write(this.eResult, 4);
    paramJceOutputStream.write(this.strErrMsg, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     LBSAddrProtocol.RspHeader
 * JD-Core Version:    0.7.0.1
 */