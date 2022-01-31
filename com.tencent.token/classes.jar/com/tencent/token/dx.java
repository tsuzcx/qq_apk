package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.f;
import com.tencent.token.utils.UserTask;

class dx
  extends UserTask
{
  dx(dw paramdw, int paramInt, Handler paramHandler) {}
  
  public f a(String... paramVarArgs)
  {
    return this.c.a(this.a);
  }
  
  public void a(f paramf)
  {
    Message localMessage = new Message();
    localMessage.arg1 = this.a;
    if ((paramf.b()) && (1 == dw.a(this.c))) {}
    for (localMessage.what = 1011;; localMessage.what = 1010)
    {
      if (this.b != null) {
        this.b.sendMessage(localMessage);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dx
 * JD-Core Version:    0.7.0.1
 */