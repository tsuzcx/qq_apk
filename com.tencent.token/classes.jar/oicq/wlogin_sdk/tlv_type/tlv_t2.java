package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t2
  extends tlv_t
{
  int _sigVer = 0;
  int _t2_body_len = 0;
  
  public tlv_t2()
  {
    this._cmd = 2;
  }
  
  public byte[] get_tlv_2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    }
    this._t2_body_len = (arrayOfByte.length + 6 + paramArrayOfByte1.length);
    paramArrayOfByte2 = new byte[this._t2_body_len];
    util.int16_to_buf(paramArrayOfByte2, 0, this._sigVer);
    util.int16_to_buf(paramArrayOfByte2, 2, arrayOfByte.length);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, 4, arrayOfByte.length);
    int i = arrayOfByte.length + 4;
    util.int16_to_buf(paramArrayOfByte2, i, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, i + 2, paramArrayOfByte1.length);
    fill_head(this._cmd);
    fill_body(paramArrayOfByte2, this._t2_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t2
 * JD-Core Version:    0.7.0.1
 */