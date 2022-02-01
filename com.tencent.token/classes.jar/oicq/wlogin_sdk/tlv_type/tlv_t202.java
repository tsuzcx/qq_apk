package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t202
  extends tlv_t
{
  public tlv_t202()
  {
    this._cmd = 514;
  }
  
  public byte[] get_tlv_202(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[16];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    int j = limit_len(arrayOfByte, 16);
    int i = limit_len(paramArrayOfByte1, 32);
    paramArrayOfByte2 = new byte[j + 2 + 2 + i];
    util.int16_to_buf(paramArrayOfByte2, 0, j);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, 2, j);
    j += 2;
    util.int16_to_buf(paramArrayOfByte2, j, i);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, j + 2, i);
    fill_head(this._cmd);
    fill_body(paramArrayOfByte2, paramArrayOfByte2.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t202
 * JD-Core Version:    0.7.0.1
 */