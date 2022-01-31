package GroupPic;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqRedirect
  extends JceStruct
{
  static ReqHeader cache_stReqHeader;
  static byte[] cache_vFileMd5;
  static byte[] cache_vSig;
  public int iFileLen = 0;
  public short shApplicationType = 0;
  public ReqHeader stReqHeader = null;
  public String strFileName = "";
  public byte[] vFileMd5 = null;
  public byte[] vSig = null;
  
  public ReqRedirect() {}
  
  public ReqRedirect(ReqHeader paramReqHeader, short paramShort, byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2, String paramString)
  {
    this.stReqHeader = paramReqHeader;
    this.shApplicationType = paramShort;
    this.vSig = paramArrayOfByte1;
    this.iFileLen = paramInt;
    this.vFileMd5 = paramArrayOfByte2;
    this.strFileName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stReqHeader == null) {
      cache_stReqHeader = new ReqHeader();
    }
    this.stReqHeader = ((ReqHeader)paramJceInputStream.read(cache_stReqHeader, 0, true));
    this.shApplicationType = paramJceInputStream.read(this.shApplicationType, 1, true);
    if (cache_vSig == null)
    {
      cache_vSig = (byte[])new byte[1];
      ((byte[])cache_vSig)[0] = 0;
    }
    this.vSig = ((byte[])paramJceInputStream.read(cache_vSig, 2, true));
    this.iFileLen = paramJceInputStream.read(this.iFileLen, 3, true);
    if (cache_vFileMd5 == null)
    {
      cache_vFileMd5 = (byte[])new byte[1];
      ((byte[])cache_vFileMd5)[0] = 0;
    }
    this.vFileMd5 = ((byte[])paramJceInputStream.read(cache_vFileMd5, 4, true));
    this.strFileName = paramJceInputStream.readString(5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stReqHeader, 0);
    paramJceOutputStream.write(this.shApplicationType, 1);
    paramJceOutputStream.write(this.vSig, 2);
    paramJceOutputStream.write(this.iFileLen, 3);
    paramJceOutputStream.write(this.vFileMd5, 4);
    paramJceOutputStream.write(this.strFileName, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     GroupPic.ReqRedirect
 * JD-Core Version:    0.7.0.1
 */