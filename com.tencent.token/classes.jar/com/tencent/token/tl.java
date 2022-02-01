package com.tencent.token;

import android.os.Handler;
import com.tencent.token.utils.UserTask;

public final class tl
  extends tk
{
  static tl a;
  
  private tl()
  {
    super("tbl_safe_msg");
  }
  
  public static tl a()
  {
    if (a == null) {
      a = new tl();
    }
    return a;
  }
  
  public final void a(final byte paramByte, final Handler paramHandler)
  {
    new UserTask() {}.a(new String[] { "" });
  }
  
  public final xh b(byte paramByte)
  {
    xh localxh3 = new xh();
    xh localxh2 = super.a(paramByte);
    xh localxh1 = localxh2;
    if (!localxh2.b())
    {
      localxh1 = localxh2;
      if (th.a().c(localxh3.a)) {
        localxh1 = super.a(paramByte);
      }
    }
    return localxh1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tl
 * JD-Core Version:    0.7.0.1
 */