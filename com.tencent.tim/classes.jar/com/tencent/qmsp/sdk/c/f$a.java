package com.tencent.qmsp.sdk.c;

import com.tencent.qmsp.sdk.f.g;

class f$a
  implements a.a
{
  f$a(f paramf) {}
  
  public void a()
  {
    g.a("Qp.QFW", 1, "Something wrong when load native so.");
  }
  
  public void run()
  {
    if (f.g()) {
      return;
    }
    try
    {
      if (!f.h()) {
        System.loadLibrary(f.b(0));
      }
      f.a(true);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.f.a
 * JD-Core Version:    0.7.0.1
 */