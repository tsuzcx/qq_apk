package moai.concurrent;

import android.os.Handler;

final class Threads$1
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Threads.access$100().post(new Threads.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.concurrent.Threads.1
 * JD-Core Version:    0.7.0.1
 */