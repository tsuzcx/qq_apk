package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

public class d
  extends DevlockBase
{
  public d()
  {
    this._msgType = DevlockBase.a.b;
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3)
  {
    TLV_QuerySig localTLV_QuerySig = rst.querySig;
    l locall = new l();
    locall.a(paramLong3);
    int i = localTLV_QuerySig.get_size();
    int j = locall.get_size();
    if ((i != 0) && (j != 0))
    {
      int k = i + 2;
      byte[] arrayOfByte = new byte[k + j];
      util.int16_to_buf(arrayOfByte, 0, 2);
      System.arraycopy(localTLV_QuerySig.get_buf(), 0, arrayOfByte, 2, i);
      System.arraycopy(locall.get_buf(), 0, arrayOfByte, k, j);
      return _get_request(paramLong1, paramLong2, arrayOfByte);
    }
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.d
 * JD-Core Version:    0.7.0.1
 */