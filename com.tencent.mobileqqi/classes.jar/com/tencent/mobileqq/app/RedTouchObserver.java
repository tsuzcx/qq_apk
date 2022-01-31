package com.tencent.mobileqq.app;

public class RedTouchObserver
  implements BusinessObserver
{
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    a(paramBoolean, paramObject);
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RedTouchObserver
 * JD-Core Version:    0.7.0.1
 */