package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t150
  extends tlv_t
{
  public int _other_len = 0;
  
  public tlv_t150()
  {
    this._cmd = 336;
  }
  
  public int get_bitmap()
  {
    return util.buf_to_int32(this._buf, this._head_len);
  }
  
  public byte get_network()
  {
    return (byte)(util.buf_to_int8(this._buf, this._head_len + 4) & 0xFF);
  }
  
  public Boolean verify()
  {
    if (this._body_len < 7) {
      return Boolean.valueOf(false);
    }
    int i = util.buf_to_int16(this._buf, this._head_len + 5);
    if (this._body_len < i + 7) {
      return Boolean.valueOf(false);
    }
    this._other_len = i;
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t150
 * JD-Core Version:    0.7.0.1
 */