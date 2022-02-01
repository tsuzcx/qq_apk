package moai.patch.handle;

import android.os.Process;
import android.os.SystemClock;

final class ProcessKiller$1
  extends Thread
{
  ProcessKiller$1(long paramLong, int paramInt) {}
  
  public void run()
  {
    SystemClock.sleep(this.val$delay);
    Process.killProcess(this.val$pid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.ProcessKiller.1
 * JD-Core Version:    0.7.0.1
 */