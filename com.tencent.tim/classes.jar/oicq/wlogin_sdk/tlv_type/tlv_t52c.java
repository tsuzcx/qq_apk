package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t52c
  extends tlv_t
{
  public tlv_t52c()
  {
    this._cmd = 1324;
  }
  
  public byte[] get_tlv_52c(int paramInt, long paramLong)
  {
    byte[] arrayOfByte = new byte[9];
    util.int8_to_buf(arrayOfByte, 0, paramInt);
    util.int64_to_buf(arrayOfByte, 1, paramLong);
    fill_head(this._cmd);
    fill_body(arrayOfByte, arrayOfByte.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t52c
 * JD-Core Version:    0.7.0.1
 */