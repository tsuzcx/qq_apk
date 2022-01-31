package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.f;
import com.tencent.token.utils.UserTask;

class dp
  extends UserTask
{
  dp(do paramdo, Handler paramHandler) {}
  
  public f a(String... paramVarArgs)
  {
    return this.b.q();
  }
  
  public void a(f paramf)
  {
    Message localMessage = this.a.obtainMessage();
    localMessage.what = 1008;
    localMessage.arg1 = paramf.a;
    localMessage.obj = paramf;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dp
 * JD-Core Version:    0.7.0.1
 */