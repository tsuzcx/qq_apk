package com.huawei.agconnect;

import android.annotation.SuppressLint;
import android.content.Context;
import com.huawei.agconnect.core.impl.AGConnectInstanceImpl;

public abstract class AGConnectInstance
{
  @SuppressLint({"StaticFieldLeak"})
  private static AGConnectInstance INSTANCE;
  
  public static AGConnectInstance getInstance()
  {
    return INSTANCE;
  }
  
  public static void initialize(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {}
    for (;;)
    {
      INSTANCE = new AGConnectInstanceImpl(paramContext);
      return;
      paramContext = localContext;
    }
  }
  
  public abstract Context getContext();
  
  public abstract <T> T getService(Class<T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.AGConnectInstance
 * JD-Core Version:    0.7.0.1
 */