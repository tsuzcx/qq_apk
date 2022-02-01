package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t201
  extends tlv_t
{
  public tlv_t201()
  {
    this._cmd = 513;
  }
  
  public byte[] get_tlv_201(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    byte[] arrayOfByte = paramArrayOfByte4;
    if (paramArrayOfByte4 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte4 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte4 = new byte[0];
    }
    paramArrayOfByte2 = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte2 = new byte[0];
    }
    int i = paramArrayOfByte2.length + 2 + 2 + paramArrayOfByte4.length + 2 + paramArrayOfByte3.length + 2 + arrayOfByte.length;
    paramArrayOfByte1 = new byte[i];
    util.int16_to_buf(paramArrayOfByte1, 0, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 2, paramArrayOfByte2.length);
    int j = paramArrayOfByte2.length + 2;
    util.int16_to_buf(paramArrayOfByte1, j, paramArrayOfByte4.length);
    j += 2;
    System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte1, j, paramArrayOfByte4.length);
    j += paramArrayOfByte4.length;
    util.int16_to_buf(paramArrayOfByte1, j, paramArrayOfByte3.length);
    j += 2;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, j, paramArrayOfByte3.length);
    j += paramArrayOfByte3.length;
    util.int16_to_buf(paramArrayOfByte1, j, arrayOfByte.length);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte1, j + 2, arrayOfByte.length);
    j = arrayOfByte.length;
    fill_head(this._cmd);
    fill_body(paramArrayOfByte1, i);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t201
 * JD-Core Version:    0.7.0.1
 */