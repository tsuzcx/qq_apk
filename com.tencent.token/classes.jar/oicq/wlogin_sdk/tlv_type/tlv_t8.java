package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t8
  extends tlv_t
{
  int _t8_body_len = 0;
  
  public tlv_t8()
  {
    this._cmd = 8;
  }
  
  public byte[] get_tlv_8(int paramInt1, int paramInt2, int paramInt3)
  {
    this._t8_body_len = 8;
    byte[] arrayOfByte = new byte[this._t8_body_len];
    util.int16_to_buf(arrayOfByte, 0, paramInt1);
    util.int32_to_buf(arrayOfByte, 2, paramInt2);
    util.int16_to_buf(arrayOfByte, 6, paramInt3);
    fill_head(this._cmd);
    fill_body(arrayOfByte, this._t8_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t8
 * JD-Core Version:    0.7.0.1
 */