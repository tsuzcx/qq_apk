package com.tencent.token.global.taiji;

import java.util.concurrent.PriorityBlockingQueue;

public class CustomPriorityBlockingQueue<E>
  extends PriorityBlockingQueue<E>
{
  private static final String TAG = "CustomPriorityBlockingQueue";
  
  public CustomPriorityBlockingQueue(int paramInt)
  {
    super(paramInt);
  }
  
  public boolean offer(E paramE)
  {
    try
    {
      boolean bool = super.offer(paramE);
      return bool;
    }
    catch (Exception paramE)
    {
      paramE.printStackTrace();
    }
    return false;
  }
  
  public int size()
  {
    try
    {
      int i = super.size();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public E take()
  {
    try
    {
      Object localObject = super.take();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.CustomPriorityBlockingQueue
 * JD-Core Version:    0.7.0.1
 */