package com.tencent.qqmini.sdk.launcher.core;

import com.tencent.qqmini.sdk.annotation.MiniKeep;

@MiniKeep
public abstract interface IProxyManager
{
  public abstract <T> T get(Class paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.IProxyManager
 * JD-Core Version:    0.7.0.1
 */