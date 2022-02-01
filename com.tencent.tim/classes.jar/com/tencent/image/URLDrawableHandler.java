package com.tencent.image;

public abstract interface URLDrawableHandler
{
  public abstract void doCancel();
  
  public abstract boolean isCancelled();
  
  public abstract void onFileDownloadFailed(int paramInt);
  
  public abstract void onFileDownloadStarted();
  
  public abstract void onFileDownloadSucceed(long paramLong);
  
  public abstract void publishProgress(int paramInt);
  
  public static class Adapter
    implements URLDrawableHandler
  {
    public void doCancel() {}
    
    public boolean isCancelled()
    {
      return false;
    }
    
    public void onFileDownloadFailed(int paramInt) {}
    
    public void onFileDownloadStarted() {}
    
    public void onFileDownloadSucceed(long paramLong) {}
    
    public void publishProgress(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.URLDrawableHandler
 * JD-Core Version:    0.7.0.1
 */