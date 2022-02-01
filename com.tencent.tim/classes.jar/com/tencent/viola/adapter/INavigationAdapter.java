package com.tencent.viola.adapter;

import com.tencent.viola.core.ViolaInstance;
import java.util.ArrayList;

public abstract interface INavigationAdapter
{
  public abstract ArrayList<String> getAdapterUnRegisterFunction();
  
  public abstract void invoke(String paramString, Object paramObject, OnInovkeCallback paramOnInovkeCallback, ViolaInstance paramViolaInstance);
  
  public abstract void registerModuleFunction();
  
  public static abstract interface OnInovkeCallback
  {
    public abstract void callback(String paramString);
    
    public abstract void setCallback(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.adapter.INavigationAdapter
 * JD-Core Version:    0.7.0.1
 */