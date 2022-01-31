package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

public class e
{
  protected int _body_len = 0;
  protected byte[] _buf = new byte[this._max];
  protected int _head_len = 4;
  protected int _max = 128;
  protected int _pos = 0;
  protected int _type = 0;
  
  public void fill_body(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > this._max - this._head_len)
    {
      this._max = (this._head_len + paramInt + 64);
      byte[] arrayOfByte = new byte[this._max];
      System.arraycopy(this._buf, 0, arrayOfByte, 0, this._pos);
      this._buf = arrayOfByte;
    }
    this._body_len = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this._buf, this._pos, paramInt);
    this._pos += paramInt;
    set_length();
  }
  
  public void fill_head()
  {
    util.int16_to_buf(this._buf, this._pos, this._type);
    this._pos += 2;
    util.int16_to_buf(this._buf, this._pos, 0);
    this._pos += 2;
  }
  
  public byte[] get_buf()
  {
    byte[] arrayOfByte = new byte[this._pos];
    System.arraycopy(this._buf, 0, arrayOfByte, 0, this._pos);
    return arrayOfByte;
  }
  
  public byte[] get_data()
  {
    byte[] arrayOfByte = new byte[this._body_len];
    System.arraycopy(this._buf, this._head_len, arrayOfByte, 0, this._body_len);
    return arrayOfByte;
  }
  
  public int get_data_len()
  {
    return this._body_len;
  }
  
  public int get_size()
  {
    return this._pos;
  }
  
  public int get_type()
  {
    return this._type;
  }
  
  public void parse() {}
  
  public int put_block(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length;
    util.int16_to_buf(this._buf, paramInt, i);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte, 0, this._buf, paramInt, i);
    return i + paramInt;
  }
  
  public int put_int16(int paramInt1, int paramInt2)
  {
    util.int16_to_buf(this._buf, paramInt2, paramInt1);
    return paramInt2 + 2;
  }
  
  public int put_int32(long paramLong, int paramInt)
  {
    util.int64_to_buf32(this._buf, paramInt, paramLong);
    return paramInt + 4;
  }
  
  public int put_int64(long paramLong, int paramInt)
  {
    util.int64_to_buf(this._buf, paramInt, paramLong);
    return paramInt + 8;
  }
  
  public int put_int8(int paramInt1, int paramInt2)
  {
    util.int8_to_buf(this._buf, paramInt2, paramInt1);
    return paramInt2 + 1;
  }
  
  public int set_buf(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > this._max)
    {
      this._max = (paramInt + 128);
      this._buf = new byte[this._max];
    }
    this._pos = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this._buf, 0, paramInt);
    this._type = util.buf_to_int16(paramArrayOfByte, 0);
    this._body_len = (paramInt - this._head_len);
    try
    {
      parse();
      return 0;
    }
    catch (Exception paramArrayOfByte) {}
    return -1009;
  }
  
  public int set_data(byte[] paramArrayOfByte, int paramInt)
  {
    if (this._head_len + paramInt > this._max)
    {
      this._max = (this._head_len + paramInt + 128);
      byte[] arrayOfByte = new byte[this._max];
      System.arraycopy(this._buf, 0, arrayOfByte, 0, this._head_len);
      this._buf = arrayOfByte;
    }
    this._pos = (this._head_len + paramInt);
    System.arraycopy(paramArrayOfByte, 0, this._buf, this._head_len, paramInt);
    this._body_len = paramInt;
    util.int16_to_buf(this._buf, 0, this._type);
    util.int16_to_buf(this._buf, 2, this._body_len);
    try
    {
      parse();
      return 0;
    }
    catch (Exception paramArrayOfByte) {}
    return -1009;
  }
  
  public void set_length()
  {
    util.int16_to_buf(this._buf, 2, this._pos - this._head_len);
  }
  
  public String toString()
  {
    String str = "";
    int i = 0;
    while (i < this._pos)
    {
      str = str + Integer.toHexString(this._buf[i] >> 4 & 0xF);
      str = str + Integer.toHexString(this._buf[i] & 0xF);
      i += 1;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.e
 * JD-Core Version:    0.7.0.1
 */