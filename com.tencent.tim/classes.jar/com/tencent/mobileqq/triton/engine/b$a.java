package com.tencent.mobileqq.triton.engine;

import java.util.concurrent.atomic.AtomicInteger;

class b$a
  implements Runnable
{
  b$a(b paramb) {}
  
  public void run()
  {
    b.a(this.a).decrementAndGet();
    b.c localc = b.b(this.a);
    if (localc != null) {
      localc.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.b.a
 * JD-Core Version:    0.7.0.1
 */