package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.e;
import com.tencent.token.utils.UserTask;

public class cw
  extends cv
{
  static cw a;
  
  private cw()
  {
    super("tbl_safe_msg");
  }
  
  public static cw a()
  {
    if (a == null) {
      a = new cw();
    }
    return a;
  }
  
  public e a(byte paramByte)
  {
    return a(2, paramByte);
  }
  
  public void a(final byte paramByte, final Handler paramHandler)
  {
    new UserTask()
    {
      public e a(String... paramAnonymousVarArgs)
      {
        paramAnonymousVarArgs = new e();
        cs localcs = cs.a();
        cw localcw = cw.a();
        if (!localcs.o())
        {
          e locale = localcs.q();
          paramAnonymousVarArgs = locale;
          if (!locale.b()) {
            return locale;
          }
        }
        if (localcs.e() == null)
        {
          paramAnonymousVarArgs.b(103);
          return paramAnonymousVarArgs;
        }
        if (localcs.k() == null)
        {
          paramAnonymousVarArgs = localcs.r();
          if (!paramAnonymousVarArgs.b()) {
            return paramAnonymousVarArgs;
          }
        }
        paramAnonymousVarArgs = localcw.a(paramByte);
        if (!paramAnonymousVarArgs.b()) {
          return paramAnonymousVarArgs;
        }
        paramAnonymousVarArgs.c();
        return paramAnonymousVarArgs;
      }
      
      public void a(e paramAnonymouse)
      {
        Message localMessage = paramHandler.obtainMessage();
        localMessage.what = 1002;
        localMessage.arg1 = paramAnonymouse.a;
        localMessage.obj = paramAnonymouse;
        localMessage.sendToTarget();
      }
    }.c(new String[] { "" });
  }
  
  public void a(Handler paramHandler)
  {
    b();
    cc.a().a(0L, e, paramHandler);
  }
  
  public void b()
  {
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cw
 * JD-Core Version:    0.7.0.1
 */