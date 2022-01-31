package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.f;
import com.tencent.token.utils.UserTask;

class dv
  extends UserTask
{
  dv(du paramdu, byte paramByte, Handler paramHandler) {}
  
  public f a(String... paramVarArgs)
  {
    Object localObject = new f();
    do localdo = do.a();
    du localdu = du.a();
    if (!localdo.o())
    {
      paramVarArgs = localdo.q();
      localObject = paramVarArgs;
      if (paramVarArgs.b()) {}
    }
    do
    {
      do
      {
        return paramVarArgs;
        if (localdo.e() == null)
        {
          ((f)localObject).b(103);
          return localObject;
        }
        if (localdo.k() != null) {
          break;
        }
        localObject = localdo.r();
        paramVarArgs = (String[])localObject;
      } while (!((f)localObject).b());
      localObject = localdu.a(this.a);
      paramVarArgs = (String[])localObject;
    } while (!((f)localObject).b());
    ((f)localObject).c();
    return localObject;
  }
  
  public void a(f paramf)
  {
    Message localMessage = this.b.obtainMessage();
    localMessage.what = 1002;
    localMessage.arg1 = paramf.a;
    localMessage.obj = paramf;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dv
 * JD-Core Version:    0.7.0.1
 */