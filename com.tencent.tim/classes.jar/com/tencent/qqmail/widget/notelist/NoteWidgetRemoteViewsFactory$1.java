package com.tencent.qqmail.widget.notelist;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.RemoteViews;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;

class NoteWidgetRemoteViewsFactory$1
  implements ImageDownloadListener
{
  NoteWidgetRemoteViewsFactory$1(NoteWidgetRemoteViewsFactory paramNoteWidgetRemoteViewsFactory, int paramInt, RemoteViews paramRemoteViews) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    QMLog.log(6, NoteWidgetRemoteViewsFactory.access$000(), "cannot find file: " + paramString + " position: " + this.val$position);
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    StringBuilder localStringBuilder;
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      paramString2 = NoteWidgetRemoteViewsFactory.access$000();
      localStringBuilder = new StringBuilder().append("bitmapRecycled2 ");
      if (paramBitmap != null) {
        break label107;
      }
    }
    label107:
    for (boolean bool = true;; bool = false)
    {
      QMLog.log(6, paramString2, bool);
      Log.d(NoteWidgetRemoteViewsFactory.access$000(), "LoadImageManager onSuccessInMainThread url: " + paramString1 + " position: " + this.val$position);
      this.val$rv.setImageViewBitmap(2131379637, paramBitmap);
      NoteWidgetManager.getInstance().notifyDataChange();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.notelist.NoteWidgetRemoteViewsFactory.1
 * JD-Core Version:    0.7.0.1
 */