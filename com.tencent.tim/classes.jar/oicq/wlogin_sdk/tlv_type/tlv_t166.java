package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t166
  extends tlv_t
{
  public tlv_t166()
  {
    this._cmd = 358;
  }
  
  public byte[] get_tlv_166(int paramInt)
  {
    byte[] arrayOfByte = new byte[1];
    util.int8_to_buf(arrayOfByte, 0, paramInt);
    fill_head(this._cmd);
    fill_body(arrayOfByte, arrayOfByte.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t166
 * JD-Core Version:    0.7.0.1
 */