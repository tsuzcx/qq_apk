package com.tencent.token;

import android.os.Handler;
import com.tencent.token.global.f;
import com.tencent.token.utils.UserTask;

public class du
  extends dt
{
  static du a = null;
  
  private du()
  {
    super("tbl_safe_msg");
  }
  
  public static du a()
  {
    if (a == null) {
      a = new du();
    }
    return a;
  }
  
  public f a(byte paramByte)
  {
    return a(2, paramByte);
  }
  
  public void a(byte paramByte, Handler paramHandler)
  {
    new dv(this, paramByte, paramHandler).c(new String[] { "" });
  }
  
  public void a(Handler paramHandler)
  {
    b();
    cw.a().a(0L, e, paramHandler);
  }
  
  public void b()
  {
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.du
 * JD-Core Version:    0.7.0.1
 */