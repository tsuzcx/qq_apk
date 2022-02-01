package com.tencent.tbs.one.impl.a;

import java.io.File;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    try
    {
      b localb = this.a;
      File localFile = this.a.b;
      b.1.1 local1 = new b.1.1(this);
      long l = this.a.c;
      localb.d = ((j)j.a(new j.1(local1, localFile), localFile, l));
      this.a.c();
      return;
    }
    catch (Exception localException)
    {
      this.a.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.b.1
 * JD-Core Version:    0.7.0.1
 */