package com.tencent.token;

import android.os.Handler;
import com.tencent.token.utils.UserTask;

public final class td
  extends tc
{
  static td a;
  
  private td()
  {
    super("tbl_safe_msg");
  }
  
  public static td a()
  {
    if (a == null) {
      a = new td();
    }
    return a;
  }
  
  public final void a(final byte paramByte, final Handler paramHandler)
  {
    new UserTask() {}.a(new String[] { "" });
  }
  
  public final wy b(byte paramByte)
  {
    wy localwy3 = new wy();
    wy localwy2 = super.a(paramByte);
    wy localwy1 = localwy2;
    if (!localwy2.b())
    {
      localwy1 = localwy2;
      if (sz.a().c(localwy3.a)) {
        localwy1 = super.a(paramByte);
      }
    }
    return localwy1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.td
 * JD-Core Version:    0.7.0.1
 */