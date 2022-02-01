package com.tencent.viola.module;

import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaInstance;

public class RouterModule
  extends BaseModule
{
  public static final String MODULE_NAME = "router";
  
  @JSMethod
  public void setCurrentInstanceId(String paramString)
  {
    ViolaInstance localViolaInstance = getViolaInstance();
    if (localViolaInstance == null) {
      return;
    }
    localViolaInstance.setCurrentVInstanceId(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.module.RouterModule
 * JD-Core Version:    0.7.0.1
 */