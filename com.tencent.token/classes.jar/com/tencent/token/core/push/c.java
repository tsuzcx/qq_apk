package com.tencent.token.core.push;

import com.tencent.token.dn;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.UserTask;

class c
  extends UserTask
{
  c(b paramb) {}
  
  public f a(String... paramVarArgs)
  {
    return dn.a().b();
  }
  
  public void a(f paramf)
  {
    if (paramf.b())
    {
      b.b(1);
      return;
    }
    h.c("socket get config failed");
    b.b(6);
    b.a(this.a, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.c
 * JD-Core Version:    0.7.0.1
 */