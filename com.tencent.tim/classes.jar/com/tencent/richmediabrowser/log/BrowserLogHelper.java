package com.tencent.richmediabrowser.log;

public class BrowserLogHelper
{
  private IBrowserLog mGalleryLog;
  
  public static BrowserLogHelper getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  public IBrowserLog getGalleryLog()
  {
    if (this.mGalleryLog == null) {
      this.mGalleryLog = new BrowserLog();
    }
    return this.mGalleryLog;
  }
  
  public void setLogProxy(IBrowserLog paramIBrowserLog)
  {
    this.mGalleryLog = paramIBrowserLog;
  }
  
  static class SingletonHolder
  {
    private static final BrowserLogHelper INSTANCE = new BrowserLogHelper(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.log.BrowserLogHelper
 * JD-Core Version:    0.7.0.1
 */