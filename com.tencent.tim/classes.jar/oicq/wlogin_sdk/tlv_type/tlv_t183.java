package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t183
  extends tlv_t
{
  long _msalt = 0L;
  
  public tlv_t183()
  {
    this._cmd = 387;
  }
  
  public long getMsalt()
  {
    return this._msalt;
  }
  
  public byte[] get_tlv_183(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    util.int64_to_buf(arrayOfByte, 0, paramLong);
    fill_head(this._cmd);
    fill_body(arrayOfByte, arrayOfByte.length);
    set_length();
    return get_buf();
  }
  
  public Boolean verify()
  {
    if (this._body_len < 8) {
      return Boolean.valueOf(false);
    }
    this._msalt = util.buf_to_int64(this._buf, this._head_len);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t183
 * JD-Core Version:    0.7.0.1
 */