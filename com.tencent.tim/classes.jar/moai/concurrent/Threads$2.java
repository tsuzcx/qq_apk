package moai.concurrent;

final class Threads$2
  implements Runnable
{
  Threads$2(String paramString, Runnable paramRunnable) {}
  
  public void run()
  {
    new MThreadFactory(this.val$name, 2).newThread(this.val$r).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.concurrent.Threads.2
 * JD-Core Version:    0.7.0.1
 */