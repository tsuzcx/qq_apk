package com.tencent.qqmini.miniapp.plugin;

import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient;

public abstract interface IExtendedEmbeddedWidgetClient
  extends IEmbeddedWidgetClient
{
  public abstract void nativeDestroy();
  
  public abstract void nativePause();
  
  public abstract void nativeResume();
  
  public abstract void webViewDestory();
  
  public abstract void webViewPause();
  
  public abstract void webViewResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */