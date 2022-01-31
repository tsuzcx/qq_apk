package com.tencent.mobileqq.app;

import java.util.List;

public class NearHornObserver
  implements BusinessObserver
{
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject == null) || (!paramObject.getClass().isArray())) {
      return;
    }
    paramObject = (Object[])paramObject;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (paramBoolean)
      {
        a(true, (List)paramObject[2], (Boolean)paramObject[1], (Boolean)paramObject[4], ((Integer)paramObject[0]).intValue(), (String)paramObject[3]);
        return;
      }
      a(false, null, Boolean.valueOf(false), Boolean.valueOf(false), ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 2: 
      if (paramBoolean)
      {
        a(true, (List)paramObject[2], ((Integer)paramObject[0]).intValue(), (String)paramObject[3]);
        return;
      }
      a(false, null, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 3: 
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 4: 
      if (paramBoolean)
      {
        a(true, (List)paramObject[2], (Boolean)paramObject[1], ((Integer)paramObject[0]).intValue(), (String)paramObject[3]);
        return;
      }
      a(false, null, Boolean.valueOf(false), ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    }
    a((String)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
  
  protected void a(String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, List paramList, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, List paramList, Boolean paramBoolean1, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, List paramList, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearHornObserver
 * JD-Core Version:    0.7.0.1
 */