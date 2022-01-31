package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t199
  extends tlv_t
{
  byte[] openid = new byte[0];
  byte[] paytoken = new byte[0];
  
  public tlv_t199()
  {
    this._cmd = 409;
  }
  
  public byte[] getOpenId()
  {
    return this.openid;
  }
  
  public byte[] getPayToken()
  {
    return this.paytoken;
  }
  
  public Boolean verify()
  {
    if (this._body_len < 2) {
      return Boolean.valueOf(false);
    }
    int i = util.buf_to_int16(this._buf, this._head_len + 0);
    if (this._body_len < i + 2) {
      return Boolean.valueOf(false);
    }
    this.openid = new byte[i];
    System.arraycopy(this._buf, this._head_len + 2, this.openid, 0, i);
    int j = i + 2;
    if (this._body_len < j + 2) {
      return Boolean.valueOf(false);
    }
    i = util.buf_to_int16(this._buf, this._head_len + j);
    j += 2;
    if (this._body_len < j + i) {
      return Boolean.valueOf(false);
    }
    this.paytoken = new byte[i];
    System.arraycopy(this._buf, this._head_len + j, this.paytoken, 0, i);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t199
 * JD-Core Version:    0.7.0.1
 */