package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t105
  extends tlv_t
{
  int _en_pos = 0;
  int _enlen = 0;
  int _pic_pos = 0;
  int _piclen = 0;
  
  public tlv_t105()
  {
    this._cmd = 261;
  }
  
  public byte[] get_pic()
  {
    int i = this._piclen;
    byte[] arrayOfByte = new byte[i];
    if (i <= 0) {
      return arrayOfByte;
    }
    System.arraycopy(this._buf, this._pic_pos, arrayOfByte, 0, this._piclen);
    return arrayOfByte;
  }
  
  public byte[] get_sign()
  {
    int i = this._enlen;
    byte[] arrayOfByte = new byte[i];
    if (i <= 0) {
      return arrayOfByte;
    }
    System.arraycopy(this._buf, this._en_pos, arrayOfByte, 0, this._enlen);
    return arrayOfByte;
  }
  
  public Boolean verify()
  {
    if (this._body_len < 2) {
      return Boolean.FALSE;
    }
    this._enlen = util.buf_to_int16(this._buf, this._head_len);
    if (this._body_len < this._enlen + 2 + 2) {
      return Boolean.FALSE;
    }
    this._piclen = util.buf_to_int16(this._buf, this._head_len + 2 + this._enlen);
    if (this._body_len < this._enlen + 2 + 2 + this._piclen) {
      return Boolean.FALSE;
    }
    this._en_pos = (this._head_len + 2);
    this._pic_pos = (this._enlen + 2 + 2 + this._head_len);
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t105
 * JD-Core Version:    0.7.0.1
 */