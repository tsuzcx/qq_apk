package com.tencent.mobileqq.app;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;

public class StrangerObserver
  implements BusinessObserver
{
  public void a(List paramList) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField paramPBRepeatMessageField) {}
  
  public void a(boolean paramBoolean, List paramList) {}
  
  public void b(List paramList) {}
  
  public void b(boolean paramBoolean, List paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      if (paramBoolean) {
        a((List)paramObject);
      }
    }
    do
    {
      return;
      b((List)paramObject);
      return;
      if (paramInt == 3)
      {
        a(paramBoolean, (List)paramObject);
        return;
      }
      if (paramInt == 2)
      {
        b(paramBoolean, (List)paramObject);
        return;
      }
    } while (paramInt != 4);
    a(paramBoolean, (PBRepeatMessageField)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.StrangerObserver
 * JD-Core Version:    0.7.0.1
 */