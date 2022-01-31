package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class r
  extends a
{
  public r()
  {
    this.g = 275;
  }
  
  public long f()
  {
    long l = util.buf_to_int32(this.f, this.d) & 0xFFFFFFFF;
    util.LOGD("get uin:" + new Long(l).toString());
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.r
 * JD-Core Version:    0.7.0.1
 */