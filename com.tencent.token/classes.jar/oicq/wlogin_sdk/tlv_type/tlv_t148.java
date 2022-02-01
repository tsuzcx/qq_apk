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
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte2 = new byte[0];
    }
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte3 = new byte[0];
    }
    int i = limit_len(paramArrayOfByte1, 32);
    int j = limit_len(paramArrayOfByte2, 32);
    int k = limit_len(paramArrayOfByte3, 32);
    int m = i + 2;
    int n = m + 4;
    int i1 = n + 4;
    int i2 = i1 + 4;
    int i3 = i2 + 2;
    int i4 = i3 + j;
    int i5 = i4 + 2;
    byte[] arrayOfByte = new byte[i5 + k];
    util.int16_to_buf(arrayOfByte, 0, i);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 2, i);
    util.int64_to_buf32(arrayOfByte, m, paramLong1);
    util.int64_to_buf32(arrayOfByte, n, paramLong2);
    util.int64_to_buf32(arrayOfByte, i1, paramLong3);
    util.int16_to_buf(arrayOfByte, i2, j);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i3, j);
    util.int16_to_buf(arrayOfByte, i4, k);
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, i5, k);
    fill_head(this._cmd);
    fill_body(arrayOfByte, arrayOfByte.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t148
 * JD-Core Version:    0.7.0.1
 */