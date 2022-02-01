package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t127
  extends tlv_t
{
  int _t127_body_len = 0;
  int _version = 0;
  
  public tlv_t127()
  {
    this._cmd = 295;
  }
  
  public byte[] get_tlv_127(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this._t127_body_len = (paramArrayOfByte1.length + 4 + 2 + paramArrayOfByte2.length);
    byte[] arrayOfByte = new byte[this._t127_body_len];
    util.int16_to_buf(arrayOfByte, 0, this._version);
    util.int16_to_buf(arrayOfByte, 2, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 4, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 4;
    util.int16_to_buf(arrayOfByte, i, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i + 2, paramArrayOfByte2.length);
    fill_head(this._cmd);
    fill_body(arrayOfByte, arrayOfByte.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t127
 * JD-Core Version:    0.7.0.1
 */