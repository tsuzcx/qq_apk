package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t124
  extends tlv_t
{
  int _t124_body_len = 0;
  
  public tlv_t124()
  {
    this._cmd = 292;
  }
  
  public byte[] get_tlv_124(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
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
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte4 = new byte[0];
    }
    if (paramArrayOfByte5 == null) {
      paramArrayOfByte5 = new byte[0];
    }
    int i = limit_len(paramArrayOfByte1, 16);
    int j = limit_len(paramArrayOfByte2, 16);
    int k = limit_len(paramArrayOfByte3, 16);
    int m = limit_len(paramArrayOfByte4, 32);
    int n = limit_len(paramArrayOfByte5, 16);
    int i1 = i + 2;
    int i2 = i1 + 2;
    int i3 = i2 + j;
    int i4 = i3 + 2;
    int i5 = i4 + 2;
    int i6 = i5 + k;
    int i7 = i6 + 2;
    int i8 = i7 + m;
    int i9 = i8 + 2;
    this._t124_body_len = (i9 + n);
    byte[] arrayOfByte = new byte[this._t124_body_len];
    util.int16_to_buf(arrayOfByte, 0, i);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 2, i);
    util.int16_to_buf(arrayOfByte, i1, j);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i2, j);
    util.int16_to_buf(arrayOfByte, i3, paramInt);
    util.int16_to_buf(arrayOfByte, i4, k);
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, i5, k);
    util.int16_to_buf(arrayOfByte, i6, m);
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, i7, m);
    util.int16_to_buf(arrayOfByte, i8, n);
    System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, i9, n);
    fill_head(this._cmd);
    fill_body(arrayOfByte, this._t124_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t124
 * JD-Core Version:    0.7.0.1
 */