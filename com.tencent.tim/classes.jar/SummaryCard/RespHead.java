package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespHead
  extends JceStruct
{
  static byte[] cache_vCookies;
  public int iResult;
  public int iVersion;
  public String strErrorMsg = "";
  public byte[] vCookies;
  
  public RespHead() {}
  
  public RespHead(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    this.iVersion = paramInt1;
    this.iResult = paramInt2;
    this.strErrorMsg = paramString;
    this.vCookies = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iVersion = paramJceInputStream.read(this.iVersion, 0, true);
    this.iResult = paramJceInputStream.read(this.iResult, 1, true);
    this.strErrorMsg = paramJceInputStream.readString(2, true);
    if (cache_vCookies == null)
    {
      cache_vCookies = (byte[])new byte[1];
      ((byte[])cache_vCookies)[0] = 0;
    }
    this.vCookies = ((byte[])paramJceInputStream.read(cache_vCookies, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iVersion, 0);
    paramJceOutputStream.write(this.iResult, 1);
    paramJceOutputStream.write(this.strErrorMsg, 2);
    if (this.vCookies != null) {
      paramJceOutputStream.write(this.vCookies, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCard.RespHead
 * JD-Core Version:    0.7.0.1
 */