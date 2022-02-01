package c.t.m.g;

import java.util.concurrent.ThreadFactory;

final class ap$1
  implements ThreadFactory
{
  ap$1(ap paramap) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "locationsdk_network_request_pool");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.ap.1
 * JD-Core Version:    0.7.0.1
 */