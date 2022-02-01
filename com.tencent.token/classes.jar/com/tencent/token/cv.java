package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.e;
import com.tencent.token.utils.UserTask;

public class cv
  extends cu
{
  static cv a = null;
  
  private cv()
  {
    super("tbl_safe_msg");
  }
  
  public static cv a()
  {
    if (a == null) {
      a = new cv();
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
        Object localObject = new e();
        cr localcr = cr.a();
        cv localcv = cv.a();
        if (!localcr.o())
        {
          paramAnonymousVarArgs = localcr.q();
          localObject = paramAnonymousVarArgs;
          if (paramAnonymousVarArgs.b()) {}
        }
        do
        {
          do
          {
            return paramAnonymousVarArgs;
            if (localcr.e() == null)
            {
              ((e)localObject).b(103);
              return localObject;
            }
            if (localcr.k() != null) {
              break;
            }
            localObject = localcr.r();
            paramAnonymousVarArgs = (String[])localObject;
          } while (!((e)localObject).b());
          localObject = localcv.a(paramByte);
          paramAnonymousVarArgs = (String[])localObject;
        } while (!((e)localObject).b());
        ((e)localObject).c();
        return localObject;
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
    cb.a().a(0L, e, paramHandler);
  }
  
  public void b()
  {
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cv
 * JD-Core Version:    0.7.0.1
 */