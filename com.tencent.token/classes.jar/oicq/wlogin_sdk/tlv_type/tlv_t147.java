package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t147
  extends tlv_t
{
  public tlv_t147()
  {
    this._cmd = 327;
  }
  
  public byte[] get_tlv_147(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    int i = limit_len(arrayOfByte, 32);
    int j = limit_len(paramArrayOfByte1, 32);
    int k = i + 6;
    int m = k + 2;
    paramArrayOfByte2 = new byte[m + j];
    util.int64_to_buf32(paramArrayOfByte2, 0, paramLong);
    util.int16_to_buf(paramArrayOfByte2, 4, i);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, 6, i);
    util.int16_to_buf(paramArrayOfByte2, k, j);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, m, j);
    fill_head(this._cmd);
    fill_body(paramArrayOfByte2, paramArrayOfByte2.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t147
 * JD-Core Version:    0.7.0.1
 */