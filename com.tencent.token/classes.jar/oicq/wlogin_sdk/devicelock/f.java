package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

public class f
  extends DevlockBase
{
  public f()
  {
    this._msgType = DevlockBase.a.c;
  }
  
  public byte[] a(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7)
  {
    TLV_QuerySig localTLV_QuerySig = rst.querySig;
    if (localTLV_QuerySig.get_size() == 0) {
      localTLV_QuerySig.set_data(new byte[0], 0);
    }
    paramArrayOfByte3 = new g().a(paramLong2, paramLong3, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6);
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length != 0))
    {
      paramArrayOfByte2 = null;
      if ((paramArrayOfByte7 != null) && (paramArrayOfByte7.length > 0))
      {
        paramArrayOfByte1 = new n().a(paramArrayOfByte7);
      }
      else
      {
        paramArrayOfByte1 = paramArrayOfByte2;
        if (rst.sppKey != null)
        {
          paramArrayOfByte1 = paramArrayOfByte2;
          if (rst.sppKey.get_data_len() > 0) {
            paramArrayOfByte1 = rst.sppKey.get_buf();
          }
        }
      }
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0))
      {
        int k = localTLV_QuerySig.get_size();
        int i = paramArrayOfByte3.length;
        int j = paramArrayOfByte1.length;
        paramArrayOfByte2 = new byte[k + 2 + i + j];
        util.int16_to_buf(paramArrayOfByte2, 0, 3);
        System.arraycopy(localTLV_QuerySig.get_buf(), 0, paramArrayOfByte2, 2, k);
        k = 2 + k;
        System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte2, k, i);
        System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, k + i, j);
        return _get_request(paramLong1, paramLong2, paramArrayOfByte2);
      }
      return new byte[0];
    }
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.f
 * JD-Core Version:    0.7.0.1
 */