package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t128
  extends tlv_t
{
  int _t128_body_len = 0;
  
  public tlv_t128()
  {
    this._cmd = 296;
  }
  
  public byte[] get_tlv_128(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
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
    int j = limit_len(paramArrayOfByte2, 16);
    int k = limit_len(paramArrayOfByte3, 16);
    int m = i + 11;
    int n = m + 2;
    int i1 = n + j;
    int i2 = i1 + 2;
    this._t128_body_len = (i2 + k);
    byte[] arrayOfByte = new byte[this._t128_body_len];
    util.int16_to_buf(arrayOfByte, 0, 0);
    util.int8_to_buf(arrayOfByte, 2, paramInt1);
    util.int8_to_buf(arrayOfByte, 3, paramInt2);
    util.int8_to_buf(arrayOfByte, 4, paramInt3);
    util.int32_to_buf(arrayOfByte, 5, paramInt4);
    util.int16_to_buf(arrayOfByte, 9, i);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 11, i);
    util.int16_to_buf(arrayOfByte, m, j);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, n, j);
    util.int16_to_buf(arrayOfByte, i1, k);
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, i2, k);
    fill_head(this._cmd);
    fill_body(arrayOfByte, this._t128_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t128
 * JD-Core Version:    0.7.0.1
 */