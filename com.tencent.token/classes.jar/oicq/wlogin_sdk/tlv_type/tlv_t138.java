package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t138
  extends tlv_t
{
  public int _count = 0;
  
  public tlv_t138()
  {
    this._cmd = 312;
  }
  
  public int get_a2_chg_time()
  {
    int i = 0;
    while (i < this._count)
    {
      byte[] arrayOfByte = this._buf;
      int j = this._head_len;
      int k = i * 10;
      if (util.buf_to_int16(arrayOfByte, j + 4 + k) == 266) {
        return util.buf_to_int32(this._buf, this._head_len + 4 + k + 2);
      }
      i += 1;
    }
    return 0;
  }
  
  public int get_a8_chg_time()
  {
    int i = 0;
    while (i < this._count)
    {
      byte[] arrayOfByte = this._buf;
      int j = this._head_len;
      int k = i * 10;
      if (util.buf_to_int16(arrayOfByte, j + 4 + k) == 258) {
        return util.buf_to_int32(this._buf, this._head_len + 4 + k + 2);
      }
      i += 1;
    }
    return 0;
  }
  
  public int get_d2_chg_time()
  {
    int i = 0;
    while (i < this._count)
    {
      byte[] arrayOfByte = this._buf;
      int j = this._head_len;
      int k = i * 10;
      if (util.buf_to_int16(arrayOfByte, j + 4 + k) == 323) {
        return util.buf_to_int32(this._buf, this._head_len + 4 + k + 2);
      }
      i += 1;
    }
    return 0;
  }
  
  public int get_lskey_chg_time()
  {
    int i = 0;
    while (i < this._count)
    {
      byte[] arrayOfByte = this._buf;
      int j = this._head_len;
      int k = i * 10;
      if (util.buf_to_int16(arrayOfByte, j + 4 + k) == 284) {
        return util.buf_to_int32(this._buf, this._head_len + 4 + k + 2);
      }
      i += 1;
    }
    return 0;
  }
  
  public int get_sid_chg_time()
  {
    int i = 0;
    while (i < this._count)
    {
      byte[] arrayOfByte = this._buf;
      int j = this._head_len;
      int k = i * 10;
      if (util.buf_to_int16(arrayOfByte, j + 4 + k) == 356) {
        return util.buf_to_int32(this._buf, this._head_len + 4 + k + 2);
      }
      i += 1;
    }
    return 0;
  }
  
  public int get_skey_chg_time()
  {
    int i = 0;
    while (i < this._count)
    {
      byte[] arrayOfByte = this._buf;
      int j = this._head_len;
      int k = i * 10;
      if (util.buf_to_int16(arrayOfByte, j + 4 + k) == 288) {
        return util.buf_to_int32(this._buf, this._head_len + 4 + k + 2);
      }
      i += 1;
    }
    return 0;
  }
  
  public int get_stweb_chg_time()
  {
    int i = 0;
    while (i < this._count)
    {
      byte[] arrayOfByte = this._buf;
      int j = this._head_len;
      int k = i * 10;
      if (util.buf_to_int16(arrayOfByte, j + 4 + k) == 259) {
        return util.buf_to_int32(this._buf, this._head_len + 4 + k + 2);
      }
      i += 1;
    }
    return 0;
  }
  
  public int get_vkey_chg_time()
  {
    int i = 0;
    while (i < this._count)
    {
      byte[] arrayOfByte = this._buf;
      int j = this._head_len;
      int k = i * 10;
      if (util.buf_to_int16(arrayOfByte, j + 4 + k) == 310) {
        return util.buf_to_int32(this._buf, this._head_len + 4 + k + 2);
      }
      i += 1;
    }
    return 0;
  }
  
  public Boolean verify()
  {
    if (this._body_len < 4) {
      return Boolean.valueOf(false);
    }
    this._count = util.buf_to_int32(this._buf, this._head_len);
    if (this._body_len < this._count * 10 + 4) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t138
 * JD-Core Version:    0.7.0.1
 */