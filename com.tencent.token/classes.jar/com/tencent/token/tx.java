package com.tencent.token;

import android.os.Handler;
import com.tencent.token.utils.UserTask;

public final class tx
  extends tw
{
  static tx a;
  
  private tx()
  {
    super("tbl_safe_msg");
  }
  
  public static tx a()
  {
    if (a == null) {
      a = new tx();
    }
    return a;
  }
  
  public final void a(final byte paramByte, final Handler paramHandler)
  {
    new UserTask() {}.a(new String[] { "" });
  }
  
  public final xt b(byte paramByte)
  {
    xt localxt3 = new xt();
    xt localxt2 = super.a(paramByte);
    xt localxt1 = localxt2;
    if (!localxt2.b())
    {
      localxt1 = localxt2;
      if (tt.a().c(localxt3.a)) {
        localxt1 = super.a(paramByte);
      }
    }
    return localxt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tx
 * JD-Core Version:    0.7.0.1
 */