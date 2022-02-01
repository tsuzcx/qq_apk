package com.tencent.qqmail.activity.media;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qqmail.utilities.imageextention.QMImageLoader.QMImageLoaderCallback;
import com.tencent.qqmail.utilities.imageextention.QMImageLoaderTask;

class MediaItemInfo$1
  implements QMImageLoader.QMImageLoaderCallback
{
  MediaItemInfo$1(MediaItemInfo paramMediaItemInfo, ImageView paramImageView) {}
  
  public void handleFinishLoadingImage(QMImageLoaderTask paramQMImageLoaderTask)
  {
    if ((paramQMImageLoaderTask.result != null) && (this.val$imageView.getId() == MediaItemInfo.access$100(this.this$0))) {
      this.val$imageView.setImageBitmap(paramQMImageLoaderTask.result);
    }
  }
  
  public void loadImageInBackground(QMImageLoaderTask paramQMImageLoaderTask)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = MediaItemInfo.access$000(this.this$0, true);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        paramQMImageLoaderTask.isOOME = true;
      }
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    paramQMImageLoaderTask.result = localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaItemInfo.1
 * JD-Core Version:    0.7.0.1
 */