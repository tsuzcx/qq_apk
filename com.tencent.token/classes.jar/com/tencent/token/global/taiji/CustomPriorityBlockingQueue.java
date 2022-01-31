package com.tencent.token.global.taiji;

import java.util.concurrent.PriorityBlockingQueue;

public class CustomPriorityBlockingQueue
  extends PriorityBlockingQueue
{
  private static final String TAG = "CustomPriorityBlockingQueue";
  
  public CustomPriorityBlockingQueue(int paramInt)
  {
    super(paramInt);
  }
  
  public boolean offer(Object paramObject)
  {
    try
    {
      boolean bool = super.offer(paramObject);
      return bool;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
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
  
  public Object take()
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