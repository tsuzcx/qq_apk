package com.tencent.mobileqq.app;

import android.os.Bundle;

public class SecSvcObserver
  implements BusinessObserver
{
  public static final String a = "SecSvcObserver";
  
  protected void a(int paramInt, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void b(int paramInt, Bundle paramBundle) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      b(paramInt, (Bundle)paramObject);
      return;
    case 2: 
      a(paramInt, (Bundle)paramObject);
      return;
    }
    int i = 0;
    String str2 = "";
    String str1 = str2;
    paramInt = i;
    if (paramBoolean)
    {
      paramObject = (Bundle)paramObject;
      str1 = str2;
      paramInt = i;
      if (paramObject != null)
      {
        paramInt = paramObject.getInt("status");
        str1 = paramObject.getString("wording");
      }
    }
    a(paramBoolean, paramInt, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSvcObserver
 * JD-Core Version:    0.7.0.1
 */