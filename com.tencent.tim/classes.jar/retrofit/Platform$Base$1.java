package retrofit;

import java.util.concurrent.ThreadFactory;

class Platform$Base$1
  implements ThreadFactory
{
  Platform$Base$1(Platform.Base paramBase) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(new Platform.Base.1.1(this, paramRunnable), "Retrofit-Idle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.Platform.Base.1
 * JD-Core Version:    0.7.0.1
 */