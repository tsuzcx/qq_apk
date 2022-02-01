package retrofit;

import java.util.concurrent.ThreadFactory;

class Platform$Android$1
  implements ThreadFactory
{
  Platform$Android$1(Platform.Android paramAndroid) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(new Platform.Android.1.1(this, paramRunnable), "Retrofit-Idle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.Platform.Android.1
 * JD-Core Version:    0.7.0.1
 */