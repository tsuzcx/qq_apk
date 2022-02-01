package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.internal.remote.a;

class p
  implements Runnable
{
  p(f paramf, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      ab.c("RemoteOpProxy", "<setInt> process:" + s.e() + ", getServiceInterface()");
      a locala = (a)this.c.getServiceInterface();
      if (locala != null) {
        locala.a(this.a, this.b);
      }
      return;
    }
    catch (Exception localException)
    {
      ab.c("RemoteOpProxy", "<setInt> process:" + s.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.p
 * JD-Core Version:    0.7.0.1
 */