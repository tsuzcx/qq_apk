package com.tencent.token.upload.useraction;

import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.UserTask;

class b
  extends UserTask
{
  b(a parama) {}
  
  public f a(String... paramVarArgs)
  {
    return a.a(this.a, this.a.h);
  }
  
  public void a()
  {
    a.a(this.a, false);
  }
  
  public void a(f paramf)
  {
    if (paramf.b()) {
      a.b(a.g());
    }
    for (;;)
    {
      a.a(this.a, false);
      return;
      h.c("post click flow msg failed:" + paramf.a + "-" + paramf.b);
      if (a.h() < a.i()) {}
      try
      {
        a.b(a.i());
      }
      catch (Exception paramf)
      {
        continue;
        a.b(a.g());
      }
      catch (Error paramf) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.useraction.b
 * JD-Core Version:    0.7.0.1
 */