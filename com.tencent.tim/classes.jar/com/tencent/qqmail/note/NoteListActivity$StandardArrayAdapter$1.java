package com.tencent.qqmail.note;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;

class NoteListActivity$StandardArrayAdapter$1
  implements ImageDownloadListener
{
  NoteListActivity$StandardArrayAdapter$1(NoteListActivity.StandardArrayAdapter paramStandardArrayAdapter, ImageView paramImageView) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    QMLog.log(6, "NoteListActivity", "cannotfindfile:" + paramString);
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      paramString2 = new StringBuilder().append("bitmaprecycled2 ");
      if (paramBitmap != null) {
        break label79;
      }
    }
    label79:
    for (boolean bool = true;; bool = false)
    {
      QMLog.log(4, "NoteListActivity", bool);
      if ((this.val$image.getTag() != null) && (this.val$image.getTag().equals(paramString1))) {
        this.val$image.setImageBitmap(paramBitmap);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.StandardArrayAdapter.1
 * JD-Core Version:    0.7.0.1
 */