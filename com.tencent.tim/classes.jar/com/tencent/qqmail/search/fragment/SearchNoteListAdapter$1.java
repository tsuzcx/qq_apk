package com.tencent.qqmail.search.fragment;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;
import org.apache.commons.lang3.StringUtils;

class SearchNoteListAdapter$1
  implements ImageDownloadListener
{
  SearchNoteListAdapter$1(SearchNoteListAdapter paramSearchNoteListAdapter, ImageView paramImageView) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    if ((paramString != null) && (paramObject != null)) {
      QMLog.log(6, "searchNoteLoadThumbnailError", "file:" + paramString + paramObject.toString());
    }
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (StringUtils.equals(this.val$image.getTag().toString(), paramString1)) {
      this.val$image.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListAdapter.1
 * JD-Core Version:    0.7.0.1
 */