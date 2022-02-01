import android.os.Looper;

public class njk
{
  private int aZm = this.mMainThread.getPriority();
  private int aZn;
  private Thread e;
  private Thread mMainThread = Looper.getMainLooper().getThread();
  
  public njk()
  {
    for (ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup(); localThreadGroup.getParent() != null; localThreadGroup = localThreadGroup.getParent()) {}
    Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
    localThreadGroup.enumerate(arrayOfThread);
    int i = 0;
    for (;;)
    {
      if (i < arrayOfThread.length)
      {
        if ((arrayOfThread[i] != null) && (arrayOfThread[i].isAlive()) && (arrayOfThread[i].getName().equalsIgnoreCase("RenderThread")))
        {
          this.e = arrayOfThread[i];
          this.aZn = this.e.getPriority();
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void aYn()
  {
    this.mMainThread.setPriority(10);
    if (this.e != null) {
      this.e.setPriority(10);
    }
  }
  
  public void aYo()
  {
    this.mMainThread.setPriority(this.aZm);
    if (this.e != null) {
      this.e.setPriority(this.aZn);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("main:" + this.mMainThread.getPriority());
    if (this.e != null) {
      localStringBuilder.append(" render:" + this.e.getPriority());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njk
 * JD-Core Version:    0.7.0.1
 */