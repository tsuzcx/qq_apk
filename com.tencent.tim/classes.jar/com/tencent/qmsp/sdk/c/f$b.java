package com.tencent.qmsp.sdk.c;

import com.tencent.qmsp.sdk.a.c;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.g;

class f$b
  implements a.a
{
  f$b(f paramf) {}
  
  public void a()
  {
    g.a("Qp.QFW", 1, "Something wrong when init native.");
  }
  
  public void run()
  {
    if ((!f.g()) || (f.a(this.a))) {
      return;
    }
    try
    {
      Object[] arrayOfObject = new Object[1];
      if ((f.a(1L, 512L, c.g(), 0L, f.b(this.a), QmspSDK.getContext(), null, arrayOfObject) == 0) && (arrayOfObject[0] != null) && ((arrayOfObject[0] instanceof Integer)))
      {
        f.a(this.a, ((Integer)arrayOfObject[0]).intValue());
        f.c(this.a);
        f.a(this.a, true);
      }
      g.a("Qp.QFW", 1, String.format("Native ver: %d(%s)", new Object[] { Integer.valueOf(f.c(this.a)), c.a(f.c(this.a)) }));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.f.b
 * JD-Core Version:    0.7.0.1
 */