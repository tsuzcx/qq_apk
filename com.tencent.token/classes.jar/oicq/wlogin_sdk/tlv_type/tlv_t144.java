package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class tlv_t144
  extends tlv_t
{
  public int _t144_body_len = 0;
  
  public tlv_t144()
  {
    this._cmd = 324;
  }
  
  public byte[] get_tlv_144(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
    {
      m = paramArrayOfByte1.length + 0;
      j = 1;
    }
    else
    {
      m = 0;
      j = 0;
    }
    int k = m;
    int i = j;
    if (paramArrayOfByte2 != null)
    {
      k = m;
      i = j;
      if (paramArrayOfByte2.length > 0)
      {
        k = m + paramArrayOfByte2.length;
        i = j + 1;
      }
    }
    int m = k;
    int j = i;
    if (paramArrayOfByte3 != null)
    {
      m = k;
      j = i;
      if (paramArrayOfByte3.length > 0)
      {
        m = k + paramArrayOfByte3.length;
        j = i + 1;
      }
    }
    k = m;
    i = j;
    if (paramArrayOfByte4 != null)
    {
      k = m;
      i = j;
      if (paramArrayOfByte4.length > 0)
      {
        k = m + paramArrayOfByte4.length;
        i = j + 1;
      }
    }
    m = k;
    j = i;
    if (paramArrayOfByte5 != null)
    {
      m = k;
      j = i;
      if (paramArrayOfByte5.length > 0)
      {
        m = k + paramArrayOfByte5.length;
        j = i + 1;
      }
    }
    k = 2;
    byte[] arrayOfByte = new byte[m + 2];
    util.int16_to_buf(arrayOfByte, 0, j);
    i = k;
    if (paramArrayOfByte1 != null)
    {
      i = k;
      if (paramArrayOfByte1.length > 0)
      {
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 2, paramArrayOfByte1.length);
        i = 2 + paramArrayOfByte1.length;
      }
    }
    j = i;
    if (paramArrayOfByte2 != null)
    {
      j = i;
      if (paramArrayOfByte2.length > 0)
      {
        System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i, paramArrayOfByte2.length);
        j = i + paramArrayOfByte2.length;
      }
    }
    i = j;
    if (paramArrayOfByte3 != null)
    {
      i = j;
      if (paramArrayOfByte3.length > 0)
      {
        System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, j, paramArrayOfByte3.length);
        i = j + paramArrayOfByte3.length;
      }
    }
    j = i;
    if (paramArrayOfByte4 != null)
    {
      j = i;
      if (paramArrayOfByte4.length > 0)
      {
        System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, i, paramArrayOfByte4.length);
        j = i + paramArrayOfByte4.length;
      }
    }
    if ((paramArrayOfByte5 != null) && (paramArrayOfByte5.length > 0)) {
      System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, j, paramArrayOfByte5.length);
    }
    paramArrayOfByte1 = cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte6);
    this._t144_body_len = paramArrayOfByte1.length;
    fill_head(this._cmd);
    fill_body(paramArrayOfByte1, paramArrayOfByte1.length);
    set_length();
    return get_buf();
  }
  
  public byte[] get_tlv_144(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
    {
      m = paramArrayOfByte1.length + 0;
      j = 1;
    }
    else
    {
      m = 0;
      j = 0;
    }
    int k = m;
    int i = j;
    if (paramArrayOfByte2 != null)
    {
      k = m;
      i = j;
      if (paramArrayOfByte2.length > 0)
      {
        k = m + paramArrayOfByte2.length;
        i = j + 1;
      }
    }
    int m = k;
    int j = i;
    if (paramArrayOfByte3 != null)
    {
      m = k;
      j = i;
      if (paramArrayOfByte3.length > 0)
      {
        m = k + paramArrayOfByte3.length;
        j = i + 1;
      }
    }
    k = m;
    i = j;
    if (paramArrayOfByte4 != null)
    {
      k = m;
      i = j;
      if (paramArrayOfByte4.length > 0)
      {
        k = m + paramArrayOfByte4.length;
        i = j + 1;
      }
    }
    m = k;
    j = i;
    if (paramArrayOfByte5 != null)
    {
      m = k;
      j = i;
      if (paramArrayOfByte5.length > 0)
      {
        m = k + paramArrayOfByte5.length;
        j = i + 1;
      }
    }
    k = m;
    i = j;
    if (paramArrayOfByte6 != null)
    {
      k = m;
      i = j;
      if (paramArrayOfByte6.length > 0)
      {
        k = m + paramArrayOfByte6.length;
        i = j + 1;
      }
    }
    m = k;
    j = i;
    if (paramArrayOfByte7 != null)
    {
      m = k;
      j = i;
      if (paramArrayOfByte7.length > 0)
      {
        m = k + paramArrayOfByte7.length;
        j = i + 1;
      }
    }
    k = m;
    i = j;
    if (paramArrayOfByte8 != null)
    {
      k = m;
      i = j;
      if (paramArrayOfByte8.length > 0)
      {
        k = m + paramArrayOfByte8.length;
        i = j + 1;
      }
    }
    j = 2;
    byte[] arrayOfByte = new byte[k + 2];
    util.int16_to_buf(arrayOfByte, 0, i);
    i = j;
    if (paramArrayOfByte1 != null)
    {
      i = j;
      if (paramArrayOfByte1.length > 0)
      {
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 2, paramArrayOfByte1.length);
        i = 2 + paramArrayOfByte1.length;
      }
    }
    j = i;
    if (paramArrayOfByte2 != null)
    {
      j = i;
      if (paramArrayOfByte2.length > 0)
      {
        System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i, paramArrayOfByte2.length);
        j = i + paramArrayOfByte2.length;
      }
    }
    i = j;
    if (paramArrayOfByte3 != null)
    {
      i = j;
      if (paramArrayOfByte3.length > 0)
      {
        System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, j, paramArrayOfByte3.length);
        i = j + paramArrayOfByte3.length;
      }
    }
    j = i;
    if (paramArrayOfByte4 != null)
    {
      j = i;
      if (paramArrayOfByte4.length > 0)
      {
        System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, i, paramArrayOfByte4.length);
        j = i + paramArrayOfByte4.length;
      }
    }
    i = j;
    if (paramArrayOfByte5 != null)
    {
      i = j;
      if (paramArrayOfByte5.length > 0)
      {
        System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, j, paramArrayOfByte5.length);
        i = j + paramArrayOfByte5.length;
      }
    }
    j = i;
    if (paramArrayOfByte6 != null)
    {
      j = i;
      if (paramArrayOfByte6.length > 0)
      {
        System.arraycopy(paramArrayOfByte6, 0, arrayOfByte, i, paramArrayOfByte6.length);
        j = i + paramArrayOfByte6.length;
      }
    }
    i = j;
    if (paramArrayOfByte7 != null)
    {
      i = j;
      if (paramArrayOfByte7.length > 0)
      {
        System.arraycopy(paramArrayOfByte7, 0, arrayOfByte, j, paramArrayOfByte7.length);
        i = j + paramArrayOfByte7.length;
      }
    }
    if ((paramArrayOfByte8 != null) && (paramArrayOfByte8.length > 0)) {
      System.arraycopy(paramArrayOfByte8, 0, arrayOfByte, i, paramArrayOfByte8.length);
    }
    paramArrayOfByte1 = cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte9);
    this._t144_body_len = paramArrayOfByte1.length;
    fill_head(this._cmd);
    fill_body(paramArrayOfByte1, paramArrayOfByte1.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t144
 * JD-Core Version:    0.7.0.1
 */