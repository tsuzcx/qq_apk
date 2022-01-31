package com.tencent.service.update;

import com.tencent.service.d;
import com.tmsdk.TMSDKContext;

class n
  implements Runnable
{
  n(k paramk, d paramd) {}
  
  public void run()
  {
    new UpdateDownloadDialog(k.a(this.b), 2131362182, this.a).show();
    this.b.a(4, 1);
    k.b(this.b).f(System.currentTimeMillis() + k.b(this.b).v());
    TMSDKContext.saveActionData(1150106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.n
 * JD-Core Version:    0.7.0.1
 */