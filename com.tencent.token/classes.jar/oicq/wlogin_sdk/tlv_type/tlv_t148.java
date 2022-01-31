package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t148
  extends tlv_t
{
  public tlv_t148()
  {
    this._cmd = 328;
  }
  
  public byte[] get_tlv_148(byte[] paramArrayOfByte1, long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    paramArrayOfByte2 = paramArrayOfByte3;
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte2 = new byte[0];
    }
    int k = limit_len(arrayOfByte, 32);
    int j = limit_len(paramArrayOfByte1, 32);
    int i = limit_len(paramArrayOfByte2, 32);
    paramArrayOfByte3 = new byte[k + 2 + 4 + 4 + 4 + 2 + j + 2 + i];
    util.int16_to_buf(paramArrayOfByte3, 0, k);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte3, 2, k);
    k += 2;
    util.int64_to_buf32(paramArrayOfByte3, k, paramLong1);
    k += 4;
    util.int64_to_buf32(paramArrayOfByte3, k, paramLong2);
    k += 4;
    util.int64_to_buf32(paramArrayOfByte3, k, paramLong3);
    k += 4;
    util.int16_to_buf(paramArrayOfByte3, k, j);
    k += 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, k, j);
    j = k + j;
    util.int16_to_buf(paramArrayOfByte3, j, i);
    j += 2;
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, j, i);
    fill_head(this._cmd);
    fill_body(paramArrayOfByte3, paramArrayOfByte3.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t148
 * JD-Core Version:    0.7.0.1
 */