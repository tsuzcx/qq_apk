package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.e;
import com.tencent.token.utils.UserTask;

public class cu
  extends ct
{
  static cu a = null;
  
  private cu()
  {
    super("tbl_safe_msg");
  }
  
  public static cu a()
  {
    if (a == null) {
      a = new cu();
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
        cq localcq = cq.a();
        cu localcu = cu.a();
        if (!localcq.o())
        {
          paramAnonymousVarArgs = localcq.q();
          localObject = paramAnonymousVarArgs;
          if (paramAnonymousVarArgs.b()) {}
        }
        do
        {
          do
          {
            return paramAnonymousVarArgs;
            if (localcq.e() == null)
            {
              ((e)localObject).b(103);
              return localObject;
            }
            if (localcq.k() != null) {
              break;
            }
            localObject = localcq.r();
            paramAnonymousVarArgs = (String[])localObject;
          } while (!((e)localObject).b());
          localObject = localcu.a(paramByte);
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
    ca.a().a(0L, e, paramHandler);
  }
  
  public void b()
  {
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cu
 * JD-Core Version:    0.7.0.1
 */