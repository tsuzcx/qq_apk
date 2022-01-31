package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t149
  extends tlv_t
{
  public int _content_len = 0;
  public int _otherinfo_len = 0;
  public int _title_len = 0;
  
  public tlv_t149()
  {
    this._cmd = 329;
  }
  
  public byte[] get_content()
  {
    byte[] arrayOfByte = new byte[this._content_len];
    System.arraycopy(this._buf, this._head_len + 2 + 2 + this._title_len + 2, arrayOfByte, 0, this._content_len);
    return arrayOfByte;
  }
  
  public byte[] get_otherinfo()
  {
    byte[] arrayOfByte = new byte[this._otherinfo_len];
    System.arraycopy(this._buf, this._head_len + 2 + 2 + this._title_len + 2 + this._content_len + 2, arrayOfByte, 0, this._otherinfo_len);
    return arrayOfByte;
  }
  
  public byte[] get_title()
  {
    byte[] arrayOfByte = new byte[this._title_len];
    System.arraycopy(this._buf, this._head_len + 2 + 2, arrayOfByte, 0, this._title_len);
    return arrayOfByte;
  }
  
  public int get_type()
  {
    return util.buf_to_int16(this._buf, this._head_len);
  }
  
  public Boolean verify()
  {
    if (this._body_len < 8) {
      return Boolean.valueOf(false);
    }
    int i = util.buf_to_int16(this._buf, this._head_len + 2);
    if (this._body_len < i + 8) {
      return Boolean.valueOf(false);
    }
    this._title_len = i;
    i = util.buf_to_int16(this._buf, this._head_len + 2 + 2 + this._title_len);
    if (this._body_len < this._title_len + 8 + i) {
      return Boolean.valueOf(false);
    }
    this._content_len = i;
    i = util.buf_to_int16(this._buf, this._head_len + 2 + 2 + this._title_len + 2 + this._content_len);
    if (this._body_len < this._title_len + 8 + this._content_len + i) {
      return Boolean.valueOf(false);
    }
    this._otherinfo_len = i;
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t149
 * JD-Core Version:    0.7.0.1
 */