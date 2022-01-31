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
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this._count)
      {
        if (util.buf_to_int16(this._buf, this._head_len + 4 + i * 10) == 266) {
          j = util.buf_to_int32(this._buf, i * 10 + (this._head_len + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int get_a8_chg_time()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this._count)
      {
        if (util.buf_to_int16(this._buf, this._head_len + 4 + i * 10) == 258) {
          j = util.buf_to_int32(this._buf, i * 10 + (this._head_len + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int get_d2_chg_time()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this._count)
      {
        if (util.buf_to_int16(this._buf, this._head_len + 4 + i * 10) == 323) {
          j = util.buf_to_int32(this._buf, i * 10 + (this._head_len + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int get_lskey_chg_time()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this._count)
      {
        if (util.buf_to_int16(this._buf, this._head_len + 4 + i * 10) == 284) {
          j = util.buf_to_int32(this._buf, i * 10 + (this._head_len + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int get_sid_chg_time()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this._count)
      {
        if (util.buf_to_int16(this._buf, this._head_len + 4 + i * 10) == 356) {
          j = util.buf_to_int32(this._buf, i * 10 + (this._head_len + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int get_skey_chg_time()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this._count)
      {
        if (util.buf_to_int16(this._buf, this._head_len + 4 + i * 10) == 288) {
          j = util.buf_to_int32(this._buf, i * 10 + (this._head_len + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int get_stweb_chg_time()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this._count)
      {
        if (util.buf_to_int16(this._buf, this._head_len + 4 + i * 10) == 259) {
          j = util.buf_to_int32(this._buf, i * 10 + (this._head_len + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int get_vkey_chg_time()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this._count)
      {
        if (util.buf_to_int16(this._buf, this._head_len + 4 + i * 10) == 310) {
          j = util.buf_to_int32(this._buf, i * 10 + (this._head_len + 4) + 2);
        }
      }
      else {
        return j;
      }
      i += 1;
    }
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