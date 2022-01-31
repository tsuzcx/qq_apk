package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetImgInfoFromSOSOResp
  extends JceStruct
{
  static byte[] cache_vecRespBody;
  public byte[] vecRespBody = null;
  
  public GetImgInfoFromSOSOResp() {}
  
  public GetImgInfoFromSOSOResp(byte[] paramArrayOfByte)
  {
    this.vecRespBody = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecRespBody == null)
    {
      cache_vecRespBody = (byte[])new byte[1];
      ((byte[])cache_vecRespBody)[0] = 0;
    }
    this.vecRespBody = ((byte[])paramJceInputStream.read(cache_vecRespBody, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecRespBody, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     KQQ.GetImgInfoFromSOSOResp
 * JD-Core Version:    0.7.0.1
 */