package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

public class n
  extends e
{
  public int a = 0;
  public int b = 0;
  
  public n()
  {
    this._type = 6;
  }
  
  public void parse()
  {
    int i = this._head_len;
    this.a = util.buf_to_int16(this._buf, i);
    this.b = util.buf_to_int16(this._buf, i + 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.n
 * JD-Core Version:    0.7.0.1
 */