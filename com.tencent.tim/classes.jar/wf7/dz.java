package wf7;

import java.util.concurrent.atomic.AtomicInteger;

public class dz
{
  private boolean lw = false;
  private AtomicInteger lx = new AtomicInteger();
  
  public boolean cq()
  {
    return this.lw;
  }
  
  public void setState(int paramInt)
  {
    this.lx.set(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.dz
 * JD-Core Version:    0.7.0.1
 */