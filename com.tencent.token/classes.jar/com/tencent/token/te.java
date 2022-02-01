package com.tencent.token;

import android.os.Handler;
import com.tencent.token.utils.UserTask;

public final class te
  extends td
{
  static te a;
  
  private te()
  {
    super("tbl_safe_msg");
  }
  
  public static te a()
  {
    if (a == null) {
      a = new te();
    }
    return a;
  }
  
  public final void a(final byte paramByte, final Handler paramHandler)
  {
    new UserTask() {}.a(new String[] { "" });
  }
  
  public final wz b(byte paramByte)
  {
    wz localwz3 = new wz();
    wz localwz2 = super.a(paramByte);
    wz localwz1 = localwz2;
    if (!localwz2.b())
    {
      localwz1 = localwz2;
      if (ta.a().c(localwz3.a)) {
        localwz1 = super.a(paramByte);
      }
    }
    return localwz1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.te
 * JD-Core Version:    0.7.0.1
 */