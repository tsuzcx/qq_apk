package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.util;

public class tlv_t184
  extends tlv_t
{
  byte[] _mS2 = new byte[0];
  
  public tlv_t184()
  {
    this._cmd = 388;
  }
  
  public byte[] getMS2()
  {
    return this._mS2;
  }
  
  public byte[] get_tlv_184(long paramLong, String paramString)
  {
    paramString = MD5.toMD5Byte(paramString);
    int i = paramString.length;
    byte[] arrayOfByte = new byte[i + 8];
    System.arraycopy(paramString, 0, arrayOfByte, 0, i);
    i = 0 + i;
    util.int64_to_buf(arrayOfByte, i, paramLong);
    paramString = MD5.toMD5Byte(arrayOfByte);
    fill_head(this._cmd);
    fill_body(paramString, paramString.length);
    set_length();
    return get_buf();
  }
  
  public Boolean verify()
  {
    if (this._body_len < 16) {
      return Boolean.valueOf(false);
    }
    this._mS2 = new byte[16];
    System.arraycopy(this._buf, this._head_len, this._mS2, 0, 16);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t184
 * JD-Core Version:    0.7.0.1
 */