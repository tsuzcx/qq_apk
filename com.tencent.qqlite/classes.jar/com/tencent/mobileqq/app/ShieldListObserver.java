package com.tencent.mobileqq.app;

import java.util.ArrayList;
import java.util.List;

public class ShieldListObserver
  implements BusinessObserver
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  
  protected void a() {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, List paramList) {}
  
  protected void b(boolean paramBoolean, List paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject = null;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramObject = (long[])paramObject;
      int j = paramObject.length;
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Long.valueOf(paramObject[i]));
        i += 1;
      }
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean);
      return;
    case 2: 
      a(paramBoolean, localObject);
      return;
    case 3: 
      b(paramBoolean, localObject);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShieldListObserver
 * JD-Core Version:    0.7.0.1
 */