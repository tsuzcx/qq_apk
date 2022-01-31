package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.d;
import com.tencent.token.utils.s;

final class bo
  implements bp
{
  bo(bn parambn) {}
  
  public final void a(fs paramfs, d paramd)
  {
    int i;
    if (paramd.a == 0)
    {
      i = 1;
      if (i == 0) {
        break label83;
      }
      v.a().a(System.currentTimeMillis(), 0, paramfs.a, 0, "", s.i());
      if (!paramfs.e)
      {
        paramd = paramfs.d.obtainMessage(paramfs.f);
        paramd.arg1 = 0;
        paramd.sendToTarget();
        paramfs.e = true;
      }
    }
    label190:
    for (;;)
    {
      bn.a(this.a).b(paramfs);
      return;
      i = 0;
      break;
      label83:
      if (paramd.a < 10000) {
        v.a().a(System.currentTimeMillis(), 0, paramfs.a, 0, "", s.i());
      }
      for (;;)
      {
        if (paramfs.e) {
          break label190;
        }
        Message localMessage = paramfs.d.obtainMessage(paramfs.f);
        localMessage.arg1 = paramd.a;
        localMessage.obj = paramd;
        localMessage.sendToTarget();
        paramfs.e = true;
        break;
        v.a().a(System.currentTimeMillis(), v.a(paramd.a), paramfs.a, 1, paramd.b, s.i());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bo
 * JD-Core Version:    0.7.0.1
 */