package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t100
  extends tlv_t
{
  int _db_buf_ver = 1;
  int _sso_ver = 5;
  int _t100_body_len = 22;
  
  public tlv_t100()
  {
    this._cmd = 256;
  }
  
  public byte[] get_tlv_100(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[this._t100_body_len];
    util.int16_to_buf(arrayOfByte, 0, this._db_buf_ver);
    util.int32_to_buf(arrayOfByte, 2, this._sso_ver);
    util.int32_to_buf(arrayOfByte, 6, (int)paramLong1);
    util.int32_to_buf(arrayOfByte, 10, (int)paramLong2);
    util.int32_to_buf(arrayOfByte, 14, paramInt1);
    util.int32_to_buf(arrayOfByte, 18, paramInt2);
    fill_head(this._cmd);
    fill_body(arrayOfByte, this._t100_body_len);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t100
 * JD-Core Version:    0.7.0.1
 */