package com.tencent.qqmail.utilities.imageextention;

import android.graphics.Bitmap;

public class QMImageLoaderTask
  implements Runnable
{
  public static int STATE_CANCELED = 2;
  public static int STATE_PENDING = 0;
  public static int STATE_RUNNING = 1;
  private static final String TAG = "QMImageLoader";
  private LoadImageTaskCallback callback;
  public boolean isOOME = false;
  public String key;
  public Bitmap result;
  public int state = STATE_PENDING;
  
  public QMImageLoaderTask(String paramString, LoadImageTaskCallback paramLoadImageTaskCallback)
  {
    this.key = paramString;
    this.callback = paramLoadImageTaskCallback;
  }
  
  public void cancel()
  {
    this.state = STATE_CANCELED;
    this.callback = null;
    this.result = null;
  }
  
  public void recycle()
  {
    cancel();
    this.key = null;
  }
  
  public void run()
  {
    if (this.state != STATE_PENDING) {}
    do
    {
      return;
      this.state = STATE_RUNNING;
      if ((this.callback != null) && (this.state != STATE_CANCELED)) {
        this.callback.doInBackground(this);
      }
    } while ((this.callback == null) || (this.state == STATE_CANCELED));
    this.callback.onFinishLoading(this);
  }
  
  public static abstract interface LoadImageTaskCallback
  {
    public abstract void doInBackground(QMImageLoaderTask paramQMImageLoaderTask);
    
    public abstract void onFinishLoading(QMImageLoaderTask paramQMImageLoaderTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.imageextention.QMImageLoaderTask
 * JD-Core Version:    0.7.0.1
 */