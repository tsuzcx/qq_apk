package com.tencent.token;

import android.os.Handler;
import com.tencent.token.global.d;
import com.tencent.token.utils.UserTask;

public final class bd
  extends bc
{
  static bd a = null;
  
  private bd()
  {
    super("tbl_safe_msg");
  }
  
  public static bd a()
  {
    if (a == null) {
      a = new bd();
    }
    return a;
  }
  
  public final void a(byte paramByte, Handler paramHandler)
  {
    new be(this, paramByte, paramHandler).a(new String[] { "" });
  }
  
  public final void a(Handler paramHandler)
  {
    f();
    af.a().b(0L, e, paramHandler);
  }
  
  public final d b(byte paramByte)
  {
    return a(paramByte);
  }
  
  public final void b()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bd
 * JD-Core Version:    0.7.0.1
 */