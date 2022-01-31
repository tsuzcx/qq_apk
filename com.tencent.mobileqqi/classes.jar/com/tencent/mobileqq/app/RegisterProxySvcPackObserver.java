package com.tencent.mobileqq.app;

public class RegisterProxySvcPackObserver
  implements BusinessObserver
{
  protected void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (paramObject == null);
    paramObject = (Object[])paramObject;
    a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RegisterProxySvcPackObserver
 * JD-Core Version:    0.7.0.1
 */