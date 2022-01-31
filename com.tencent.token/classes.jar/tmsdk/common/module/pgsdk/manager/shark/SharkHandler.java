package tmsdk.common.module.pgsdk.manager.shark;

import java.util.concurrent.atomic.AtomicInteger;

public class SharkHandler
{
  public static final int STATE_FINISH = 2;
  public static final int STATE_PANDING = 0;
  public static final int STATE_SENDING = 1;
  private boolean a = false;
  private AtomicInteger b = new AtomicInteger();
  
  public boolean cancel()
  {
    this.a = true;
    return false;
  }
  
  public int getState()
  {
    return this.b.get();
  }
  
  public boolean isCancel()
  {
    return this.a;
  }
  
  public void setState(int paramInt)
  {
    this.b.set(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.shark.SharkHandler
 * JD-Core Version:    0.7.0.1
 */