package mqq.util;

final class NativeUtil$1
  extends Thread
{
  NativeUtil$1(Process paramProcess) {}
  
  public void run()
  {
    try
    {
      this.val$process.waitFor();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.util.NativeUtil.1
 * JD-Core Version:    0.7.0.1
 */