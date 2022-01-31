package com.tencent.mobileqq.app;

public class QvipSpecialCareObserver
  implements BusinessObserver
{
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1000: 
      a(paramObject);
      return;
    }
    b(paramObject);
  }
  
  public void a(Object paramObject) {}
  
  public void b(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QvipSpecialCareObserver
 * JD-Core Version:    0.7.0.1
 */