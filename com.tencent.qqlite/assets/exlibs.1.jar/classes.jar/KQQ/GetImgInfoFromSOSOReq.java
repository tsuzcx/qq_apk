package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetImgInfoFromSOSOReq
  extends JceStruct
{
  static byte[] cache_vecReqBody;
  public byte[] vecReqBody = null;
  
  public GetImgInfoFromSOSOReq() {}
  
  public GetImgInfoFromSOSOReq(byte[] paramArrayOfByte)
  {
    this.vecReqBody = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecReqBody == null)
    {
      cache_vecReqBody = (byte[])new byte[1];
      ((byte[])cache_vecReqBody)[0] = 0;
    }
    this.vecReqBody = ((byte[])paramJceInputStream.read(cache_vecReqBody, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecReqBody, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.GetImgInfoFromSOSOReq
 * JD-Core Version:    0.7.0.1
 */