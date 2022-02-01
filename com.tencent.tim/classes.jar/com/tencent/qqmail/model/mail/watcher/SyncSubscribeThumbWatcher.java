package com.tencent.qqmail.model.mail.watcher;

import android.graphics.Bitmap;
import moai.core.watcher.Watchers.Watcher;

public abstract interface SyncSubscribeThumbWatcher
  extends Watchers.Watcher
{
  public abstract void onError(int paramInt1, int paramInt2, String paramString, Object paramObject);
  
  public abstract void onLoading(int paramInt1, int paramInt2);
  
  public abstract void onSuccess(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.SyncSubscribeThumbWatcher
 * JD-Core Version:    0.7.0.1
 */