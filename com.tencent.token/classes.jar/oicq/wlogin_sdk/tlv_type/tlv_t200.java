package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t200
  extends tlv_t
{
  byte[] pf = new byte[0];
  byte[] pfkey = new byte[0];
  
  public tlv_t200()
  {
    this._cmd = 512;
  }
  
  public byte[] getPf()
  {
    return this.pf;
  }
  
  public byte[] getPfKey()
  {
    return this.pfkey;
  }
  
  public Boolean verify()
  {
    if (this._body_len < 2) {
      return Boolean.valueOf(false);
    }
    int j = util.buf_to_int16(this._buf, this._head_len + 0);
    int k = this._body_len;
    int i = 2 + j;
    if (k < i) {
      return Boolean.valueOf(false);
    }
    this.pf = new byte[j];
    System.arraycopy(this._buf, this._head_len + 2, this.pf, 0, j);
    k = this._body_len;
    j = i + 2;
    if (k < j) {
      return Boolean.valueOf(false);
    }
    i = util.buf_to_int16(this._buf, this._head_len + i);
    if (this._body_len < j + i) {
      return Boolean.valueOf(false);
    }
    this.pfkey = new byte[i];
    System.arraycopy(this._buf, this._head_len + j, this.pfkey, 0, i);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t200
 * JD-Core Version:    0.7.0.1
 */