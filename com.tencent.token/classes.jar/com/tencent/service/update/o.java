package com.tencent.service.update;

import com.tencent.service.d;

class o
  implements Runnable
{
  o(k paramk, d paramd) {}
  
  public void run()
  {
    if (k.a(this.b) != null)
    {
      new UpdateDownloadDialog(k.a(this.b), 2131362182, this.a).show();
      this.b.a(4, 1);
      k.b(this.b).f(System.currentTimeMillis() + k.b(this.b).v());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.o
 * JD-Core Version:    0.7.0.1
 */