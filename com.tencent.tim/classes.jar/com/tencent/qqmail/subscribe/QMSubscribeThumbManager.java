package com.tencent.qqmail.subscribe;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.model.mail.cursor.QMSubscribeColumnCursor.Util;
import com.tencent.qqmail.model.mail.watcher.SyncSubscribeThumbWatcher;
import com.tencent.qqmail.qmimagecache.ImageCompresser;
import moai.core.watcher.Watchers;

public class QMSubscribeThumbManager
{
  private static QMSubscribeThumbManager ins_ = new QMSubscribeThumbManager();
  
  public static QMSubscribeThumbManager sharedInstance()
  {
    return ins_;
  }
  
  public final void bindSyncSubscribeThumbWatcher(SyncSubscribeThumbWatcher paramSyncSubscribeThumbWatcher, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Watchers.bind(paramSyncSubscribeThumbWatcher);
      return;
    }
    Watchers.unbind(paramSyncSubscribeThumbWatcher);
  }
  
  public Bitmap getBitmapFromCache(String paramString, int paramInt)
  {
    if (paramInt <= 0) {}
    for (paramInt = 2;; paramInt = 3)
    {
      paramString = ImageCompresser.getInstance().getBitmapFromMemCache(paramString, paramInt);
      if ((paramString == null) || (paramString.isRecycled())) {
        break;
      }
      return paramString;
    }
    return null;
  }
  
  public void loadSubscribeThumb(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (paramInt3 <= 0) {}
    for (int i = 2;; i = 3)
    {
      loadSubscribeThumb(paramInt2, paramString, i, new QMSubscribeThumbManager.1(this, paramInt1, paramInt3));
      return;
    }
  }
  
  public void loadSubscribeThumb(int paramInt1, String paramString, int paramInt2, ImageDownloadListener paramImageDownloadListener)
  {
    if (QMSubscribeColumnCursor.Util.isSnapUrl(paramString)) {}
    for (int i = 2;; i = 0)
    {
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.setAccountId(paramInt1);
      localDownloadInfo.setSessionType(i);
      localDownloadInfo.setUrl(paramString);
      localDownloadInfo.setImageDownloadListener(paramImageDownloadListener);
      ImageDownloadManager.shareInstance().fetchCompressImage(localDownloadInfo, paramInt2);
      return;
    }
  }
  
  protected final void triggerSyncSubscribeThumbError(int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    ((SyncSubscribeThumbWatcher)Watchers.of(SyncSubscribeThumbWatcher.class)).onError(paramInt1, paramInt2, paramString, paramObject);
  }
  
  protected final void triggerSyncSubscribeThumbLoading(int paramInt1, int paramInt2)
  {
    ((SyncSubscribeThumbWatcher)Watchers.of(SyncSubscribeThumbWatcher.class)).onLoading(paramInt1, paramInt2);
  }
  
  protected final void triggerSyncSubscribeThumbSuccess(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    ((SyncSubscribeThumbWatcher)Watchers.of(SyncSubscribeThumbWatcher.class)).onSuccess(paramInt1, paramInt2, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.QMSubscribeThumbManager
 * JD-Core Version:    0.7.0.1
 */