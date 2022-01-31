package com.tencent.mobileqq.app;

import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

public class SubAccountBindObserver
  implements BusinessObserver
{
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      b(paramBoolean, (SubAccountBackProtocData)paramObject);
      return;
    case 1: 
      c(paramBoolean, (SubAccountBackProtocData)paramObject);
      return;
    }
    a(paramBoolean, (SubAccountBackProtocData)paramObject);
  }
  
  public void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  public void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  public void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SubAccountBindObserver
 * JD-Core Version:    0.7.0.1
 */