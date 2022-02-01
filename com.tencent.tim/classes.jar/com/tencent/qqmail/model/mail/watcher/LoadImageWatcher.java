package com.tencent.qqmail.model.mail.watcher;

import android.graphics.Bitmap;
import moai.core.watcher.Watchers.Watcher;

public abstract interface LoadImageWatcher
  extends Watchers.Watcher
{
  public abstract void onError(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void onProcess(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3);
  
  public abstract void onSuccess(long paramLong, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.LoadImageWatcher
 * JD-Core Version:    0.7.0.1
 */