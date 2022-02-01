package com.tencent.qmsp.sdk.c;

import com.tencent.qmsp.sdk.d.e;
import java.io.File;

final class k$b
  implements a.a
{
  public k.f a;
  
  k$b(k paramk) {}
  
  public void a()
  {
    this.a.d = 26;
  }
  
  public void run()
  {
    Object localObject = this.a.h;
    if ((localObject == null) || (((String)localObject).contains("..")))
    {
      this.a.d = 15;
      return;
    }
    localObject = new File(this.a.h);
    if (!((File)localObject).exists())
    {
      this.a.d = 12;
      return;
    }
    this.a.i = new o();
    int i = this.a.b;
    if ((i == 2) || (i == 1)) {}
    for (i = 1;; i = 0)
    {
      if ((i == 1) && (!e.b((File)localObject, null)))
      {
        this.a.d = 10;
        return;
      }
      localObject = new Object[1];
      k.f localf = this.a;
      localf.d = f.a(2L, localf.b, localf.a, 0L, localf.h, null, null, (Object[])localObject);
      if ((localObject[0] == null) || (!(localObject[0] instanceof Integer))) {
        break;
      }
      this.a.f = ((Integer)localObject[0]).intValue();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.k.b
 * JD-Core Version:    0.7.0.1
 */