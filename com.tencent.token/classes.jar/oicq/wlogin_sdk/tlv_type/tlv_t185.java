package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t185
  extends tlv_t
{
  public tlv_t185()
  {
    this._cmd = 389;
  }
  
  public byte[] get_tlv_185(int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    util.int8_to_buf(arrayOfByte, 0, 1);
    util.int8_to_buf(arrayOfByte, 1, paramInt);
    fill_head(this._cmd);
    fill_body(arrayOfByte, 2);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t185
 * JD-Core Version:    0.7.0.1
 */