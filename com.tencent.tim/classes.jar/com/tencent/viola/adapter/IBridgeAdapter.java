package com.tencent.viola.adapter;

import com.tencent.viola.core.ViolaInstance;
import java.util.ArrayList;

public abstract interface IBridgeAdapter
{
  public static final String TITLE_CHANGE_TRANSPARENT = "change_title_transparent";
  
  public abstract ArrayList<String> getAdapterUnRegisterFunction();
  
  public abstract void registerModuleFunction();
  
  public abstract void titleUiInvoke(String paramString, Object paramObject, OnInovkeCallback paramOnInovkeCallback, ViolaInstance paramViolaInstance);
  
  public static abstract interface OnInovkeCallback
  {
    public abstract void callback(String paramString);
    
    public abstract void setCallback(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.adapter.IBridgeAdapter
 * JD-Core Version:    0.7.0.1
 */