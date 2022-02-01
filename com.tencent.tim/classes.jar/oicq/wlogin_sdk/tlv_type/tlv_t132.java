package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t132
  extends tlv_t
{
  int _openid_len = 0;
  int _token_len = 0;
  
  public tlv_t132()
  {
    this._cmd = 306;
  }
  
  public byte[] get_access_token()
  {
    byte[] arrayOfByte = new byte[this._token_len];
    System.arraycopy(this._buf, this._head_len + 2, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public byte[] get_openid()
  {
    byte[] arrayOfByte = new byte[this._openid_len];
    System.arraycopy(this._buf, this._head_len + 2 + this._token_len + 4 + 2, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public Boolean verify()
  {
    if (this._body_len < 2) {
      return Boolean.valueOf(false);
    }
    this._token_len = util.buf_to_int16(this._buf, this._head_len);
    if (this._token_len + 2 + 4 + 2 > this._body_len) {
      return Boolean.valueOf(false);
    }
    this._openid_len = util.buf_to_int16(this._buf, this._head_len + 2 + this._token_len + 4);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t132
 * JD-Core Version:    0.7.0.1
 */