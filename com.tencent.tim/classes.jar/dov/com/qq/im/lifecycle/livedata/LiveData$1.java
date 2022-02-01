package dov.com.qq.im.lifecycle.livedata;

import axzt;

public class LiveData$1
  implements Runnable
{
  public LiveData$1(axzt paramaxzt) {}
  
  public void run()
  {
    synchronized (axzt.a(this.this$0))
    {
      Object localObject2 = axzt.b(this.this$0);
      axzt.a(this.this$0, axzt.access$200());
      this.this$0.setValue(localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.lifecycle.livedata.LiveData.1
 * JD-Core Version:    0.7.0.1
 */