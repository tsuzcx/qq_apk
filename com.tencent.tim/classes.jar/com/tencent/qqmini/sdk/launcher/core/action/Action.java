package com.tencent.qqmini.sdk.launcher.core.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;

public abstract interface Action<T>
{
  public static final String TAG = "Action";
  
  public abstract T perform(BaseRuntime paramBaseRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.action.Action
 * JD-Core Version:    0.7.0.1
 */