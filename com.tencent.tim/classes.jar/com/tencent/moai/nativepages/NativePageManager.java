package com.tencent.moai.nativepages;

import android.content.Context;
import com.tencent.moai.nativepages.util.AppInfoUtil;
import com.tencent.moai.nativepages.util.AppInfoUtil.AppOperationDelegate;

public class NativePageManager
{
  private static NativePageManager instance;
  private String baseCachePath;
  private Context context;
  
  public static NativePageManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new NativePageManager();
      }
      return instance;
    }
    finally {}
  }
  
  public String getBaseCachePath()
  {
    return this.baseCachePath;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public void setAppOperationDelegate(AppInfoUtil.AppOperationDelegate paramAppOperationDelegate)
  {
    AppInfoUtil.setDelegate(paramAppOperationDelegate);
  }
  
  public void setBaseCachePath(String paramString)
  {
    this.baseCachePath = paramString;
  }
  
  public void setContext(Context paramContext)
  {
    this.context = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.NativePageManager
 * JD-Core Version:    0.7.0.1
 */