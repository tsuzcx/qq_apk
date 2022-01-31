package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

public class h
  extends e
{
  public int a = -1;
  public int b = 0;
  public byte[] c = new byte[0];
  public byte[] d = new byte[0];
  public int e;
  public byte[] f = new byte[0];
  
  public h()
  {
    this._type = 1;
  }
  
  public void parse()
  {
    int i = this._head_len;
    this.a = util.buf_to_int32(this._buf, i);
    i += 4;
    this.b = util.buf_to_int32(this._buf, i);
    int j = i + 4;
    i = util.buf_to_int16(this._buf, j);
    j += 2;
    this.c = new byte[i];
    System.arraycopy(this._buf, j, this.c, 0, i);
    j += i;
    i = util.buf_to_int16(this._buf, j);
    j += 2;
    this.d = new byte[i];
    System.arraycopy(this._buf, j, this.d, 0, i);
    i = j + i;
    this.e = util.buf_to_int16(this._buf, i);
    j = i + 2;
    i = util.buf_to_int16(this._buf, j);
    j += 2;
    this.f = new byte[i];
    System.arraycopy(this._buf, j, this.f, 0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.h
 * JD-Core Version:    0.7.0.1
 */